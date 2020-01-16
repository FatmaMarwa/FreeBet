import {Injectable} from '@angular/core';



import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConfigService} from '../app-config.service';
import {AdminHttpService} from '../admin/admin-http.service';
import {Login} from './Login';

class BettorHttpServices {
}

@Injectable({
  providedIn: 'root'
})
export class LoginHttpService {

  logins: Array<Login>;

  constructor(private appConfig: AppConfigService, private loginService: LoginHttpService, private adminService: AdminHttpService, private bettorServices: BettorHttpServices, private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Login>>(this.appConfig.backEnd + 'login').subscribe(resp => {
        this.logins = resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Login> {
    return this.logins;
  }

  findById(id: number): Observable<Login> {
    return this.http.get<Login>(this.appConfig.backEnd + 'login/' + id);
  }

  save(login: Login) {
    if (login) {
      if (login.admin && !login.admin.id) {
        login.admin = null;
      }
      if (login.bettor && !login.bettor.id) {
        login.bettor = null;
      }
      if (!login.id) {
        this.http.post<Login>(this.appConfig.backEnd + 'login', login).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      } else {
        this.http.put<Login>(this.appConfig.backEnd + 'login/' + login.id, login).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      }
    }
  }

  delete(id: number) {
    this.http.delete<Login>(this.appConfig.backEnd + 'login/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }
}

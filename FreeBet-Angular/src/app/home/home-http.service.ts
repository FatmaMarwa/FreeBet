import {Injectable} from "@angular/core";
import {BehaviorSubject, config, Observable} from "rxjs";
import {Bettor} from "../Model/bettor";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {AppConfigService} from "../app-config.service";
import {Router} from "@angular/router";
import {Login} from '../Model/Login';

@Injectable({ providedIn: 'root' })
export class HomeService {

  public log: Login = null;
  public currentBettor: Bettor;
  public router:Router;

  constructor(private appConfig: AppConfigService,private http: HttpClient) {
  }


  login(pseudo: String, motDePasse: String) {
    this.http.get<Login>(this.appConfig.backEnd + 'login/' + pseudo + '/' + motDePasse).subscribe(resp => {
        this.log = resp;

        if(this.log.admin) {

        } else {

        }
        console.log(this.currentBettor);
        if (this.currentBettor) {
          localStorage.setItem('bettorConnected', JSON.stringify(this.currentBettor));
          this.router.navigate(['home']);
        }
      },
      error => console.log(error));
  }

  logout() {
    // remove bettor from local storage to log bettor out
    localStorage.removeItem('currentBettor');
    localStorage.clear();
    this.router.navigate(['']);
  }
}

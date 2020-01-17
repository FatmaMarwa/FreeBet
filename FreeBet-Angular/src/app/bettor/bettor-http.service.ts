import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BetHttpService} from "../bet/bet-http.service";
import {AppConfigService} from "../app-config.service";
import {Bettor} from "../Model/bettor";
import {LoginHttpService} from "../login/login-http.service";

@Injectable({
  providedIn: 'root'
})

export class BettorHttpService{
  bettors:Array<Bettor>;

  civilites:Array<string>

  constructor(private appConfig: AppConfigService,private http: HttpClient) {
    this.load();
    this.loadCiv();
  }

  load() {
    this.http.get<Array<Bettor>>(this.appConfig.backEnd + 'bettor').subscribe(resp => {
        this.bettors = resp;
      },
      err => console.log(err));
  }

  loadCiv(){
    this.http.get<Array<string>>(this.appConfig.backEnd+ 'bettor/civilites').subscribe(resp =>{
        this.civilites=resp;
      },
      err => console.log(err));
  }
  findAll(): Array<Bettor> {
    return this.bettors;
  }

  findById(id: number): Observable<Bettor> {
    return this.http.get<Bettor>(this.appConfig.backEnd + 'bettor/' + id);
  }

  save(bettor: Bettor) {
    if (bettor) {
      if (!bettor.id) {
        this.http.post<Bettor>(this.appConfig.backEnd + 'bettor', bettor).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      } else {
        this.http.put<Bettor>(this.appConfig.backEnd + 'bettor/' + bettor.id, bettor).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      }
    }
  }

  delete(id: number) {
    this.http.delete<Bettor>(this.appConfig.backEnd + 'bettor/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }

}

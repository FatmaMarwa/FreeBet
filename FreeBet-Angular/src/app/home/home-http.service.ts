import {Injectable} from "@angular/core";
import {BehaviorSubject, config, Observable} from "rxjs";
import {Bettor} from "../Model/bettor";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {AppConfigService} from "../app-config.service";
import {Router} from "@angular/router";
import {Login} from '../Model/Login';
import {Admin} from "../Model/admin";

@Injectable({ providedIn: 'root' })
export class HomeService {

  public log: Login = null;
  public currentBettor: Bettor;
  public currentAdmin:Admin;

  constructor(private appConfig: AppConfigService,private http: HttpClient, private router: Router) {
  }


  login(pseudo: string, motDePasse: string) {
    this.http.get<Login>(this.appConfig.backEnd + 'login/' + pseudo + '/' + motDePasse).subscribe(resp => {
        this.log = resp;
        this.log.connected = true;
        if(this.log.admin) {
          localStorage.setItem('userConnected',JSON.stringify(this.log));
          console.log('userConnected')
        } else if (this.log.bettor){
          localStorage.setItem('userConnected', JSON.stringify(this.log));
          console.log('userConnected')
        }
         this.router.navigate(['/home']);
      },
      error => console.log(error));
  }

  refreshLogin() {
    this.http.get<Login>(this.appConfig.backEnd + 'login/' + this.logInfo().id).subscribe(resp => {
        this.log = resp;
        this.log.connected = true;
        if(this.log.admin) {
          localStorage.setItem('userConnected',JSON.stringify(this.log));
          console.log('userConnected')
        } else if (this.log.bettor){
          localStorage.setItem('userConnected', JSON.stringify(this.log));
          console.log('userConnected')
        }
        this.router.navigate(['/home']);
      },
      error => console.log(error));
  }

  logout() {
    // remove bettor from local storage to log bettor out
    localStorage.removeItem('userConnected');
    localStorage.clear();
    this.router.navigate(['/home']);
  }

  logInfo(): Login {
    if(localStorage.getItem('userConnected')) {
      return JSON.parse(localStorage.getItem('userConnected'));
    }

    return new Login();
  }
}

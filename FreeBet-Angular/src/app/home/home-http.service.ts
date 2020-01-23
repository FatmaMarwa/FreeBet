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
  public router:Router;

  constructor(private appConfig: AppConfigService,private http: HttpClient) {
  }


  login(pseudo: string, motDePasse: string) {
    this.http.get<Login>(this.appConfig.backEnd + 'login/' + pseudo + '/' + motDePasse).subscribe(resp => {
        this.log = resp;
        console.log(this.log);
        if(this.log.admin) {
          localStorage.setItem('userConnected',JSON.stringify(this.currentAdmin));
          console.log('userConnected')
        } else if (this.log.bettor){
          localStorage.setItem('userConnected', JSON.stringify(this.currentBettor));
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
    this.router.navigate(['']);
  }
}

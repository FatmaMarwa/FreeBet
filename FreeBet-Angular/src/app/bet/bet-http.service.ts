import {Injectable} from "@angular/core";
import {Bet} from "../Model/bet";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from '../app-config.service';
import {BettorHttpService} from "../bettor/bettor-http.service";
import {GameHttpService} from "../game/game-http.service";

@Injectable({
  providedIn: 'root'
})

export class BetHttpService{
  bets:Array<Bet>;

  typesBets:Array<string>;

  constructor(private appConfig: AppConfigService,private http: HttpClient) {
    this.load();
    this.loadTypeBet();
  }

  load() {
    this.http.get<Array<Bet>>(this.appConfig.backEnd + 'bet').subscribe(resp => {
        this.bets = resp;
      },
      err => console.log(err));
  }

  loadTypeBet(){
    this.http.get<Array<string>>(this.appConfig.backEnd+ 'bet/typeBet').subscribe(resp =>{
        this.typesBets=resp;
      },
      err => console.log(err));
  }

  findAll(): Array<Bet> {
    return this.bets;
  }

  findById(id: number): Observable<Bet> {
    return this.http.get<Bet>(this.appConfig.backEnd + 'bet/' + id);
  }

  save(bet: Bet) {
    if (bet) {
      if (bet.bettorr && !bet.bettorr.id) {
        bet.bettorr = null;
      }
      if (!bet.id) {
        this.http.post<Bet>(this.appConfig.backEnd + 'bet', bet).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      } else {
        this.http.put<Bet>(this.appConfig.backEnd + 'bet/' + bet.id, bet).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      }
    }
  }

  delete(id: number) {
    this.http.delete<Bet>(this.appConfig.backEnd + 'bet/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }
}

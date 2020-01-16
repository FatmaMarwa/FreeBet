import {Injectable} from "@angular/core";
import {Bet} from "../Model/bet";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfigService} from '../app-config.service';
import {BettorHttpService} from "../bettor/bettor-http.service";

@Injectable({
  providedIn: 'root'
})

export class BetHttpService{
  bets:Array<Bet>;

  constructor(private appConfig: AppConfigService, private bettorService: BettorHttpService, private gameService: GameHttpService,private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Array<Bet>>(this.appConfig.backEnd + 'bet').subscribe(resp => {
        this.bets = resp;
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
      if (bet.bettor && !bet.bettor.id) {
        bet.bettor = null;
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

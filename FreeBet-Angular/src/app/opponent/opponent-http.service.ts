import {Injectable} from '@angular/core';
import {Opponent} from '../Model/opponent';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConfigService} from '../app-config.service';
import {SportHttpService} from '../sport/sport-http.service';
import {GameHttpService} from '../game/game-http.service';
import {Sport} from '../Model/sport';

@Injectable({
  providedIn: 'root'
})

export class OpponentHttpService {

  opponents: Array<Opponent>
  championnats: Array<string> = ["NBA", "PremierLeague", "Ligue 1", "TOP14", "ATP"];

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
  }
  load() {
    this.http.get<Array<Opponent>>(this.appConfig.backEnd + 'opponent').subscribe(resp => {
        this.opponents = resp;
      },
      err => console.log(err));
  }
  findAll(): Array<Opponent>{
    return this.opponents;
  }
  findById(id: number): Observable<Opponent>{
    return this.http.get<Opponent>(this.appConfig.backEnd + 'opponent/' + id);
  }

  save(opponent: Opponent) {
    if (opponent) {
      if (opponent.sport_opponent) {
        opponent.sport_opponent = null;
      }
      if (opponent.game_opponent) {
        opponent.game_opponent = null;
      }
      if (!opponent.id) {
        console.log(opponent);
        this.http.post<Opponent>(this.appConfig.backEnd + 'opponent', opponent).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      } else {
        this.http.put<Opponent>(this.appConfig.backEnd + 'opponent/' + opponent.id, opponent).subscribe(resp => {
          this.load();
        }, err => console.log(err));
      }
    }
  }
  delete(id: number){
    this.http.delete<Opponent>(this.appConfig.backEnd + 'opponent/' + id).subscribe(resp =>{
      this.load()
    }, err => console.log(err));
  }
}

import {Injectable} from '@angular/core';
import {Game} from './game';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConfigService} from '../app-config.service';
import {BetHttpService} from '../bet/bet-http.service';
import {OpponentHttpService} from '../opponent/opponent-http.service';
import {SportHttpService} from '../sport/sport-http.service';
import {Bet} from '../Model/bet';
import {Opponent} from '../opponent/opponent';
import {Statistique} from '../Model/statistique';

@Injectable({
  providedIn: 'root'
})
export class GameHttpService {
  games: Array<Game>;


  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.load();
    console.log("dkdjsqkjisnfqsd");

  }

  load() {
    this.http.get<Array<Game>>(this.appConfig.backEnd + 'game').subscribe(resp => {
        this.games = resp;
      },
      err => console.log(err));


  }
  findAll(): Array<Game>{
    return this.games;
  }

  findById(id: number): Observable<Game>{
    return this.http.get<Game>(this.appConfig.backEnd + 'game/' + id);
  }

  save(game: Game){
    if(game){
      if (game.opponents){
        game.opponents = null;
      }
      if (game.sport && !game.sport.id){
        game.sport = null;
      }
      if(!game.id){
        this.http.post<Game>(this.appConfig.backEnd + 'game/' + game.id, game).subscribe( resp =>{
          this.load();
        }, err => console.log(err));
      }else {
        this.http.put<Game>(this.appConfig.backEnd + 'game/' + game.id, game).subscribe(resp =>{
          this.load();
        }, err => console.log(err));
      }
    }
  }

  delete(id: number){
    this.http.delete<Game>(this.appConfig.backEnd + 'game/' + id).subscribe(resp =>{
      this.load()
    }, err => console.log(err));
  }

}

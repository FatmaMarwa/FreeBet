import {Sport} from '../Model/sport';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {OpponentHttpService} from '../opponent/opponent-http.service';
import {GameHttpService} from '../game/game-http.service';
import {AppConfigService} from '../app-config.service';

@Injectable({
  providedIn: 'root'
})

export class SportHttpService {

  sports: Array<Sport>;

  typeSports: Array<string>;

  constructor(private appConfig: AppConfigService, private  http: HttpClient, private gameService: GameHttpService, private opponentService: OpponentHttpService) {
    this.load();
  }

  load() {
    this.http.get<Array<Sport>>(this.appConfig.backEnd + 'sport').subscribe(resp => {
        this.sports = resp;
      },
      err => console.log(err));

  }

  findAll(): Array<Sport> {
    return this.sports;
  }

  findById(id: number): Observable<Sport> {
    return this.http.get<Sport>(this.appConfig.backEnd + 'sport/' + id);
  }

  save(sport: Sport) {
    if (sport.id) {
      this.http.post<Sport>(this.appConfig.backEnd + 'sport', sport).subscribe(resp => {
        this.load();
      }, err => console.log(err));
    }
  }

  delete(id: number) {
    this.http.delete<Sport>(this.appConfig.backEnd + 'sport/' + id).subscribe(resp => {
      this.load();
    }, err => console.log(err));
  }

}




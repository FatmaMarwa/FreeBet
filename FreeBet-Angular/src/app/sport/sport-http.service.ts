import {Sport} from './sport';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn : 'root'
})

export class SportHttpService {

  sports: Array<Sport>;

  constructor(private appConfig: appConfigService, private  http: HttpClient, private gameService: GameHttpservice, private opponentService: OpponentHttpService) {
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

    delete (id: number) {
      this.http.delete<Sport>(this.appConfig.backEnd + 'sport/' + id).subscribe(resp => {
        this.load();
      }, err => console.log(err));
  }
}
}




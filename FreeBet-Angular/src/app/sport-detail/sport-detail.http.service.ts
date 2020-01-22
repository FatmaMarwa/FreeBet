import {HttpClient} from '@angular/common/http';
import {AppConfigService} from '../app-config.service';
import {ActivatedRoute} from '@angular/router';
import {SportHttpService} from '../sport/sport-http.service';
import {Injectable} from '@angular/core';
import {Sport} from '../Model/sport';
import {Observable} from 'rxjs';
import {Opponent} from '../Model/opponent';
import {Game} from '../Model/game';

@Injectable({
  providedIn: 'root'
})
export class SportDetailHttpService {

  id: number;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private route: ActivatedRoute, private SportService: SportHttpService) {
  }


  findById(id: number): Observable<Sport> {
    return this.http.get<Sport>(this.appConfig.backEnd + 'sport/' + id + '/detail');
  }
}


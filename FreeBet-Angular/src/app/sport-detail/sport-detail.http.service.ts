import {HttpClient} from '@angular/common/http';
import {AppConfigService} from '../app-config.service';
import {ActivatedRoute} from '@angular/router';
import {SportHttpService} from '../sport/sport-http.service';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SportDetailHttpService {


  constructor(private http: HttpClient, private appConfig: AppConfigService, private route: ActivatedRoute) {
    route.params.subscribe(params => {
      console.log(params);
      //  this.monId = params.id;
      // console.log(this.monId);
    });
  }

}


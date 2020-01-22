import {Injectable} from '@angular/core';
import {Sport} from '../Model/sport';
import {AppConfigService} from '../app-config.service';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class SportHttpService {

  constructor(private appConfig: AppConfigService, private  http: HttpClient) {
  }


}

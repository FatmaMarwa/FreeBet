import {Injectable} from '@angular/core';
import {Login} from '../Model/Login';
import {AppConfigService} from '../app-config.service';
import {HttpClient} from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class ConnexionHttpService {

  logins: Array<Login>;

  constructor(private appConfig: AppConfigService, private http: HttpClient,) {
  }

}

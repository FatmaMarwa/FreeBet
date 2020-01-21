import {HttpClient} from '@angular/common/http';
import {AppConfigService} from '../app-config.service';
import {ActivatedRoute} from '@angular/router';
import {SportHttpService} from '../sport/sport-http.service';


export class BasketHttpService {


  constructor(private http: HttpClient, private appConfig: AppConfigService, private route: ActivatedRoute, private sportService: SportHttpService, private basketService: BasketHttpService) {
    route.params.subscribe(params => {
      console.log(params);
      //  this.monId = params.id;
      // console.log(this.monId);
    });
  }

}


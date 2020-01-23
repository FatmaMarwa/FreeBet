import {Component, Output} from '@angular/core';
import {Bettor} from "./Model/bettor";
import {Router} from "@angular/router";
import {Login} from "./Model/Login";
import {HomeService} from "./home/home-http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FreeBet-Angular';
  currentJustify = 'start';


  constructor(private homeService: HomeService) {
    console.log(typeof localStorage.getItem('userConnected'))
    if(localStorage.getItem('userConnected')) {
      console.log("defini");
    } else {
      console.log("indefini");
    }
;
  }

  logInfo(): Login {
    if(localStorage.getItem('userConnected')) {
      return JSON.parse(localStorage.getItem('userConnected'));
    }

    return new Login();
  }

  logout() {
    this.homeService.logout();
  }

}

import {Component, Output} from '@angular/core';
import {Bettor} from "./Model/bettor";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FreeBet-Angular';
  currentJustify = 'start';
  private router: Router;

  @Output()
  bettorCo: Bettor = JSON.parse(localStorage.getItem('bettorConnected'));

}

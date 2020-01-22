import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { BettorComponent } from './bettor/bettor.component';
import { BetComponent } from './bet/bet.component';
import { SportComponent } from './sport/sport.component';
import {FormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { GameComponent } from './game/game.component';
import { OpponentComponent } from './opponent/opponent.component';
import {AngularFontAwesomeModule} from 'angular-font-awesome';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from '@angular/common/http';
import {AppConfigService} from './app-config.service';
import {AdminHttpService} from './admin/admin-http.service';
import {BetHttpService} from './bet/bet-http.service';
import {BettorHttpService} from './bettor/bettor-http.service';
import {GameHttpService} from './game/game-http.service';
import {LoginHttpService} from './login/login-http.service';
import {SportHttpService} from './sport/sport-http.service';
import {OpponentHttpService} from './opponent/opponent-http.service';
import { HomeComponent } from './home/home.component';
import { TennisComponent } from './tennis/tennis.component';
import { RugbyComponent } from './rugby/rugby.component';
import { BasketComponent } from './basket/basket.component';
import { FootballComponent } from './football/football.component';


@NgModule({
  declarations: [
    AppComponent,
    BettorComponent,
    BetComponent,
    SportComponent,
    AppComponent,
    AdminComponent,
    LoginComponent,
    GameComponent,
    OpponentComponent,
    HomeComponent,
    TennisComponent,
    RugbyComponent,
    BasketComponent,
    FootballComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AngularFontAwesomeModule,
    NgbModule,
    HttpClientModule,


  ],
  exports: [
    HomeComponent
  ],
  // tslint:disable-next-line:max-line-length
  providers: [AppConfigService, AdminHttpService, BetHttpService, BettorHttpService, GameHttpService, LoginHttpService, SportHttpService, OpponentHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }

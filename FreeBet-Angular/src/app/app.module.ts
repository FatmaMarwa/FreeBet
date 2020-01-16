import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BettorComponent } from './bettor/bettor.component';
import { BetComponent } from './bet/bet.component';

import { SportComponent } from './sport/sport.component';


@NgModule({
  declarations: [
    AppComponent,
    BettorComponent,
    BetComponent,
    SportComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

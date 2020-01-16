import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
<<<<<<< HEAD
import { BettorComponent } from './bettor/bettor.component';
import { BetComponent } from './bet/bet.component';
=======
import { SportComponent } from './sport/sport.component';
>>>>>>> f712767165ca2c6364d2817e882f1412222e1ac5

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    BettorComponent,
    BetComponent
=======
    SportComponent
>>>>>>> f712767165ca2c6364d2817e882f1412222e1ac5
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

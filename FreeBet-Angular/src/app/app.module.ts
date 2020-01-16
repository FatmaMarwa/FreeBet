import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BettorComponent } from './bettor/bettor.component';
import { BetComponent } from './bet/bet.component';
<<<<<<< HEAD

=======
>>>>>>> 9ef619ed9f760ca88936d55397e86e3c7f4a49f9
import { SportComponent } from './sport/sport.component';


@NgModule({
  declarations: [
    AppComponent,
    BettorComponent,
    BetComponent,
    SportComponent
<<<<<<< HEAD

=======
>>>>>>> 9ef619ed9f760ca88936d55397e86e3c7f4a49f9
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

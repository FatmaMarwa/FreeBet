import {AdminComponent} from './admin/admin.component';
import {BetComponent} from './bet/bet.component';
import {BettorComponent} from './bettor/bettor.component';
import {SportComponent} from './sport/sport.component';
import {LoginComponent} from './login/login.component';
import {GameComponent} from './game/game.component';
import {OpponentComponent} from './opponent/opponent.component';
import {StatistiqueComponent} from './statistique/statistique.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {SportDetailComponent} from './sport-detail/sport-detail.component';

const routes: Routes = [

  {path: 'admin', component: AdminComponent},
  {path: 'bet', component: BetComponent},
  {path: 'bettor', component:BettorComponent },
  {path: 'sport', component: SportComponent},
  {path: 'login', component: LoginComponent },
  {path: 'game', component: GameComponent},
  {path: 'opponent', component:OpponentComponent },
  {path: 'home', component: HomeComponent},
  {path: 'sport/:id/detail', component: SportDetailComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

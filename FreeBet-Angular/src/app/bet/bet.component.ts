import {Component, OnInit} from '@angular/core';
import {Bet} from "../Model/bet";
import {BetHttpService} from "./bet-http.service";
import {Bettor} from "../Model/bettor";
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BettorHttpService} from "../bettor/bettor-http.service";
import {GameHttpService} from "../game/game-http.service";
import {Game} from "../Model/game";
import {log} from "util";
import {HomeService} from "../home/home-http.service";
import {Login} from "../Model/Login";
import {AppComponent} from "../app.component";

@Component({
  selector: 'bet,[bet]',
  templateUrl: './bet.component.html',
  styleUrls: ['./bet.component.css']
})
export class BetComponent implements OnInit {
  currentBet: Bet = null;
  modalBet: Bet = null;
  games: Array<Game> = new Array<Game>();

  constructor(private modalService: NgbModal, private betService: BetHttpService, private gameService: GameHttpService,private homeService:HomeService) {
    gameService.findAllObservable().subscribe(resp => {
      this.games = resp;
    }, err => console.log(err));
  }

  ngOnInit() {
  }

  list() {
    return this.betService.findAll();
  }

  typeBets() {
    return this.betService.typesBets;
  }

  logInfo(): Login {
    if(localStorage.getItem('userConnected')) {
      return JSON.parse(localStorage.getItem('userConnected'));
    }

    return new Login();
  }

  /* bettorrs(){
     return this.bettorrService.findAll();
   }*/


  betgames() {
    return this.gameService.findAll();
  }

  add() {
    this.currentBet = new Bet();
    this.currentBet.bettorr = new Bettor();
    this.games.find(g => g.checked == true).checked = false;
  }

  detail(content, id: number) {
    this.betService.findById(id).subscribe(resp => {
      this.modalBet = resp;
    }, error => {
      console.log(error);
    });
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', scrollable: true});
  }

  edit(id: number) {
    this.betService.findById(id).subscribe(resp => {
      this.currentBet = resp;

      for (let game of this.currentBet.games) {
        this.games.find(g => g.id == game.id).checked = true;
      }

      if (!this.currentBet.bettorr) {
        this.currentBet.bettorr = new Bettor();
      }
    }, error => {
      console.log(error);
    });
  }

  save() {
    console.log("0");
    if(!this.currentBet.id)
    {

      this.currentBet.bettorr=this.homeService.logInfo().bettor;
      console.log(this.currentBet.bettorr);
      if(this.currentBet.bettorr.soldeCagnotte>this.currentBet.mise)
      {
        this.currentBet.bettorr.soldeCagnotte=this.currentBet.bettorr.soldeCagnotte - this.currentBet.mise;
        console.log("2");
      }
    }
      if(this.currentBet.id && this.currentBet.resultatPari == true) {
        this.currentBet.bettorr.soldeCagnotte=this.currentBet.bettorr.soldeCagnotte + this.currentBet.gain;
        console.log("3");
      }

        this.currentBet.games = new Array<Game>();
        for (let game of this.games) {
          if (game.checked) {
            this.currentBet.games.push(game);
          }
        }
        console.log(this.currentBet.bettorr);
        this.betService.save(this.currentBet);
        this.cancel();


  }

  delete(id: number) {
    this.betService.delete(id);
  }

  cancel() {
    this.currentBet = null;
  }

  calcul(cote: number) {
    console.log(cote);
    this.currentBet.gain = this.currentBet.mise * cote;
  }

  gains(cote: number) {
    return this.currentBet.mise * cote;
  }


}

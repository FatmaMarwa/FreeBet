import {Component, OnInit} from '@angular/core';
import {Bet} from "../Model/bet";
import {BetHttpService} from "./bet-http.service";
import {Bettor} from "../Model/bettor";
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BettorHttpService} from "../bettor/bettor-http.service";
import {GameHttpService} from "../game/game-http.service";
import {Game} from "../Model/game";

@Component({
  selector: 'bet,[bet]',
  templateUrl: './bet.component.html',
  styleUrls: ['./bet.component.css']
})
export class BetComponent implements OnInit {
  currentBet: Bet = null;
  modalBet: Bet = null;
  games: Array<Game> = new Array<Game>();

  constructor(private modalService: NgbModal, private betService: BetHttpService, private gameService: GameHttpService) {
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



  /* bettors(){
     return this.bettorService.findAll();
   }*/


  betgames() {
    return this.gameService.findAll();
  }

  add() {
    this.currentBet = new Bet();
    this.currentBet.bettor = new Bettor();
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

      if (!this.currentBet.bettor) {
        this.currentBet.bettor = new Bettor();
      }
    }, error => {
      console.log(error);
    });
  }

  save() {
    this.currentBet.games = new Array<Game>();
    for (let game of this.games) {
      if (game.checked) {
        this.currentBet.games.push(game);
      }
    }

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

  gains() {
    return this.currentBet.mise * 5
  }
}

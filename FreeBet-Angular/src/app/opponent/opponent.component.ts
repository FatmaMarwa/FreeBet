import { Component, OnInit } from '@angular/core';
import {Opponent} from '../Model/opponent';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {GameHttpService} from '../game/game-http.service';
import {Game} from '../Model/game';
import {Sport} from '../Model/sport';
import {OpponentHttpService} from './opponent-http.service';
import {SportHttpService} from '../sport/sport-http.service';

@Component({
  selector: 'opponent, [opponent]',
  templateUrl: './opponent.component.html',
  styleUrls: ['./opponent.component.css']
})
export class OpponentComponent implements OnInit {

  currentOpponent: Opponent = null;

  modalOpponent: Opponent = null;


  constructor(private modalService: NgbModal, private opponentService: OpponentHttpService, private sportService: SportHttpService, private gameService: GameHttpService) {
  }

  ngOnInit() {
  }
  list() {
    return this.opponentService.findAll();
  }
  sports() {
    return this.sportService.findAll();
  }
  games() {
    return this.gameService.findAll();
  }
  add() {
    this.currentOpponent = new Opponent();
    this.currentOpponent.sport_opponent = new Sport();
    this.currentOpponent.game_opponent = new Game();
  }

  detail(content, id: number) {
    this.opponentService.findById(id).subscribe(resp => {
      this.modalOpponent = resp;
    }, error => {
      console.log(error);
    });
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', scrollable: true});
  }

  edit(id: number) {
    this.opponentService.findById(id).subscribe(resp => {
      this.currentOpponent = resp;
      if (!this.currentOpponent.sport_opponent) {
        this.currentOpponent.sport_opponent = new Sport();
      }
      if (!this.currentOpponent.game_opponent) {
        this.currentOpponent.game_opponent = new Game();
      }
    }, error => {
      console.log(error);
    });
  }

    save() {
      this.opponentService.save(this.currentOpponent);
      this.cancel();
    }

    delete(id: number) {
      this.opponentService.delete(id);
    }

    cancel(){
      this.currentOpponent = null;
    }
}

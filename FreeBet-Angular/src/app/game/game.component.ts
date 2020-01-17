import { Component, OnInit } from '@angular/core';
import {Game} from '../Model/game';
import {GameHttpService} from './game-http.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BetHttpService} from '../bet/bet-http.service';
import {OpponentHttpService} from '../opponent/opponent-http.service';
import {SportHttpService} from '../sport/sport-http.service';
import {Sport} from '../Model/sport';



@Component({
  selector: 'game, [game]',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  currentGame: Game = null;
  modalGame: Game = null;

  constructor(private modalService: NgbModal, private gameService: GameHttpService) {

  }

  ngOnInit() {
  }
  list(){
    return this.gameService.findAll();

  }



  add() {
    this.currentGame = new Game();
    this.currentGame.sport = new Sport();
  }
  detail(content, id:number){
    this.gameService.findById(id).subscribe(resp =>{
      this.modalGame = resp;
    }, error =>{
      console.log(error);
    });
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', scrollable: true})
  }
  edit(id: number){
    this.gameService.findById(id).subscribe(resp => {
      this.currentGame = resp;
     if(!this.currentGame.sport){
       this.currentGame.sport = new Sport();
     }
    }, error =>{
      console.log(error);
    });
  }
  save(){
    this.gameService.save(this.currentGame);
    this.cancel();
  }
  delete(id:number){
    this.gameService.delete(id);
  }
  cancel(){
    this.currentGame = null;
  }

}

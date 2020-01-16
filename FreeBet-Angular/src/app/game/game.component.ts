import { Component, OnInit } from '@angular/core';
import {Game} from './game';
import {GameHttpService} from './game-http.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'game, [game]',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  currentGame: Game = null;
  modalGame: Game = null;

  constructor(private modalService: NgbModal, private gameService: GameHttpService, private betService: BetHttpService, private opponentService: OpponentHttpService, private sportService: SportHttpService, private statisticalService: StatisticalHttpService ) {

  }

  ngOnInit() {
  }
  list(){
    return this.gameService.findAll();
  }
  bets(){
    return this.betService.findAll();
  }
  opponents(){
    return this.opponentService.findAll();
  }
  sports(){
    return this.sportService.findAll();
  }
  statisticals(){
    return this.statisticalService.findAll();
  }

  add() {
    this.currentGame = new Game();
    this.currentGame = new Bet();
    this.currentGame.opponent = new Opponent();
    this.currentGame.sport = new Sport();
    this.currentGame.statistical = new Statistical();
  }
  detail(content, id:number){
    this.gameService.findByID(id).subscribe(resp =>{
      this.modalGame = resp;
    }, error =>{
      console.log(error);
    });
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', scrollable: true})
  }
  edit(id: number){
    this.gameService.findById(id).subscribe(resp => {
      this.currentGame = resp;
      if (!this.currentGame.bet){
        this.currentGame.bet = new Bet();
      }
     if (!this.currentGame.opponent){
       this.currentGame.opponent = new Opponent();
     }
     if(!this.currentGame.sport){
       this.currentGame.sport = new Sport();
     }
     if(!this.currentGame.statistical){
       this.currentGame.statistical = new Statistical()
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

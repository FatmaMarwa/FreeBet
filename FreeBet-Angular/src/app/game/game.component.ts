import {Component, Input, OnInit} from '@angular/core';
import {Game} from '../Model/game';
import {GameHttpService} from './game-http.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BetHttpService} from '../bet/bet-http.service';
import {OpponentHttpService} from '../opponent/opponent-http.service';
import {SportHttpService} from '../sport/sport-http.service';
import {Sport} from '../Model/sport';
import {Opponent} from "../Model/opponent";



@Component({
  selector: 'game, [game]',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  currentGame: Game = null;
  modalGame: Game = null;
  @Input()
  readOnly:boolean=false;
  // @Input()
  // gameDone: boolean=true;

  constructor(private modalService: NgbModal, private gameService: GameHttpService, private sportService: SportHttpService,private opponentService: OpponentHttpService) {
  }

  ngOnInit() {
    console.log(this.readOnly);
  }

  list(){
    return this.gameService.findAll();
  }
  sport() {
    return this.sportService.sports;
  }
  opponent() {
    return this.opponentService.findAll();
  }
  championnat() {
    return this.opponentService.championnats;
  }

  add() {
    this.currentGame = new Game();
    this.currentGame.sport_game = new Sport();
    this.currentGame.opponent1= new Opponent();
    this.currentGame.opponent2= new Opponent();
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
     if(!this.currentGame.sport_game){
       this.currentGame.sport_game = new Sport();
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

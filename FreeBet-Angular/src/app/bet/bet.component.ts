import { Component, OnInit } from '@angular/core';
import {Bet} from "../Model/bet";
import {BetHttpService} from "./bet-http.service";
import {Bettor} from "../Model/bettor";
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {BettorHttpService} from "../bettor/bettor-http.service";

@Component({
  selector: 'bet,[bet]',
  templateUrl: './bet.component.html',
  styleUrls: ['./bet.component.css']
})
export class BetComponent implements OnInit {
  currentBet: Bet= null;

  modalBet: Bet=null;

  constructor(private modalService: NgbModal,private betService:BetHttpService,private bettorService:BettorHttpService,private gameService:GameHttpService) {

  }

  ngOnInit() {
  }

  list(){
    return this.betService.findAll();
  }

  bettors(){
    return this.bettorService.findAll();
  }

  games(){
    return this.gameService.findAll();
  }

  add() {
    this.currentBet = new Bet();
    this.currentBet.bettor = new Bettor();
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

      if (!this.currentBet.bettor) {
        this.currentBet.bettor = new Bettor();
      }
    }, error => {
      console.log(error);
    });
  }

  save() {
    this.betService.save(this.currentBet);
    this.cancel();
  }

  delete(id: number) {
    this.betService.delete(id);
  }

  cancel() {
    this.currentBet = null;
  }
}

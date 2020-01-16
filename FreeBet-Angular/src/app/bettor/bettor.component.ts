import { Component, OnInit } from '@angular/core';
import {Bettor} from "../Model/bettor";
import {BetHttpService} from "../bet/bet-http.service";
import {Bet} from "../Model/bet";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {BettorHttpService} from "./bettor-http.service";
import {Adress} from "../Model/adress";
import {LoginHttpService} from "../login/login-http.service";

@Component({
  selector: 'bettor,[bettor]',
  templateUrl: './bettor.component.html',
  styleUrls: ['./bettor.component.css']
})
export class BettorComponent implements OnInit {
  currentBettor: Bettor = null;

  modalBettor:Bettor = null;

  constructor(private modalService:NgbModal,private betService:BetHttpService,private bettorService:BettorHttpService,private loginService:LoginHttpService) { }

  ngOnInit() {
  }

  bets(){
    return this.betService.findAll();
  }

  list(){
    return this.bettorService.findAll();
  }

  logins(){
    return this.loginService.findAll();
  }

  add() {
    this.currentBettor = new Bettor();
    this.currentBettor.adress = new Adress();
  }

  detail(content, id: number) {
    this.bettorService.findById(id).subscribe(resp => {
      this.modalBettor = resp;
    }, error => {
      console.log(error);
    });
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', scrollable: true});
  }

  edit(id: number) {
    this.bettorService.findById(id).subscribe(resp => {
      this.currentBettor = resp;

      if (!this.currentBettor.adress) {
        this.currentBettor.adress = new Adress();
      }
    }, error => {
      console.log(error);
    });
  }

  save() {
    this.bettorService.save(this.currentBettor);
    this.cancel();
  }

  delete(id: number) {
    this.bettorService.delete(id);
  }

  cancel() {
    this.currentBettor = null;
  }
}

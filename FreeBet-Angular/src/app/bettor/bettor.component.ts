import { Component, OnInit } from '@angular/core';
import {Bettor} from "../Model/bettor";
import {BetHttpService} from "../bet/bet-http.service";
import {Bet} from "../Model/bet";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {BettorHttpService} from "./bettor-http.service";
import {Adress} from "../Model/adress";
import {LoginHttpService} from "../login/login-http.service";
import {Login} from "../Model/Login";
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'bettor,[bettor]',
  templateUrl: './bettor.component.html',
  styleUrls: ['./bettor.component.css']
})
export class BettorComponent implements OnInit {
  currentBettor: Bettor=null;

  //currentAdress: Adress = new Adress();

  modalBettor:Bettor = null;


  constructor(private modalService:NgbModal,private bettorService:BettorHttpService) {
    this.currentBettor = new Bettor();
    this.currentBettor.adress = new Adress();
    this.currentBettor.login = new Login();
  }

  ngOnInit() {
  }

 /* bets(){
    return this.betService.findAll();
  }*/

  list(){
    return this.bettorService.findAll();
  }

  civilites(){
    return this.bettorService.civilites;
  }

  /*logins(){
    return this.loginService.findAll();
  }*/

  add() {
    this.currentBettor = new Bettor();
    this.currentBettor.adress = new Adress();
    this.currentBettor.login=new Login();
    //pseudo rentré different que dans la base
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
      if (!this.currentBettor.login) {
        this.currentBettor.login = new Login();
      }
    }, error => {
      console.log(error);
    });
  }

  save() {
    console.log(this.currentBettor);
    this.bettorService.save(this.currentBettor);
    // this.cancel();
  }

  delete(id: number) {
    this.bettorService.delete(id);
  }

//  cancel() {
  //  this.currentBettor = null;
 // }
}

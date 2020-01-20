import { Component, OnInit } from '@angular/core';
import {Admin} from '../Model/admin';
import {AdminHttpService} from '../admin/admin-http.service';
import {Login} from '../Model/Login';
import {LoginHttpService} from './login-http.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Bettor} from '../Model/bettor';
import {BettorHttpService} from '../bettor/bettor-http.service';

@Component({
  selector: 'login, [login]',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  currentLogin: Login = null;

  modalLogin: Login = null;

  constructor(private modalService: NgbModal, private loginService: LoginHttpService, private adminService: AdminHttpService, private bettorService: BettorHttpService) { }

  ngOnInit() {
  }

  list() {
    return this.loginService.findAll();
  }

  admins() {
    return this.adminService.findAll();
  }

  bettors() {
    return this.bettorService.findAll();
  }


  add() {
    this.currentLogin = new Login();
    this.currentLogin.admin = new Admin();
    this.currentLogin.bettor = new Bettor();
  }

  detail(content, id: number) {
    this.loginService.findById(id).subscribe(resp => {
      this.modalLogin = resp;
    }, error => {
      console.log(error);
    });
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', scrollable: true});
  }

  edit(id: number) {
    this.loginService.findById(id).subscribe(resp => {
      this.currentLogin = resp;

      if (!this.currentLogin.admin) {
        if (!this.currentLogin.bettor) {
          this.currentLogin.bettor = new Bettor();
        }
        this.currentLogin.admin = new Admin();
      }
    }, error => {
      console.log(error);
    });

  }

  save() {
    this.loginService.save(this.currentLogin);

    this.cancel();
  }

  delete(id: number) {
    this.loginService.delete(id);
  }

  cancel() {
    this.currentLogin = null;
  }


}

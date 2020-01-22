import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Connexion} from '../Model/connexion';
import {LoginHttpService} from '../login/login-http.service';
import {ConnexionHttpService} from './connexion-http.service';
import  {Login} from '../Model/Login';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  CurrentConnexion: Connexion = null;

  constructor(private modalService: NgbModal, private loginService: LoginHttpService, private connexionService: ConnexionHttpService) { }

  ngOnInit() {
  }


  validate() {

  }

  cancel() {
    this.CurrentConnexion = null;
  }

}

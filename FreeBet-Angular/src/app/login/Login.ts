import {Admin} from '../Model/admin';
import {Bettor} from '../Model/bettor';


export class Login {
  id: number;
  version: number = 0;
  pseudo: string;
  mail: string;
  motdepasse: string;
  admin: Admin;
  bettor: Bettor;


  constructor(id?: number, version?: number, pseudo?: string, mail?: string, motdepasse?: string, admin?: Admin, bettor?: Bettor) {
    this.id = id;
    this.version = version;
    this.pseudo = pseudo;
    this.mail = mail;
    this.motdepasse = motdepasse;
    this.admin = admin;
    this.bettor = bettor;
  }
}

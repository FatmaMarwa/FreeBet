import {Admin} from './admin';
import {Bettor} from './bettor';


export class Login {
  id: number;
  version: number = 0;
  pseudo: string;
  mail: string;
  motDePasse: string;
  admin: Admin;
  bettor: Bettor;


  constructor(id?: number, version?: number, pseudo?: string, mail?: string, motDePasse?: string, admin?: Admin, bettor?: Bettor) {
    this.id = id;
    this.version = version;
    this.pseudo = pseudo;
    this.mail = mail;
    this.motDePasse = motDePasse;
    this.admin = admin;
    this.bettor = bettor;
  }
}

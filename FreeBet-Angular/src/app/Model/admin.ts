import {Login} from './Login';
import {Adress} from './adress';


export class Admin{
  id: number;
  version: number = 0;
  nom: string;
  prenom: string;
  login: Login;
  adress: Adress;


  constructor(id?: number, version?: number, nom?: string, prenom?: string, login?: Login, adress?: Adress) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.prenom = prenom;
    this.login = login;
    this.adress = adress;
  }

}

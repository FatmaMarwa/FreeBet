import {Login} from '../login/Login';
import {Adress} from '../Model/adress';


export class Admin{
  id: number;
  version: number = 0;
  nom: string;
  prenom: string;
  login: Login;
  adresse: Adress;


  constructor(id?: number, version?: number, nom?: string, prenom?: string, login?: Login, adresse?: Adress) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.prenom = prenom;
    this.login = login;
    this.adresse = adresse;
  }

}

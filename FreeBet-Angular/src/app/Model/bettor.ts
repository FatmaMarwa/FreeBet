import {Bet} from "./bet";
import {Adress} from "./adress";

export class Bettor{
  id: number;
  version: number = 0;
  nom: string;
  prenom: string;
  ddn: Date;
  soldeCagnotte: number;
  civilite: string;
  adress: Adress;
  login: Login;
  bets: Bet;


  constructor(id?: number, version?: number, nom?: string, prenom?: string, ddn?: Date, soldeCagnotte?: number, civilite?: string, adress?: Adress, login?: Login, bets?: Bet) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.prenom = prenom;
    this.ddn = ddn;
    this.soldeCagnotte = soldeCagnotte;
    this.civilite = civilite;
    this.adress = adress;
    this.login = login;
    this.bets = bets;
  }
}

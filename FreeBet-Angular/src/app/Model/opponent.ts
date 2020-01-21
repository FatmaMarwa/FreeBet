


import {Sport} from '../Model/sport';
import {Game} from './game';


export class Opponent {
  id: number;
  version: number = 0;
  nom: string;
  championnat: string; // enum
  sport_opponent: Sport;



  constructor(id?: number, version?: number, nom?: string, championnat?: string, sport_opponent?: Sport) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.championnat = championnat;
    this.sport_opponent = sport_opponent;
  }
}

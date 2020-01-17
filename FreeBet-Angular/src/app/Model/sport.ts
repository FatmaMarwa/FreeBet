import {Game} from './game';
import {Opponent} from './opponent';

export class Sport {
  id: number;
  version: number = 0;
  nom: string;
  sportType: string;
  duree: number;
  game: Game;
  opponentSport: Opponent [];


  constructor(id?: number, version?: number, nom?: string, sportType?: string, duree?: number, game?: Game, opponentSport?: Opponent[]) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.sportType = sportType;
    this.duree = duree;
    this.game = game;
    this.opponentSport = opponentSport;
  }

}

import {Game} from './game';
import {Opponent} from './opponent';

export class Sport {
  id: number;
  version: number = 0;
  nom: string;
  typeSport: string;
  game: Game
  opponentSport: Opponent [];


  constructor(id?: number, version?: number, nom?: string, typeSport?: string, game?: Game, opponentSport?: Opponent[]) {
    this.id = id;
    this.version = version;
    this.nom = nom;
    this.typeSport = typeSport;
    this.game = game;
    this.opponentSport = opponentSport;
  }
}


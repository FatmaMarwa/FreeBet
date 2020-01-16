import {Game} from '../game/game';

export class Statistique {
  id: number;
  version: number = 0;
  code: string;
  resultat: number;
  game_stat : Game;


  constructor(id: number, version: number, code: string, resultat: number, game_stat: Game) {
    this.id = id;
    this.version = version;
    this.code = code;
    this.resultat = resultat;
    this.game_stat = game_stat;
  }
}

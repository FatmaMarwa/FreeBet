import {Bet} from './bet';
import {Sport} from './sport';
import {Opponent} from './opponent';
import {Statistique} from './statistique';

export class Game {
  id: number;
  version: number = 0;
  gameDate: Date;
  gameEnd: Date;
  cote1: number;
  coteN: number;
  cote2: number;
  gameDone: boolean;
  bets: Bet[];
  sport_game: Sport;
  opponent1: Opponent;
  opponent2: Opponent;
  statisticals: Statistique[];
  checked: boolean = false;


  constructor(id?: number, version?: number, gameDate?: Date, gameEnd?: Date, cote1?: number, coteN?: number, cote2?: number, gameDone?: boolean, bets?: Bet[], sport_game?: Sport, opponent1?: Opponent, opponent2?: Opponent, statisticals?: Statistique[]) {
    this.id = id;
    this.version = version;
    this.gameDate = gameDate;
    this.gameEnd = gameEnd;
    this.cote1 = cote1;
    this.coteN = coteN;
    this.cote2 = cote2;
    this.gameDone = gameDone;
    this.bets = bets;
    this.sport_game = sport_game;
    this.opponent1 = opponent1;
    this.opponent2 = opponent2;
    this.statisticals = statisticals;
  }
}

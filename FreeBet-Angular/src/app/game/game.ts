import {Bet} from '../Model/bet';
import {Sport} from '../Model/sport';
import {Opponent} from '../opponent/opponent';
import {Statistique} from '../Model/statistique';

export class Game {
  id: number;
  version: number = 0;
  gameDate: Date;
  cote1: number;
  coteN: number;
  cote2: number;
  gameDone: boolean;
  bets: Bet[];
  sport: Sport;
  opponents: Opponent[];
  statisticals: Statistique[];


  constructor(id?: number, version?: number, gameDate?: Date, cote1?: number, coteN?: number, cote2?: number, gameDone?: boolean, bets?: Bet[], sport?: Sport, opponents?: Opponent[], statisticals?: Statistique[]) {
    this.id = id;
    this.version = version;
    this.gameDate = gameDate;
    this.cote1 = cote1;
    this.coteN = coteN;
    this.cote2 = cote2;
    this.gameDone = gameDone;
    this.bets = bets;
    this.sport = sport;
    this.opponents = opponents;
    this.statisticals = statisticals;
  }
}

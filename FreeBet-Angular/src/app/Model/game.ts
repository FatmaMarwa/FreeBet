import {Bet} from './bet';
import {Sport} from './sport';
import {Opponent} from './opponent';
import {Statistique} from './statistique';

export class Game {
  id: number;
  version: number = 0;
  gameDate: Date;
  cote1: number;
  cote2: number;
  resultatMatch: boolean;
  bets: Bet[];
  sport: Sport;
  opponents: Opponent[];
  statisticals: Statistique[];


  constructor(id?: number, version?: number, gameDate?: Date, cote1?: number, cote2?: number, resultatMatch?: boolean, bets?: Bet[], sport?: Sport, opponents?: Opponent[], statisticals?: Statistique[]) {
    this.id = id;
    this.version = version;
    this.gameDate = gameDate;
    this.cote1 = cote1;
    this.cote2 = cote2;
    this.resultatMatch = resultatMatch;
    this.bets = bets;
    this.sport = sport;
    this.opponents = opponents;
    this.statisticals = statisticals;
  }
}

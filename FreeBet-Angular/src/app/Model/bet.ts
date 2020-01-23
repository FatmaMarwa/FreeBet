import {Bettor} from "./bettor";
import {Game} from "./game";

export class Bet {
  id: number;
  version: number = 0;
  mise: number;
  resultatPari: boolean;
  type: string;
  betDate: Date;
  gain: number;
  games: Game[];
  bettorr: Bettor;


  constructor(id?: number, version?: number, mise?: number, resultatPari?: boolean, type?: string, betDate?: Date, gain?: number, games?: Game[], bettorr?: Bettor) {
    this.id = id;
    this.version = version;
    this.mise = mise;
    this.resultatPari = resultatPari;
    this.type = type;
    this.betDate = betDate;
    this.gain = gain;
    this.games = games;
    this.bettorr = bettorr;
  }
}

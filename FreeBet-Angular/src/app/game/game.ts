export class Game {
  id: number;
  version: number = 0;
  gameDate: Date;
  cote1: number;
  cote2: number;
  resultatMatch: boolean;
  bet: Bet[];
  sport: Sport;
  opponent: Opponent[];
  statistical: Statistical[];


  constructor(id?: number, version?: number, gameDate?: Date, cote1?: number, cote2?: number, resultatMatch?: boolean, bet?: Bet[], sport?: Sport, opponent?: Opponent[], statistical?: Statistical[]) {
    this.id = id;
    this.version = version;
    this.gameDate = gameDate;
    this.cote1 = cote1;
    this.cote2 = cote2;
    this.resultatMatch = resultatMatch;
    this.bet = bet;
    this.sport = sport;
    this.opponent = opponent;
    this.statistical = statistical;
  }
}

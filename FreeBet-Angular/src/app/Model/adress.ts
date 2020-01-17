export class Adress {

  rue: string;
  ville: string;
  codepostal: string;
  pays: string;


  constructor(rue?: string, ville?: string, codepostal?: string, pays?: string) {
    this.rue = rue;
    this.ville = ville;
    this.codepostal = codepostal;
    this.pays = pays;
  }
}

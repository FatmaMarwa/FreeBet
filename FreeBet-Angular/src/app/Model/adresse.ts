export class Adresse {

  rue: string;
  ville: string;
  codePostal: string;
  pays: string;


  constructor(rue: string, ville: string, codePostal: string, pays: string) {
    this.rue = rue;
    this.ville = ville;
    this.codePostal = codePostal;
    this.pays = pays;
  }
}

import {Component, OnInit} from '@angular/core';
import {Sport} from '../Model/sport';
import {SportHttpService} from './sport-http.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {GameHttpService} from '../game/game-http.service';
import {OpponentHttpService} from '../opponent/opponent-http.service';

@Component({
  selector: 'sport,[sport]',
  templateUrl: './sport.component.html',
  styleUrls: ['./sport.component.css']
})
export class SportComponent implements OnInit {
  currentSport: Sport = null;

  modalSport: Sport = null;


  constructor(private modalService: NgbModal, private sportService: SportHttpService, ) {
  }

  ngOnInit() {
  }

  list() {
    return this.sportService.findAll();
  }

 // games() {
//    return this.gameService.findAll();
 // }

 // opponents() {
 //   return this.opponentService.findAll();
//  }

  typeSport() {
    return this.sportService.typeSports;
  }
  duree() {
    return this.sportService.durees;
  }



  add() {
    this.currentSport = new Sport();

  }

  detail(content, id: number) {
    this.sportService.findById(id).subscribe(resp => {
      this.modalSport = resp;
    }, error => {
      console.log(error);
    });
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', scrollable: true});
  }

  edit(id: number) {
    this.sportService.findById(id).subscribe(resp => {
      this.currentSport = resp;
    }, error => {
      console.log(error);
    });
  }


  save() {
    this.sportService.save(this.currentSport);

    this.cancel();
  }

  delete(id: number) {
    this.sportService.delete(id);
  }

  cancel() {
    this.currentSport = null;
  }
}

import {Component, OnInit} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {SportDetailHttpService} from './sport-detail.http.service';
import {SportHttpService} from '../sport/sport-http.service';
import {ActivatedRoute} from '@angular/router';
import {Sport} from '../Model/sport';
import {GameHttpService} from '../game/game-http.service';
import {Game} from '../Model/game';
import {Login} from '../Model/Login';

@Component({
  selector: 'sport-detail',
  templateUrl: './sport-detail.component.html',
  styleUrls: ['./sport-detail.component.css']
})
export class SportDetailComponent implements OnInit {

  sport: Sport;
  games: Array<Game>;

  constructor(private route: ActivatedRoute, private sportDetailService: SportDetailHttpService, private gameService: GameHttpService) {
    this.route.params.subscribe(params => {
      this.sportDetailService.findById(params.id).subscribe(resp => {
        this.sport = resp;
      }, err => console.log(err));

      this.gameService.findAllObservableBySport(params.id).subscribe(resp => {
        this.games = resp;
      }, err => console.log(err));
    });
  }



  ngOnInit() {
  }

}

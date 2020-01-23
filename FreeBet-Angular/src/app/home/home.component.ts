import { Component, OnInit, ViewChild  } from '@angular/core';
import { NgbCarousel, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import {Bettor} from "../Model/bettor";
import {Subscription} from "rxjs";
import {HomeService} from "./home-http.service";
import {BettorHttpService} from "../bettor/bettor-http.service";
import {GameHttpService} from '../game/game-http.service';
import {Game} from '../Model/game';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {



  paused = false;
  unpauseOnArrow = false;
  pauseOnIndicator = false;
  pauseOnHover = true;

  @ViewChild('carousel', {static : true}) carousel: NgbCarousel;

  togglePaused() {
    if (this.paused) {
      this.carousel.cycle();
    } else {
      this.carousel.pause();
    }
    this.paused = !this.paused;
  }

  onSlide(slideEvent: NgbSlideEvent) {
    if (this.unpauseOnArrow && slideEvent.paused &&
      (slideEvent.source === NgbSlideEventSource.ARROW_LEFT || slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)) {
      this.togglePaused();
    }
    if (this.pauseOnIndicator && !slideEvent.paused && slideEvent.source === NgbSlideEventSource.INDICATOR) {
      this.togglePaused();
    }
  }

  currentOrientation = 'horizontal';

  currentBettor: Bettor;
  currentBettorSubscription: Subscription;
  bettors: Bettor[] = [];



  constructor(private homeService: HomeService,private bettorService:BettorHttpService) {
    // this.currentBettorSubscription = this.homeService.currentBettor.subscribe(bettor =>{
    //   this.currentBettor = bettor;
    // });
  }

  //constructor(private homeService: HomeService,private bettorService:BettorHttpService) {
  //  this.currentBettorSubscription = this.homeService.currentBettor.subscribe(bettor =>{
    //  this.currentBettor = bettor;
  //  });
 // }


  ngOnInit(): void {
    this.loadAllBettors();

  }

   loadAllBettors() {
     return this.bettorService.findAll();
   }

  login(pseudo: string, motDePasse: string)
  {
    localStorage.clear();
    this.homeService.login(pseudo, motDePasse);
  }
}

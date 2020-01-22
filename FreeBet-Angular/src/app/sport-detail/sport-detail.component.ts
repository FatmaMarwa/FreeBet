import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {SportDetailHttpService} from './sport-detail.http.service';
import {SportHttpService} from '../sport/sport-http.service';

@Component({
  selector: 'sport-detail',
  templateUrl: './sport-detail.component.html',
  styleUrls: ['./sport-detail.component.css']
})
export class SportDetailComponent implements OnInit {

  constructor(private modalService: NgbModal, private sportDetailService: SportDetailHttpService) { }

  ngOnInit() {
  }

}

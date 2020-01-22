import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {SportDetailHttpService} from './Sport-detail.http.service';

@Component({
  selector: 'app-sport-detail',
  templateUrl: './sport-detail.component.html',
  styleUrls: ['./sport-detail.component.css']
})
export class SportDetailComponent implements OnInit {

  constructor(private modalService: NgbModal, private sportDetailService: SportDetailHttpService) { }

  ngOnInit() {
  }

}

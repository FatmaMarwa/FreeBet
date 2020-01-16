import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  backEnd = "http://localhost:8080/";

  constructor() { }
}

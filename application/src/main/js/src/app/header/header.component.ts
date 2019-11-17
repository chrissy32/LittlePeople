import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isUserLogged: boolean = true;

  constructor() { }

  ngOnInit() {
    //TODO call authentication service to check whether the user is logged or not - for now assume logged in for design
  }

}

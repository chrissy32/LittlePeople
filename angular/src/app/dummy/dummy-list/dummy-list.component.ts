import { Component, OnInit } from '@angular/core';
import {DummyModel} from '../shared/dummy.model';
import {DummyService} from '../shared/dummy.service';

@Component({
  selector: 'app-dummy-list',
  templateUrl: './dummy-list.component.html',
  styleUrls: ['./dummy-list.component.css']
})
export class DummyListComponent implements OnInit {
  dummies: Array<DummyModel>;

  constructor(private dummyService: DummyService) { }

  ngOnInit() {
    this.getDummies();
  }

  getDummies(): void {
    this.dummyService.getDummies()
      .subscribe(
        dummies => this.dummies = dummies
      );
  }
}

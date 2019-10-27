import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DummyModel} from './dummy.model';

@Injectable({
  providedIn: 'root'
})
export class DummyService {
  private dummyUrl = 'http://localhost:8080/api/all';
  constructor(private httpClient: HttpClient) { }

  getDummies(): Observable<DummyModel[]> {
    console.log('get here');
    return this.httpClient
      .get<Array<DummyModel>>(this.dummyUrl)
  }
}

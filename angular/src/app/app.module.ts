import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DummyComponent } from './dummy/dummy.component';
import { DummyListComponent } from './dummy/dummy-list/dummy-list.component';
import {DummyService} from './dummy/shared/dummy.service';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    DummyComponent,
    DummyListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [DummyService],
  bootstrap: [AppComponent]
})
export class AppModule { }

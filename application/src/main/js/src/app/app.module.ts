import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {APP_BASE_HREF} from "@angular/common";
import { HomepageMainComponent } from './homepage-main/homepage-main.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomepageMainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    {provide: APP_BASE_HREF, useValue: ''}
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

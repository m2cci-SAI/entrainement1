import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FootballComponent } from './football/football.component';
import { SidenavbarComponent } from './football/sidenavbar/sidenavbar.component';
import { FormulaireLoginComponent } from './users/formulaire-login/formulaire-login.component';
import { FormulaireRegisterComponent } from './users/formulaire-register/formulaire-register.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FootballComponent,
    SidenavbarComponent,
    FormulaireLoginComponent,
    FormulaireRegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

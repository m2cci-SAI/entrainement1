import { HomeVsawayComponent } from './football/home-vsaway/home-vsaway.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FootballComponent } from './football/football.component';
import { SidenavbarComponent } from './football/sidenavbar/sidenavbar.component';
import { FormulaireLoginComponent } from './users/formulaire-login/formulaire-login.component';
import { FormulaireRegisterComponent } from './users/formulaire-register/formulaire-register.component';
import { HttpClientModule } from '@angular/common/http';
import { ChampionchipComponent } from './football/championchip/championchip.component';
import { Ligue2Component } from './football/ligue2/ligue2.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FootballComponent,
    SidenavbarComponent,
    FormulaireLoginComponent,
    FormulaireRegisterComponent,
    HomeVsawayComponent,
    ChampionchipComponent,
    Ligue2Component

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

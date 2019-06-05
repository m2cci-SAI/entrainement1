import { Ligue2Component } from './football/ligue2/ligue2.component';
import { ChampionchipComponent } from './football/championchip/championchip.component';
import { HomeVsawayComponent } from './football/home-vsaway/home-vsaway.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormulaireLoginComponent } from './users/formulaire-login/formulaire-login.component';
import { FormulaireRegisterComponent } from './users/formulaire-register/formulaire-register.component';
import { FootballComponent } from './football/football.component';

const routes: Routes = [
  {
    path: 'login',
    component: FormulaireLoginComponent
   },
   {
     path: 'register',
     component: FormulaireRegisterComponent
    },
    {
      path: 'football',
      component: FootballComponent, children : [
        {
          path: 'onevsone',
          component: HomeVsawayComponent
         },
         {
          path: 'championchip',
          component: ChampionchipComponent
         },
         {
          path: 'ligue2',
          component: Ligue2Component
         }
      ]
    }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

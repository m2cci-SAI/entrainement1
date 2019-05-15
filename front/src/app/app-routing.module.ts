import { FormulaireRegisterComponent } from './users/formulaire-register/formulaire-register.component';
import { FormulaireLoginComponent } from './users/formulaire-login/formulaire-login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
   path: 'login',
   component: FormulaireLoginComponent
  },
  {
    path: 'register',
    component: FormulaireRegisterComponent
   }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

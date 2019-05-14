import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from '../app.component';

import { FormulaireLoginComponent } from './formulaire-login/formulaire-login.component';
import { FormulaireRegisterComponent } from './formulaire-register/formulaire-register.component';
@NgModule({
  declarations: [
    FormulaireLoginComponent,
    FormulaireRegisterComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class UsersModule { }

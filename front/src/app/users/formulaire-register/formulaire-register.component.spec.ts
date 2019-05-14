import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireRegisterComponent } from './formulaire-register.component';

describe('FormulaireRegisterComponent', () => {
  let component: FormulaireRegisterComponent;
  let fixture: ComponentFixture<FormulaireRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormulaireRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaireRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

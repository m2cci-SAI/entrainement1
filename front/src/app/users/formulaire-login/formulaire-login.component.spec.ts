import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireLoginComponent } from './formulaire-login.component';

describe('FormulaireLoginComponent', () => {
  let component: FormulaireLoginComponent;
  let fixture: ComponentFixture<FormulaireLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormulaireLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulaireLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

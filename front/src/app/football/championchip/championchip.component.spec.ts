import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChampionchipComponent } from './championchip.component';

describe('ChampionchipComponent', () => {
  let component: ChampionchipComponent;
  let fixture: ComponentFixture<ChampionchipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChampionchipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChampionchipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

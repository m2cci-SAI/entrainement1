import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeVsawayComponent } from './home-vsaway.component';

describe('HomeVsawayComponent', () => {
  let component: HomeVsawayComponent;
  let fixture: ComponentFixture<HomeVsawayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeVsawayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeVsawayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

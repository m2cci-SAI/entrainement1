import { TestBed } from '@angular/core/testing';

import { Homevsaway } from './football.service';

describe('Homevsaway.Service.TsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Homevsaway = TestBed.get(Homevsaway);
    expect(service).toBeTruthy();
  });
});

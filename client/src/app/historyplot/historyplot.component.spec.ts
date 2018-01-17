import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoryplotComponent } from './historyplot.component';

describe('HistoryplotComponent', () => {
  let component: HistoryplotComponent;
  let fixture: ComponentFixture<HistoryplotComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HistoryplotComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoryplotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

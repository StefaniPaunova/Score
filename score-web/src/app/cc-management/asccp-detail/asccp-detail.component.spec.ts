import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {AsccpDetailComponent} from './asccp-detail.component';

describe('AsccpDetailComponent', () => {
  let component: AsccpDetailComponent;
  let fixture: ComponentFixture<AsccpDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AsccpDetailComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AsccpDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

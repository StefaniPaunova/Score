import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ContextSchemeCreateComponent} from './context-scheme-create.component';

describe('ContextSchemeCreateComponent', () => {
  let component: ContextSchemeCreateComponent;
  let fixture: ComponentFixture<ContextSchemeCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ContextSchemeCreateComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContextSchemeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

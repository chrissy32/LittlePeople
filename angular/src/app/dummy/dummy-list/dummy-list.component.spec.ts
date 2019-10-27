import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DummyListComponent } from './dummy-list.component';

describe('DummyListComponent', () => {
  let component: DummyListComponent;
  let fixture: ComponentFixture<DummyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DummyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DummyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

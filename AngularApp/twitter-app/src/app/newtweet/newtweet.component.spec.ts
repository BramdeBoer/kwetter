/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { NewtweetComponent } from './newtweet.component';

describe('NewtweetComponent', () => {
  let component: NewtweetComponent;
  let fixture: ComponentFixture<NewtweetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewtweetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewtweetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

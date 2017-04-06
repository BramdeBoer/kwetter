/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { UsertweetsComponent } from './usertweets.component';

describe('UsertweetsComponent', () => {
  let component: UsertweetsComponent;
  let fixture: ComponentFixture<UsertweetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsertweetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsertweetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

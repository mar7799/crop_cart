import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CropRegisterComponent } from './crop-register.component';

describe('CropRegisterComponent', () => {
  let component: CropRegisterComponent;
  let fixture: ComponentFixture<CropRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CropRegisterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CropRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

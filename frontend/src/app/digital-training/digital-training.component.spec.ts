import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DigitalTrainingComponent } from './digital-training.component';

describe('DigitalTrainingComponent', () => {
  let component: DigitalTrainingComponent;
  let fixture: ComponentFixture<DigitalTrainingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DigitalTrainingComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DigitalTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

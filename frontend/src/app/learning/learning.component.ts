import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-learning',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './learning.component.html',
  styleUrl: './learning.component.scss'
})
export class LearningComponent {
currentStep = 1;

  goToNext() {
    this.currentStep++;
  }

  goToPrevious() {
    this.currentStep--;
  }
}

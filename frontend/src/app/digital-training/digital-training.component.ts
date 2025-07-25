import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-digital-training',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './digital-training.component.html',
  styleUrl: './digital-training.component.scss'
})
export class DigitalTrainingComponent {
steps = [
    { step: 1, action: 'Aadhaar verified', reward: '₹5' },
    { step: 2, action: 'Mobile linked to bank', reward: '₹5' },
    { step: 3, action: 'First money transfer', reward: '₹10' },
    { step: 4, action: 'Watched 3 literacy videos', reward: '₹5' },
    { step: 5, action: 'Saved ₹100 in wallet', reward: '₹10 bonus' }
  ];
}

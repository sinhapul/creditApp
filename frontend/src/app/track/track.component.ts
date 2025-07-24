import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-track',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './track.component.html',
  styleUrl: './track.component.scss'
})
export class TrackComponent {
  showDurationOptions = false;
  durationSelected = false;
  loanApproved = false;

  loanAmount = 350000;
  interestRate = 12; // Assume based on credit score
  selectedDuration = 0;
  emi: number | null = null;

  // Called when a duration is selected
  submitLoan(duration: number) {
    this.selectedDuration = duration;
    this.durationSelected = true;

    const monthlyInterestRate = this.interestRate / 12 / 100;
    const n = duration;

    // EMI formula: [P × r × (1 + r)^n] / [(1 + r)^n – 1]
    const r = monthlyInterestRate;
    const P = this.loanAmount;
    const emi = (P * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    this.emi = Math.round(emi);

    // Simulate backend submission delay
    setTimeout(() => {
      this.loanApproved = true;
    }, 1000);
  }
}

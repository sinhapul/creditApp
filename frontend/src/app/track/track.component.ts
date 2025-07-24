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
  interestRate = 12;
  selectedDuration = 0;
  selectedFrequency = '';
  emi: number | null = null;

  selectedLoanType: 'business' | 'emergency' = 'business'; // default
  showEmergencyOptions = false;

  // Called when Business Loan duration is selected
  submitLoan(duration: number) {
  this.selectedDuration = duration;
  this.durationSelected = true;
  this.selectedLoanType = 'business';

  // Restore original values for business loan
  this.loanAmount = 350000;
  this.interestRate = 12;

  this.calculateEMI(duration, 'monthly');
}


  // Emergency loan frequency submission
  submitEmergencyLoan(frequency: string) {
  this.selectedFrequency = frequency;
  this.durationSelected = true;
  this.selectedLoanType = 'emergency';

  // Lower amount and higher interest rate for emergency
  this.loanAmount = 30000;
  this.interestRate = 18;

  let duration = 0;
  if (frequency === 'weekly') duration = 12;      // 3 months weekly
  if (frequency === 'bi-weekly') duration = 6;    // 3 months bi-weekly
  if (frequency === 'monthly') duration = 3;      // 3 months monthly

  this.calculateEMI(duration, frequency);
}


  calculateEMI(duration: number, frequency: string) {
    const r = this.interestRate / 12 / 100;
    const P = this.loanAmount;
    const emi = (P * r * Math.pow(1 + r, duration)) / (Math.pow(1 + r, duration) - 1);
    this.emi = Math.round(emi);

    setTimeout(() => {
      this.loanApproved = true;
    }, 1000);
  }
}

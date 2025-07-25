import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BackendService } from '../backend.service';
import { Router } from '@angular/router';
import { AlertService } from '../alert.service';

@Component({
  selector: 'app-apply-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './apply-form.component.html',
  styleUrl: './apply-form.component.scss'
})
export class ApplyFormComponent {

  constructor(private backendService: BackendService, private router: Router, private alert: AlertService) {}

  step = 1;

  formData = {
  aadhaar: '',
  otp: '',
  documentType: '',
  provider: '',
  loanType: '',
  kycMethod: '',
  consent: false,
  uploadedFile: ''
};


  nextStep() {
    if (this.step < 5) {
      this.step++;
    }
  }

  prevStep() {
    if (this.step > 1) {
      this.step--;
    }
  }

  onFileUpload(event: any) {
    this.formData.uploadedFile = event.target.files[0];
  }

  submitForm() {
    console.log('Form submitted:', this.formData);
    this.alert.showAlert('success', 'Application submitted successfully!');
    this.router.navigate(['/']);

    // this.backendService.fetch();
  }

}

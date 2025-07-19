import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-apply-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './apply-form.component.html',
  styleUrl: './apply-form.component.scss'
})
export class ApplyFormComponent {
  step = 1;

  formData = {
    aadhaar: '',
    otp: '',
    documentType: '',
    provider: '',
    uploadedFile: null,
    kycMethod: '',
    consent: false
  };

  nextStep() {
    if (this.step < 4) {
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
    alert('Application submitted successfully!');
  }

}

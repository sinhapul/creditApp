import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BackendService } from '../backend.service';
import { Router } from '@angular/router';
import { AlertService } from '../alert.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {

  constructor(private backService: BackendService, private router:Router, private alert: AlertService) {}

  step = 1;

  mobile = '';
  otp = '';
  otpError = '';

  userId = '';
  password = '';
  userIdError = '';

  isValidMobile(mobile: string): boolean {
    return /^[0-9]{10}$/.test(mobile);
  }

  verifyOtp() {
    if (!this.isValidMobile(this.mobile)) {
      this.otpError = '❗ Enter valid 10-digit mobile number';
      return;
    }

    if (this.otp !== '1234') {
      this.otpError = '❌ Invalid OTP. Try 1234';
      return;
    }

    this.otpError = '';
    this.step = 2;
  }

  completeSignup() {
    if (this.userId.trim().length <= 4) {
      this.userIdError = '❗ User ID must be more than 4 characters';
      return;
    }

    this.userIdError = '';

    this.backService.signUp( {
      phoneNumber: this.mobile,
      userId: this.userId,
      password: this.password
    }).subscribe((res:any) => {
      if(res.success) {
      
        this.alert.showAlert('success', '🎉 Signup Successful');
        // Or however you set it
        this.router.navigate(['/dashboard']);
        this.backService.setUserId(this.userId);
      } else {
        alert(res.message);
      }
      this.reset();
    })    
  }

  reset() {
    this.step = 1;
    this.mobile = '';
    this.otp = '';
    this.userId = '';
    this.password = '';
    this.otpError = '';
    this.userIdError = '';
  }
}

import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AlertService } from '../alert.service';
import { BackendService } from '../backend.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss'
})
export class SigninComponent {
  constructor(private alert: AlertService, private backendService: BackendService, private router: Router) {}
   username = '';
  password = '';
  error = '';

  signIn() {
    if (!this.username || !this.password) {
      this.error = '❗ Both fields are required';
      return;
    }


    console.log('User signed in:', {
      userId: this.username,
      password: this.password
    });
    this.backendService.signIn({
      userId: this.username,
      password: this.password
    }).subscribe((res:any) => {
      if(res.success)
      {
        this.alert.showAlert('success', 'Succesful Sig In!');
        this.backendService.setUserId(res.userId); // Or however you set it
        this.router.navigate(['/dashboard']);
        this.backendService.setUserId(this.username);
      }
    else {
      this.alert.showAlert('danger', ' Sig In Failed!'); 
    }
    });
    this.error = '';
  }
}

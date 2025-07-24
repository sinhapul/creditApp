import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-signin',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss'
})
export class SigninComponent {
   username = '';
  password = '';
  error = '';

  signIn() {
    if (!this.username || !this.password) {
      this.error = '❗ Both fields are required';
      return;
    }

    // Simulate sign-in success
    console.log('User signed in:', {
      username: this.username,
      password: this.password
    });
    alert('✅ Signed in successfully!');
    this.error = '';
  }
}

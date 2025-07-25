import { ChangeDetectorRef, Component } from '@angular/core';
import { ApplyFormComponent } from '../apply-form/apply-form.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BackendService } from '../backend.service';
import { AlertService } from '../alert.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-content',
  standalone: true,
  imports: [ CommonModule, RouterModule, FormsModule],
  templateUrl: './content.component.html',
  styleUrl: './content.component.scss'
})
export class ContentComponent {
  user ='';
  constructor(private backendService: BackendService, private cdr: ChangeDetectorRef, private alert: AlertService) {
    backendService.userId$.subscribe(res => {
      this.user = res;
    })
  }
  showApplyForm = false;
  onApply() {
    this.showApplyForm = true;
  }


  contact = {
    name: '',
    email: '',
    message: ''
  };

  submitContact() {
    this.alert.showAlert('success', 'Thanks for contacting us! We will get back to you soon.');
    
    // Optionally reset form:
    this.contact = {
      name: '',
      email: '',
      message: ''
    };
  }
}

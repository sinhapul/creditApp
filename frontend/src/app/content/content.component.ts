import { Component } from '@angular/core';
import { ApplyFormComponent } from '../apply-form/apply-form.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-content',
  standalone: true,
  imports: [ApplyFormComponent, CommonModule, RouterModule],
  templateUrl: './content.component.html',
  styleUrl: './content.component.scss'
})
export class ContentComponent {
  showApplyForm = false;
  onApply() {
    this.showApplyForm = true;
  }
}

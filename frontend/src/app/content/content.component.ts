import { ChangeDetectorRef, Component } from '@angular/core';
import { ApplyFormComponent } from '../apply-form/apply-form.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BackendService } from '../backend.service';

@Component({
  selector: 'app-content',
  standalone: true,
  imports: [ApplyFormComponent, CommonModule, RouterModule],
  templateUrl: './content.component.html',
  styleUrl: './content.component.scss'
})
export class ContentComponent {
  user ='';
  constructor(private backendService: BackendService, private cdr: ChangeDetectorRef) {
    backendService.userId$.subscribe(res => {
      this.user = res;
    })
  }
  showApplyForm = false;
  onApply() {
    this.showApplyForm = true;
  }
}

import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { BackendService } from '../backend.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  userId = '';
  constructor(private backendService: BackendService) {
    backendService.userId$.subscribe((res:any) => {
      this.userId = res;
    })
  }

  loans = ['Small Scale', 'Emergency', 'Education', 'Agriculture', 'Vehicle'];
  schemes = ['PM Mudra Yojana', 'E-Kisan Nidhi', 'Stand Up India', 'Athma Nirbhar Nidhi'];
  rewards = [
    { label: 'Aadhaar Verification', points: 5 },
    { label: 'Mobile Verification', points: 5 },
    { label: 'Training Module', points: 10 },
  ];
}

import { ChangeDetectorRef, Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { BackendService } from '../backend.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  userId = '';
  constructor(private backendService: BackendService, private cdr: ChangeDetectorRef, private router:Router) {
  }

  ngOnInit() {
    console.log("inti")
    this.backendService.userId$.subscribe(res => {
      this.userId = res;
      console.log('Updated...');
    })
  }

  logOut() {
    this.userId = '';
    this.cdr.detectChanges();
    this.router.navigate(['/']);
  }

  handleTrack(event: Event) {
  const selectedValue = (event.target as HTMLSelectElement).value;
  if (selectedValue === 'track') {
    this.router.navigate(['/track']);
  } else if (selectedValue === 'dashboard') {
    this.router.navigate(['/dashboard']);
  }
}
}

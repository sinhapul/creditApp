import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import { ContentComponent } from '../content/content.component';
import { RouterModule, RouterOutlet } from "@angular/router";

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [HeaderComponent, FooterComponent, RouterOutlet, RouterModule],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.scss'
})
export class WelcomeComponent {

}

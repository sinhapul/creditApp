import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { FooterComponent } from '../footer/footer.component';
import { RouterModule, RouterOutlet } from "@angular/router";
import { ChatbotComponent } from '../chatbot/chatbot.component';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [HeaderComponent, FooterComponent, RouterOutlet, RouterModule, ChatbotComponent],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.scss'
})
export class WelcomeComponent {

}

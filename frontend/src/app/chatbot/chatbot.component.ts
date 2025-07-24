import { CommonModule } from '@angular/common';
import { Component, HostListener } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BackendService } from '../backend.service';

@Component({
  selector: 'app-chatbot',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './chatbot.component.html',
  styleUrl: './chatbot.component.scss',
  providers:[BackendService]
})
export class ChatbotComponent {
  isChatOpen = false;
  selectedLang = 'en';
  userInput = '';
  chatHistory: { sender: 'user' | 'bot', text: string }[] = [];

  constructor(private service: BackendService) {}

  toggleChat() {
    this.isChatOpen = !this.isChatOpen;
  }

  async sendMessage() {
    const msg = this.userInput.trim();
    if (!msg) return;
    this.chatHistory.push({ sender: 'user', text: msg });
    this.service.response(msg).subscribe((res:any) => {
      this.chatHistory.push({ sender: 'bot', text: res.reply });
    });
    this.userInput = '';
  }

  // Trigger send on Enter
  @HostListener('document:keydown.enter', ['$event'])
  handleEnter(event: KeyboardEvent) {
    if (this.isChatOpen && document.activeElement?.tagName === 'INPUT') {
      this.sendMessage();
    }
  }
}

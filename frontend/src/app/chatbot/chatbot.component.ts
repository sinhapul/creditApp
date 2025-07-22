import { CommonModule } from '@angular/common';
import { Component, HostListener } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-chatbot',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './chatbot.component.html',
  styleUrl: './chatbot.component.scss'
})
export class ChatbotComponent {
  isChatOpen = false;
  selectedLang = 'en';
  userInput = '';
  chatHistory: { sender: 'user' | 'bot', text: string }[] = [];

  toggleChat() {
    this.isChatOpen = !this.isChatOpen;
  }

  sendMessage() {
    const msg = this.userInput.trim();
    if (!msg) return;

    // Add user's message
    this.chatHistory.push({ sender: 'user', text: msg });

    // Add bot response
    const reply = this.selectedLang === 'hi'
      ? 'हमारी वेबसाइट में आपका स्वागत है।'
      : 'Welcome to our website';

    setTimeout(() => {
      this.chatHistory.push({ sender: 'bot', text: reply });
    }, 300); // simulate delay

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

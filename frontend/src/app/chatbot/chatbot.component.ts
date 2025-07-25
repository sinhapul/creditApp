import { CommonModule } from '@angular/common';
import { Component, HostListener } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BackendService } from '../backend.service';

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
  isListening = false;
recognition: any;


  constructor(private service: BackendService) {}

  ngOnInit() {
  const SpeechRecognition = (window as any).SpeechRecognition || (window as any).webkitSpeechRecognition;
  this.recognition = new SpeechRecognition();
  this.recognition.lang = this.selectedLang === 'hi' ? 'hi-IN' : 'en-IN';
  this.recognition.interimResults = false;

  this.recognition.onresult = (event: any) => {
    const transcript = event.results[0][0].transcript;
    this.userInput = transcript;
    this.sendMessage();
  };

  this.recognition.onend = () => {
    this.isListening = false;
  };

  this.recognition.onerror = (e: any) => {
    console.error('Mic error:', e);
    this.isListening = false;
  };
}

toggleMic() {
  if (this.isListening) {
    this.recognition.stop();
    this.isListening = false;
  } else {
    this.recognition.lang = this.selectedLang === 'hi' ? 'hi-IN' : 'en-IN';
    this.recognition.start();
    this.isListening = true;
  }
}



  toggleChat() {
    this.isChatOpen = !this.isChatOpen;
  }

  // async sendMessage() {
  //   const msg = this.userInput.trim();
  //   if (!msg) return;
  //   this.chatHistory.push({ sender: 'user', text: msg });
  //   this.service.response(msg).subscribe((res:any) => {
  //     this.chatHistory.push({ sender: 'bot', text: res.reply });
  //   });
  //   this.userInput = '';
  // }

  // Trigger send on Enter
  @HostListener('document:keydown.enter', ['$event'])
  handleEnter(event: KeyboardEvent) {
    if (this.isChatOpen && document.activeElement?.tagName === 'INPUT') {
      this.sendMessage();
    }
  }

  speak(text: string) {
  const synth = window.speechSynthesis;
  const utterance = new SpeechSynthesisUtterance(text);
  utterance.lang = this.selectedLang === 'hi' ? 'hi-IN' : 'en-IN';
  synth.speak(utterance);
}

async sendMessage() {
  const msg = this.userInput.trim();
  if (!msg) return;

  console.log(msg);

  this.chatHistory.push({ sender: 'user', text: msg });
  this.userInput = '';

  this.service.response(msg).subscribe((res: any) => {
    this.chatHistory.push({ sender: 'bot', text: res.reply });
    this.speak(res.reply);
  });

  // this.speak("Hello Pulak ji Kya haal chal")
}

}

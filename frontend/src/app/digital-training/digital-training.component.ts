import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-digital-training',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './digital-training.component.html',
  styleUrl: './digital-training.component.scss'
})
export class DigitalTrainingComponent {
step = 0;

  tutorials = [
    {
      title: '📱 मोबाइल कैसे चलाएं',
      image: '/assets/mobile.png',
      command: 'फोन को पावर बटन से ऑन करें। फिर स्क्रीन पर ऊपर से नीचे स्लाइड कर के ऐप्स खोलें।',
    },
    {
      title: '⬇️ UPI ऐप इंस्टॉल करें',
      image: 'assets/playstore.png',
      command: 'Play Store खोलें, "Paytm" टाइप करें और Install बटन दबाएं।',
    },
    {
      title: '🔐 UPI सेटअप करें',
      image: 'assets/paytm.png',
      command: 'Paytm खोलें, बैंक जोड़ें और UPI PIN सेट करें। PIN गुप्त रखें।',
    },
    {
      title: '💸 पैसे भेजें / QR स्कैन करें',
      image: 'assets/scanpay.png',
      command: 'QR को स्कैन करें या UPI ID पर पैसे भेजें। भुगतान करने के लिए "Pay" दबाएं।',
    }
  ];

  next() {
    if (this.step < this.tutorials.length - 1) this.step++;
  }

  prev() {
    if (this.step > 0) this.step--;
  }
}

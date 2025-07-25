import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

export interface Alert {
  type: 'success' | 'danger' | 'info';
  message: string;
}

@Injectable({ providedIn: 'root' })
export class AlertService {
  private alertSubject = new BehaviorSubject<Alert | null>(null);
  alert$ = this.alertSubject.asObservable();

  showAlert(type: Alert['type'], message: string) {
    this.alertSubject.next({ type, message });

    setTimeout(() => {
      this.alertSubject.next(null); // auto dismiss after 3 seconds
    }, 3000);
  }
}

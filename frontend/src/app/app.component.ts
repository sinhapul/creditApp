import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavigationEnd, Router, RouterOutlet} from '@angular/router';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {first, map, tap} from "rxjs/operators";
import { WelcomeComponent } from "./welcome/welcome.component";
declare var google: any;


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, HttpClientModule, WelcomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'frontend';
  message = '';

  constructor(private readonly http: HttpClient, private router:Router) {
  }

  ngAfterViewInit(): void {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.loadGoogleTranslate();
      }
    });

    this.loadGoogleTranslate();
  }

  loadGoogleTranslate() {
    const gtEl = document.getElementById('google_translate_element');
    if (gtEl && !gtEl.innerHTML.trim()) {
      new google.translate.TranslateElement(
        {
          pageLanguage: 'en',
          includedLanguages: 'hi,ur,en',
          layout: google.translate.TranslateElement.InlineLayout.SIMPLE,
        },
        'google_translate_element'
      );
    }
  }

  ngOnInit(): void {
    this.http.get<{message: string}>('http://localhost:8080/message').pipe(
      first(),
      tap(result => console.log('Message received from the server: ', result)),
      map(result => this.message = result.message)
    ).subscribe();
  }
}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  httpHeader = {
    headers: new HttpHeaders({

    })
  }

  constructor(private httpClient: HttpClient) { }

  response(msg: string): Observable<any> {
    const apiUrl = 'http://localhost:8080/api/v1/chat';
    let body = {
      "message": msg
    };
    return this.httpClient.post<any>(apiUrl, body, this.httpHeader);
  }
}

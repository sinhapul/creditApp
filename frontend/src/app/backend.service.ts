import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  // _userId = new BehaviorSubject<string>(''); 
  // userId = this._userId.asObservable();/

  private _userId = new BehaviorSubject<string>('');  // default: empty string
  public userId$ = this._userId.asObservable();       // expose as observable

  // Call this to update the userId
  setUserId(id: string) {
    console.log('come')
    this._userId.next(id);
  }


  httpHeader = {
    headers: new HttpHeaders({

    })
  }

  constructor(private httpClient: HttpClient) {
    this.userId$.subscribe(res => console.log(res));
   }

  response(msg: string): Observable<any> {
    const apiUrl = 'http://localhost:8080/api/v1/chat';
    let body = {
      "message": msg
    };
    return this.httpClient.post<any>(apiUrl, body, this.httpHeader);
  }

  signUp(body:any): Observable<any> {
    const apiUrl = 'http://localhost:8080/api/v1/auth/signup';
    return this.httpClient.post<any>(apiUrl, body,this.httpHeader);
  }

  submitApplication() {
    const apiUrl = 'http://localhost:8080/api/v1/auth/signup';
    let user;
    this.userId$.subscribe(res => {
      user = res;
    })
    let body :any = {
      userId : user,
      age : 24,
      gender : "Male",
      electricityBill: 21771,
      waterBill : 2611
    };
    this.httpClient.post<any>(apiUrl, body,this.httpHeader);
  }
}

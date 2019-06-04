import { IHomevsAway } from './../Model/home.vs.away.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Homevsaway {
  url = 'http://localhost:8091/api/foothvsa';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json' })
  };

  constructor(private http: HttpClient) {
   }

   getFirstVsSecontMatch(): Observable<IHomevsAway> {
    return this.http.post<IHomevsAway>(this.url + '/', this.httpOptions);
  }
}

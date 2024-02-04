// fund.service.ts

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FundResponse } from './fund-list/fund-list.component';

@Injectable({
  providedIn: 'root'
})
export class FundService {
  private apiUrl = 'https://ivarpivar.netlify.app/api'; // Replace with your actual API endpoint

  constructor(private http: HttpClient) { }

  getFunds(): Observable<FundResponse> { // Update the return type here
    return this.http.get<FundResponse>(this.apiUrl);
  }
}

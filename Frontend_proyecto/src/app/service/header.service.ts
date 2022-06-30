import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Info } from '../models/Info';

@Injectable({
  providedIn: 'root',
})
export class HeaderService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public getUser(): Observable<Info> {
    return this.http.get<Info>(`${this.apiServerUrl}/info/id/1`);
  }
  public updateUser(info: Info): Observable<Info> {
    return this.http.put<Info>(`${this.apiServerUrl}/update`, info);
  }
}

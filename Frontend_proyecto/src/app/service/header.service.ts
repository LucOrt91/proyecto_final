import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { persona } from '../models/persona.model';

@Injectable({
  providedIn: 'root',
})
export class HeaderService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public getUser(): Observable<persona> {
    return this.http.get<persona>(`${this.apiServerUrl}/personas/traer`);
  }
  public updateUser(persona: persona): Observable<persona> {
    return this.http.put<persona>(`${this.apiServerUrl}/update`, persona);
  }
}

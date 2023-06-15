import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skill } from '../models/skill.model';

@Injectable({
  providedIn: 'root',
})
export class SkillService {
  URL = 'https://be-portfolio.onrender.com/skill/';

  constructor(private httpClient: HttpClient) {}

  public lista(): Observable<Skill[]> {
    return this.httpClient.get<Skill[]>(this.URL + 'lista');
  }

  public detail(idSkill: number): Observable<Skill> {
    return this.httpClient.get<Skill>(this.URL + `detail/${idSkill}`);
  }

  public save(skill: Skill): Observable<any> {
    return this.httpClient.post<any>(this.URL + 'create', skill);
  }

  public update(idSkill: number, skill: Skill): Observable<any> {
    return this.httpClient.put<any>(this.URL + `update/${idSkill}`, skill);
  }

  public delete(idSkill: number): Observable<any> {
    return this.httpClient.delete<any>(this.URL + `delete/${idSkill}`);
  }
}

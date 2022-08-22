import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from '../models/proyecto.model';



@Injectable({
  providedIn: 'root',
})
export class ProyectoService {
  URL = 'https://beportfoliolucas.herokuapp.com//proyecto/';

  constructor(private httpClient : HttpClient) { }

  public lista(): Observable<Proyecto[]>{
    return this.httpClient.get<Proyecto[]>(this.URL + 'lista');
  }

  public detail(idPro: number): Observable<Proyecto>{
    return this.httpClient.get<Proyecto>(this.URL + `detail/${idPro}`);
  }

  public save(proyecto: Proyecto): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', proyecto);
  }

  public update(idPro: number, proyecto: Proyecto): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${idPro}`, proyecto);
  }

  public delete(idPro: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${idPro}`);
  }
}
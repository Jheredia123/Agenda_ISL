import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bateria } from './model/Bateria';



@Injectable({
  providedIn: 'root'
})
export class BateriaService {



  private apiUrl = 'http://localhost:8080/geos/bateria'; 
  constructor(private http: HttpClient) { }

  // Obtener todas las baterías
  getBaterias(): Observable<Bateria[]> {
    return this.http.get<Bateria[]>(this.apiUrl);
  }

  // Obtener una batería por ID
  getBateria(id: number): Observable<Bateria> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Bateria>(url);
  }

  // Crear una nueva batería
  createBateria(bateria: Bateria): Observable<Bateria> {
    return this.http.post<Bateria>(this.apiUrl, bateria);
  }

  // Actualizar una batería existente
  updateBateria(id: number, bateria: Bateria): Observable<Bateria> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.put<Bateria>(url, bateria);
  }

  // Eliminar una batería
  deleteBateria(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}
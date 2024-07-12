import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Examen } from '../model/Examen';



@Injectable({
  providedIn: 'root'
})
export class ExamenService {
  private apiUrl = 'http://localhost:8080/geos/examen'; // Ajusta la URL base según tu configuración

  constructor(private http: HttpClient) { }

  // Método para buscar exámenes por ID de batería
  buscarPorIdBateria(idBateria: number): Observable<Examen[]> {
    const url = `${this.apiUrl}/buscarPorBateria/${idBateria}`;
    return this.http.get<Examen[]>(url);
  }
}
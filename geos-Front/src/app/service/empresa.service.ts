import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empresa } from '../model/empresa.model';



@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  private apiUrl = 'http://localhost:8080/geos/empleadores'; // URL del endpoint de la API

  constructor(private http: HttpClient) { }

  getAllEmpleadores(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(this.apiUrl);
  }

  getEmpleadorById(id: number): Observable<Empresa> {
    return this.http.get<Empresa>(`${this.apiUrl}/${id}`);
  }

  getEmpresaByRut(rut: string): Observable<Empresa> {
    return this.http.get<Empresa>(`${this.apiUrl}/buscarPorRut/${rut}`);
  }

  createEmpleador(empleador: Empresa): Observable<Empresa> {
    return this.http.post<Empresa>(this.apiUrl, empleador);
  }

  updateEmpleador(id: number, empleador: Empresa): Observable<Empresa> {
    return this.http.put<Empresa>(`${this.apiUrl}/${id}`, empleador);
  }

  deleteEmpleador(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

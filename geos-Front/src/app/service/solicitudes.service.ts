import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Solicitud } from '../model/Solicitud.model';

@Injectable({
  providedIn: 'root'
})
export class SolicitudesService {

  private apiUrl = 'http://localhost:8080/geos/solicitudes'; // URL de tu API

  constructor(private http: HttpClient) { }

  guardarSolicitud(solicitud: any): Observable<Solicitud> {
    return this.http.post<Solicitud>(this.apiUrl, solicitud);
  }


  getSolicitudes(): Observable<Solicitud[]> {
    return this.http.get<Solicitud[]>(this.apiUrl);
  }
}

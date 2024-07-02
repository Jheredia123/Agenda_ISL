import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Usuario } from '../model/usuario.model';
import { UsuarioService } from './usuario.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://localhost:8080/geos/login/';
  private apiUrlEjemplo  = 'http://localhost:8080/geos/usuarios/ejemplo';

  constructor(private http: HttpClient, private usuarioService: UsuarioService) { }

  ejemplo(): Observable<any> {
      // Realiza la solicitud GET con los parámetros en la URL
    return this.http.get<any>(`${this.apiUrlEjemplo}`);
  }


  login(rut: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('rut', rut)
      .set('password', password);

    return this.http.post<any>(this.apiUrl, null, { params }).pipe(
      catchError(error => {
        // Handle error appropriately (e.g., log it, transform it, throw a custom error)
        return throwError(error);
      })
    );
  }

  handleLoginResponse(response: any): void {
    const usuario = new Usuario(
      response.id,
      response.rut,
      response.nombres,
      response.apellidos,
      response.region,
      response.comuna,
      response.tipo,
      response.email,
      response.fono,
      response.clave,
      response.vigente
    );
    this.usuarioService.setUsuario(usuario);
  }
}

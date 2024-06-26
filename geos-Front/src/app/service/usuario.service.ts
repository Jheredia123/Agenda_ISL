import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private readonly localStorageKey = 'usuario';

  constructor() { }

  setUsuario(usuario: Usuario): void {
    localStorage.setItem(this.localStorageKey, JSON.stringify(usuario));
  }

  getUsuario(): Usuario | null {
    const usuarioJson = localStorage.getItem(this.localStorageKey);
    if (usuarioJson) {
      return JSON.parse(usuarioJson);
    }
    return null;
  }

  clearUsuario(): void {
    localStorage.removeItem(this.localStorageKey);
  }

}

import { MediaMatcher } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent  implements OnInit {
  usuario: Usuario | null = null;
  mobileQuery: MediaQueryList;

  menuNav = [
    {name: "Dashboard", route: "home", icon: "home"},
    {name: "Solicitudes", route: "solicitud", icon: "create_new_folder"},
    {name: "Agenda", route: "home", icon: "notes"}
  ]

  constructor(media: MediaMatcher, private usuarioService: UsuarioService,private router: Router) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
  }
  ngOnInit(): void {
    this.usuario = this.usuarioService.getUsuario();
  }

  logout(): void {
    // Elimina los datos del usuario del LocalStorage
    this.usuarioService.clearUsuario();
    
    // Redirige al usuario a la página de inicio de sesión
    this.router.navigate(['/login']);
  }

}

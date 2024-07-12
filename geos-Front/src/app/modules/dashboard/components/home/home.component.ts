import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario.model';
import { SolicitudesService } from 'src/app/service/solicitudes.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements  OnInit {
  usuario: Usuario | null = null;
  cantidadSolicitudes: number | undefined; 
  
  constructor(private usuarioService: UsuarioService, private solicitudService: SolicitudesService) {}


  ngOnInit(): void {
    this.solicitudService.getSolicitudes().subscribe(solicitudes => {
      this.cantidadSolicitudes = solicitudes.length;
    });

    this.usuario = this.usuarioService.getUsuario();

    
    if (this.usuario?.tipo === 'ADMIN') {

    } else {

    }

   
  }


}


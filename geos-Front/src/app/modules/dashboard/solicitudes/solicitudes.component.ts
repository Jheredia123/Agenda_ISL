import { CdkTableDataSourceInput } from '@angular/cdk/table';
import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-solicitudes',
  templateUrl: './solicitudes.component.html',
  styleUrls: ['./solicitudes.component.css']
})
export class SolicitudesComponent {

solicitud = {
  run: '',
  nombres: '',
  apellidos: '',
  fechaCreacion: new Date(),
  razonSocial: '',
  direccion: '',
  region: '',
  comuna: '',
  actividadEconomica: '',
  examen: ''
};
  
  // Definición de las columnas de la tabla
  examColumns: string[] = ['nombre', 'recomendacion'];

  // Data para la tabla
  examenes = new MatTableDataSource([
    { nombre: 'Examen 1', recomendacion: 'Recomendación 1' },
    { nombre: 'Examen 2', recomendacion: 'Recomendación 2' },
    { nombre: 'Examen 3', recomendacion: 'Recomendación 3' }
  ]);

  regiones = ['Región 1', 'Región 2', 'Región 3'];
  comunas = ['Comuna 1', 'Comuna 2', 'Comuna 3'];
  actividadesEconomicas = ['Actividad 1', 'Actividad 2', 'Actividad 3'];

  trabajadores = [
    { rut: '111111-1', nombre: 'Giacomo Guillizzoni', edad: 32 },
    { rut: '222222-2', nombre: 'Marco Botton', edad: 38 },
    { rut: '333333-3', nombre: 'Mariah Maclachlan', edad: 41 },
  ];

  displayedColumns: string[] = ['rut', 'nombre', 'edad', 'descargar'];


actividades: any;

  // agregarTrabajador() {
  //   // Logic to add a new worker
  // }

  // crearSolicitud() {
  //   // Logic to create the solicitud
  // }

    // Método para manejar el clic en el botón de recomendación
    verRecomendaciones(examen: any): void {
      console.log('Recomendaciones para:', examen.nombre);
    }
}
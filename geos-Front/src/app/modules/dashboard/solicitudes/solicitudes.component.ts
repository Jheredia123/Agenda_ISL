import { CdkTableDataSourceInput } from '@angular/cdk/table';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepicker } from '@angular/material/datepicker';
import { MatTableDataSource } from '@angular/material/table';
import { Usuario } from 'src/app/model/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';
import { ReactiveFormsModule } from '@angular/forms';
import { EmpresaService } from 'src/app/service/empresa.service';
import { Empresa } from 'src/app/model/empresa.model';
import { rutValidator } from '../../shared/rut-validator';

@Component({
  selector: 'app-solicitudes',
  templateUrl: './solicitudes.component.html',
  styleUrls: ['./solicitudes.component.css']
})
export class SolicitudesComponent implements OnInit {

  usuario: Usuario | null = null;
  solicitudForm: FormGroup;
  readonly date = new Date();
  empresaEncontrada: Empresa | undefined;;

  constructor(private fb: FormBuilder, private usuarioService: UsuarioService, private empresaService: EmpresaService) {
    this.usuario = this.usuarioService.getUsuario();
    const today = new Date();
    this.solicitudForm = this.fb.group({
      run: [{ value: this.usuario?.rut, disabled: true }],
      nombres: [{ value: this.usuario?.nombres, disabled: true }],
      apellidos: [{ value: this.usuario?.apellidos, disabled: true }],
      fechaCreacion: [{ value: today, disabled: true }],
      rutEmpresa: ['',  [Validators.required, rutValidator()]],
      razonSocial: [''],
      direccion: [''],
      region: [''],
      comuna: [''],
      actividadEconomica: [''],
      descripcion: [''],
      examen: ['']

    });
  }

  ngOnInit(): void {

    console.log('Usuario en session:', this.usuario);
    if (this.usuario) {
      this.solicitudForm.patchValue(this.usuario);
    }
    console.log('Usuario en session  :' + this.usuario);



  }
  displayedColumns: string[] = ['rut', 'nombre', 'edad', 'descargar'];

  errorMessage: string = '';
  actividades: any;



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



  verRecomendaciones(examen: any): void {
    console.log('Recomendaciones para:', examen.nombre);
  }


  buscarEmpresaPorRut():void {
    const rut = this.solicitudForm.get('rutEmpresa')?.value;
    if (this.solicitudForm.get('rutEmpresa')?.valid) {
      this.empresaService.getEmpresaByRut(rut)
        .subscribe({
          next: (response) => {
            this.empresaEncontrada = response;          
            this.solicitudForm.controls['razonSocial'].setValue(this.empresaEncontrada.razonSocial);
            this.solicitudForm.controls['direccion'].setValue(this.empresaEncontrada.direccion);
            this.solicitudForm.controls['region'].setValue(this.empresaEncontrada.region);
            this.solicitudForm.controls['comuna'].setValue(this.empresaEncontrada.comuna);
            this.errorMessage= '';
          },
          error: (error) => {
            // Manejar errores de login
            if (error.status === 400) {
              this.errorMessage = 'Rut o contraseña inválidos. Verifica tus credenciales.';
            } else {
              this.errorMessage = 'Error en el servidor. Rut no existe.';
            }
          }
        });
    }
  }




}
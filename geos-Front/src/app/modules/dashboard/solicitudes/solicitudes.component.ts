import { CdkTableDataSourceInput } from '@angular/cdk/table';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { MatDatepicker } from '@angular/material/datepicker';
import { MatTableDataSource } from '@angular/material/table';
import { Usuario } from 'src/app/model/usuario.model';
import { UsuarioService } from 'src/app/service/usuario.service';
import { ReactiveFormsModule } from '@angular/forms';
import { EmpresaService } from 'src/app/service/empresa.service';
import { Empresa } from 'src/app/model/empresa.model';
import { rutValidator } from '../../shared/rut-validator';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-solicitudes',
  templateUrl: './solicitudes.component.html',
  styleUrls: ['./solicitudes.component.css']
})
export class SolicitudesComponent implements OnInit {

  
  usuario: Usuario | null = null;
  solicitudForm: FormGroup;
  readonly date = new Date();
  empresaEncontrada: Empresa | undefined;
  showError: boolean = false;
  regiones = [];
  comunas = [];
  actividadesEconomicas = [];
  displayedColumns: string[] = ['rut', 'nombre', 'edad', 'actions'];
  trabajadores: FormArray | undefined;
  dataSource = new MatTableDataSource<any>();  
  errorMessage: string = '';
  actividades: any;




  constructor(private fb: FormBuilder, private usuarioService: UsuarioService, private empresaService: EmpresaService,
    private snackBar: MatSnackBar) {
    this.usuario = this.usuarioService.getUsuario();
    const today = new Date();
    this.solicitudForm = this.fb.group({
      run: [{ value: this.usuario?.rut, disabled: true }],
      nombres: [{ value: this.usuario?.nombres, disabled: true }],
      apellidos: [{ value: this.usuario?.apellidos, disabled: true }],
      fechaCreacion: [{ value: today, disabled: true }],
      rutEmpresa: ['', [Validators.required, rutValidator()]],
      razonSocial: [''],
      direccion: [''],
      region: [''],
      comuna: [''],
      actividadEconomica: [''],
      descripcion: [''],
      examen: [''],
      trabajadores: this.fb.array([])
    });
    this.trabajadores = this.solicitudForm.get('trabajadores') as FormArray;
    this.dataSource.data = this.trabajadores.controls;
  }


  ngOnInit(): void {

    console.log('Usuario en session:', this.usuario);
    if (this.usuario) {
      this.solicitudForm.patchValue(this.usuario);
    }
    console.log('Usuario en session  :' + this.usuario);
  }


  // Definición de las columnas de la tabla
  examColumns: string[] = ['nombre', 'recomendacion'];

  // Data para la tabla
  examenes = new MatTableDataSource([
    { nombre: 'Examen 1', recomendacion: 'Recomendación 1' },
    { nombre: 'Examen 2', recomendacion: 'Recomendación 2' },
    { nombre: 'Examen 3', recomendacion: 'Recomendación 3' }
  ]);


  verRecomendaciones(examen: any): void {
    console.log('Recomendaciones para:', examen.nombre);
  }


  buscarEmpresaPorRut(): void {
    const rut = this.solicitudForm.get('rutEmpresa')?.value;
    if (this.solicitudForm.get('rutEmpresa')?.valid) {
      this.empresaService.getEmpresaByRut(rut).subscribe({
        next: (response) => {
          this.empresaEncontrada = response;
          this.solicitudForm.controls['razonSocial'].setValue(this.empresaEncontrada.razonSocial);
          this.solicitudForm.controls['razonSocial'].disable();
          this.solicitudForm.controls['direccion'].setValue(this.empresaEncontrada.direccion);
          this.solicitudForm.controls['direccion'].disable();
          this.solicitudForm.controls['region'].setValue(this.empresaEncontrada.region);
          this.solicitudForm.controls['region'].disable();
          this.solicitudForm.controls['comuna'].setValue(this.empresaEncontrada.comuna);
          this.solicitudForm.controls['comuna'].disable();
          this.solicitudForm.controls['actividadEconomica'].setValue(this.empresaEncontrada.actividadEconomica.codigoAE);
          this.solicitudForm.controls['actividadEconomica'].disable();
          this.solicitudForm.controls['descripcion'].setValue(this.empresaEncontrada.actividadEconomica.descripcion);
          this.solicitudForm.controls['descripcion'].disable();
          this.errorMessage = '';
        },
        error: (error) => {
          if (error.status == 404) {
            this.errorMessage = 'Empleador no afiliado';
          } else if (error.status === 400) {
            this.errorMessage = 'Rut o contraseña inválidos. Verifica tus credenciales.';
          } else {
            this.errorMessage = 'Error en el servidor. Inténtelo más tarde.';
          }
          this.showErrorSnackbar(this.errorMessage);
        }
      });
    }


  }
  showErrorSnackbar(message: string): void {
    this.snackBar.open(this.errorMessage, 'Cerrar', {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'top',
    });
  }

  createTrabajador(): FormGroup {
    return this.fb.group({
      rut: ['', Validators.required],
      nombre: ['', Validators.required],
      edad: ['', Validators.required]
    });
  }

  addTrabajador(): void {
    if (this.trabajadores) {
      this.trabajadores.push(this.createTrabajador());
      this.dataSource.data = this.trabajadores.controls;
    }
  }

  removeTrabajador(index: number): void {
    if (this.trabajadores) {
      this.trabajadores.removeAt(index);
      this.dataSource.data = this.trabajadores.controls;
    }
  }




}
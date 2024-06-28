import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './components/home/home.component';
import { DashboardComponent } from './pages/dashboard.component';
import { SharedModule } from '../shared/shared.module';
import { SolicitudesComponent } from './solicitudes/solicitudes.component';
import { MatTableModule } from '@angular/material/table';
import { MaterialModule } from '../shared/material.module';
import { ReactiveFormsModule } from '@angular/forms';
// Otros imports



@NgModule({
  declarations: [
    DashboardComponent,
    HomeComponent,
    SolicitudesComponent
  ],
  imports: [
    CommonModule,
    SharedModule, 
    MaterialModule,
    ReactiveFormsModule,
  ]
})
export class DashboardModule { }

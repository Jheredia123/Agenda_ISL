import { Component, OnInit } from '@angular/core';
import { SolicitudesService } from 'src/app/service/solicitudes.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements  OnInit {

  cantidadSolicitudes: number | undefined;

  constructor(private solicitudService: SolicitudesService) {}
  ngOnInit(): void {

  }
}

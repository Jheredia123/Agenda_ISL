import { Examen } from "./Examen";
import { Trabajador } from "./Trabajador.model";

export interface Solicitud {
    run: string;
    nombres: string;
    apellidos: string;
    fechaCreacion: Date;
    rutEmpresa: string;
    razonSocial: string;
    direccion: string;
    region: string;
    comuna: string;
    actividadEconomica: string;
    descripcion: string;
    trabajadores: Trabajador[];
    bateria: string;
    examenes: Examen[];
  }
  


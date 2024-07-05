import { Bateria } from "./Bateria";

export interface Examen {
    idExamen: number;
    nombre: string;
    evaluacion: string;
    // Ajusta según las propiedades de tu entidad Examen
    bateria : Bateria;
  }
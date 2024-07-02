import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function rutValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const rut = control.value;
    if (!rut) {
      return null;
    }

    // Limpiar el RUT eliminando puntos y guiones
    const cleanRut = rut.replace(/[^0-9kK]/g, '').toUpperCase();

    // Validar formato del RUT
    if (!/^\d{7,8}[0-9K]$/.test(cleanRut)) {
      return { invalidRut: 'El RUT debe tener un formato válido' };
    }

    // Validar dígito verificador
    const body = cleanRut.slice(0, -1);
    const verifier = cleanRut.slice(-1);
    const calculatedVerifier = calculateRutVerifier(body);
    
    if (verifier !== calculatedVerifier) {
      return { invalidRut: 'El RUT no es válido' };
    }

    return null;
  };
}

function calculateRutVerifier(body: string): string {
  let sum = 0;
  let multiplier = 2;
  
  for (let i = body.length - 1; i >= 0; i--) {
    sum += parseInt(body.charAt(i), 10) * multiplier;
    multiplier = (multiplier < 7) ? multiplier + 1 : 2;
  }
  
  const remainder = sum % 11;
  const result = 11 - remainder;
  
  if (result === 11) {
    return '0';
  } else if (result === 10) {
    return 'K';
  } else {
    return result.toString();
  }
}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

   error: string ='';
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private router: Router, private loginService: LoginService) {
    this.loginForm = this.fb.group({
      rut: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      rut: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { rut, password } = this.loginForm.value;
      console.log('Username:', rut);
      console.log('Password:', password);

      // Aquí puedes agregar tu lógica de autenticación
      this.loginService.login(rut, password)
      .subscribe({
        next: (response) => {
          // Manejar la respuesta exitosa, redirigir, almacenar tokens, etc.
          console.log('Login exitoso:', response);
          this.loginService.handleLoginResponse(response);
          this.router.navigate(['/dashboard']);
        },
        error: (error) => {
          // Manejar errores de login
          if (error.status === 400) {
            this.errorMessage = 'Rut o contraseña inválidos. Verifica tus credenciales.';
          } else {
            this.errorMessage = 'Error en el servidor. Inténtalo nuevamente más tarde.';
          }
        }
      });


    }
  }

}

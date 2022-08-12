import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/models/proyecto.model';
import { ProyectoService } from 'src/app/service/proyecto.service';
;
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css'],
})
export class ProyectoComponent implements OnInit {
  proyecto: Proyecto[] = [];

  constructor(
    private proyectoS: ProyectoService,
    private tokenService: TokenService
  ) {}
  isLogged = false;

  ngOnInit(): void {
    this.cargarProyecto();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProyecto(): void {
    this.proyectoS.lista().subscribe((data) => {
      this.proyecto = data;
    });
  }

  delete(idPro?: number) {
    if (idPro != undefined) {
      this.proyectoS.delete(idPro).subscribe(
        (data) => {
          this.cargarProyecto();
        },
        (err) => {
          alert('No se pudo eliminar');
        }
      );
    }
  }
}

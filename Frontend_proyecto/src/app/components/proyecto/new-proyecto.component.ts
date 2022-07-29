import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/models/proyecto.model';
import { ProyectoService } from 'src/app/service/projecto.service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css'],
})
export class NewproyectoComponent implements OnInit {
  nombrePro: string;
  descripcionPro: string;

  constructor(private proyectoS: ProyectoService, private router: Router) {}

  ngOnInit(): void {}

  onCreate(): void {
    const proyecto = new Proyecto(this.nombrePro, this.descripcionPro);
    this.proyectoS.save(proyecto).subscribe(
      (data) => {
        alert('Proyecto añadida correctamente');
        this.router.navigate(['']);
      },
      (err) => {
        alert('falló');
        this.router.navigate(['']);
      }
    );
  }
}

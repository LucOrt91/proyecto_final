import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/models/proyecto.model';
import { ProyectoService } from 'src/app/service/projecto.service';

@Component({
  selector: 'app-editproyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditproyectoComponent implements OnInit {
  proyecto: Proyecto = null;
  
  constructor(
    private proyectoS: ProyectoService,
    private activatedRouter : ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['idPro'];
    this.proyectoS.detail(id).subscribe(
      data =>{
        this.proyecto = data;
      }, err =>{
         alert("Error al modificar");
         this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['idPro'];
    this.proyectoS.update(id, this.proyecto).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar el proyecto");
        this.router.navigate(['']);
      }
    )
  }
}
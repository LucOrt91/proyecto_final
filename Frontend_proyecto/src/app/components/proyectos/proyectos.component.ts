import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Project } from 'src/app/models/Project';
import { ProjectService } from 'src/app/service/project.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css'],
})
export class ProyectosComponent implements OnInit {
  public projects: Project[] = [];
  public editProject: Project | undefined;
  public deleteProject: Project | undefined;

  constructor(private projectService: ProjectService) {}

  ngOnInit(): void {
    this.getProject();
  }
  public getProject(): void {
    this.projectService.getProject().subscribe({
      next: (Response: Project[]) => {
        this.projects = Response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
  public onOpenModal(mode: String, project?: Project): void {
    const cointainer = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addProjectModal');
    } else if (mode === 'delete') {
      this.deleteProject = project;
      button.setAttribute('data-target', '#deleteProjectModal');
    } else if (mode === 'edit') {
      this.editProject = project;
      button.setAttribute('data-target', '#editProjectModal');
    }
    cointainer?.appendChild(button);
    button.click();
  }

  public onAddProject(addForm: NgForm) {
    document.getElementById('add-project-form')?.click();
    this.projectService.addProject(addForm.value).subscribe({
      next: (response: Project) => {
        console.log(response);
        this.getProject();
        addForm.resetForm();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateProject(project: Project) {
    this.editProject = project;
    document.getElementById('add-project-form')?.click();
    this.projectService.addProject(project).subscribe({
      next: (response: Project) => {
        console.log(response);
        this.getProject();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
  public onDeleteProject(idPro: number): void {
    document.getElementById('add-project-form')?.click();
    this.projectService.deleteProject(idPro).subscribe({
      next: (response: void) => {
        console.log(response);
        this.getProject();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
}

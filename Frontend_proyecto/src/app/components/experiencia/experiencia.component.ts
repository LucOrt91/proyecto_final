import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Experience } from 'src/app/models/Experience';
import { ExperienceService } from 'src/app/service/experience.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css'],
})
export class ExperienciaComponent implements OnInit {
  public experiences: Experience[] = [];
  public editExperience: Experience | undefined;
  public deleteExperience: Experience | undefined;

  constructor(private experienceService: ExperienceService) {}

  ngOnInit(): void {
    this.getExperience();
  }
  public getExperience(): void {
    this.experienceService.getExperience().subscribe({
      next: (Response: Experience[]) => {
        this.experiences = Response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
  public onOpenModal(mode: String, experience?: Experience): void {
    const cointainer = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addExperienceModal');
    } else if (mode === 'delete') {
      this.deleteExperience = experience;
      button.setAttribute('data-target', '#deleteExperienceModal');
    } else if (mode === 'edit') {
      this.editExperience = experience;
      button.setAttribute('data-target', '#editExperienceModal');
    }
    cointainer?.appendChild(button);
    button.click();
  }

  public onAddExperience(addForm: NgForm) {
    document.getElementById('add-experience-form')?.click();
    this.experienceService.addExperience(addForm.value).subscribe({
      next: (response: Experience) => {
        console.log(response);
        this.getExperience();
        addForm.resetForm();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateExperience(experience: Experience) {
    this.editExperience = experience;
    document.getElementById('add-experience-form')?.click();
    this.experienceService.addExperience(experience).subscribe({
      next: (response: Experience) => {
        console.log(response);
        this.getExperience();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
  public onDeleteExperience(idExp: number): void {
    document.getElementById('add-experience-form')?.click();
    this.experienceService.deleteExperience(idExp).subscribe({
      next: (response: void) => {
        console.log(response);
        this.getExperience();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
}

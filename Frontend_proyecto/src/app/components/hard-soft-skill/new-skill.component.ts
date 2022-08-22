import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/models/skill.model';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css'],
})
export class NewSkillComponent implements OnInit {
  nombreSkill: string;
  imgSkill: string;
  nivelSkill: number;

  constructor(private skillS: SkillService, private router: Router) {}

  ngOnInit(): void {}

  onCreate(): void {
    const skill = new Skill(this.imgSkill, this.nombreSkill, this.nivelSkill);
    this.skillS.save(skill).subscribe(
      (data) => {
        alert('Skill añadida correctamente');
        this.router.navigate(['']);
      },
      (err) => {
        alert('falló añadir Skill');
        this.router.navigate(['']);
      }
    );
  }
}

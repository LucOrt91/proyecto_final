import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/models/skill.model';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {
  nombreSkill: string = '';
  imagenSkill: string = '';
  nivelSkill: number;

  constructor(private sSkill: SkillService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const skill = new Skill(this.nombreSkill, this.imagenSkill, this.nivelSkill);
    this.sSkill.save(skill).subscribe(
      data => {
        alert("Skill añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }

}

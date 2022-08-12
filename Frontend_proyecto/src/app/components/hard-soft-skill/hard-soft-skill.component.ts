import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/models/skill.model';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';
@Component({
  selector: 'app-hard-soft-skill',
  templateUrl: './hard-soft-skill.component.html',
  styleUrls: ['./hard-soft-skill.component.css'],
})
export class HardSoftSkillComponent implements OnInit {
  skill: Skill[] = [];
  nivelSkill: Skill['nivelSkill']

  constructor(
    private sSkill: SkillService,
    private tokenService: TokenService
  ) {}

  isLogged = false;

  ngOnInit(): void {
    this.cargarSkill();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkill(): void {
    this.sSkill.lista().subscribe((data) => {
      this.skill = data;
    });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sSkill.delete(id).subscribe(
        (data) => {
          this.cargarSkill();
        },
        (err) => {
          alert('No se pudo borrar la Skill');
        }
      );
    }
  }
}

export class Skill {
  idSkill: number;
  nombreSkill: string;
  imagenSkill: string;
  nivelSkill: number;

  constructor(nombreSkill: string, imagenSkill: string, nivelSkill: number) {
    this.nombreSkill = nombreSkill;
    this.imagenSkill = imagenSkill;
    this.nivelSkill = nivelSkill;
  }
}

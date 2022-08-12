export class Skill {
  idSkill?: number;
  nombreSkill: string;
  imgSkill: string;
  nivelSkill: number;

  constructor(nombreSkill: string, imgSkill: string, nivelSkill: number) {
    this.nombreSkill = nombreSkill;
    this.imgSkill = imgSkill;
    this.nivelSkill = nivelSkill;
  }
}

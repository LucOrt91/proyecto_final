export class Proyecto{
  idPro?: number;
  nombrePro: string;
  descripcionPro: string;

  constructor(nombrePro: string, descripcionPro: string){
      this.nombrePro = nombrePro;
      this.descripcionPro = descripcionPro;
  }
}
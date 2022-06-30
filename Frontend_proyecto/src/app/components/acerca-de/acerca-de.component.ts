import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Info } from 'src/app/models/Info';
import { HeaderService } from 'src/app/service/header.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css'],
})
export class AcercaDeComponent implements OnInit {
  public info: Info | undefined;
  public editInfo: Info | undefined;

  constructor(private headerService: HeaderService) {}

  ngOnInit(): void {
    this.getInfo();
  }
  public getInfo(): void {
    this.headerService.getUser().subscribe({
      next: (response: Info) => {
        this.info = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
}

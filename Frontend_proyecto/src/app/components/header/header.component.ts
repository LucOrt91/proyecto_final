import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Info } from 'src/app/models/Info';
import { HeaderService } from 'src/app/service/header.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  public info: Info | undefined;
  public editInfo: Info | undefined;

  constructor(private headerService: HeaderService) {}

  ngOnInit(): void {
    this.getInfo();
  }
  public getInfo(): void {
    this.headerService.getInfo().subscribe({
      next: (response: Info) => {
        this.info = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
}

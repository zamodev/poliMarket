import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { MatToolbar } from '@angular/material/toolbar';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatToolbar ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
}

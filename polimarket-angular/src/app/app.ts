import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink, Router, NavigationEnd } from '@angular/router';
import { MatToolbar } from '@angular/material/toolbar';
import { filter } from 'rxjs';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatToolbar ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
    titulo = 'Bienvenido a PoliMarket';

  constructor(private router: Router) {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe(() => {
        const currentRoute = this.router.routerState.snapshot.root.firstChild;
        if (currentRoute?.title) {
          this.titulo = currentRoute.title;
        } else {
          this.titulo = 'Bienvenido a PoliMarket';
        }
      });
  }
}

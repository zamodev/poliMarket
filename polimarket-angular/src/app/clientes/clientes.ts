import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-clientes',
  imports: [MatButtonModule, MatTableModule],
  templateUrl: './clientes.html',
  styleUrl: './clientes.css',
})
export class Clientes {
  displayedColumns: string[] = ['id', 'nombre', 'email'];
  clientes: any[] = [];

  constructor(private http: HttpClient) {
  }
    listarClientes() {
    this.http.get<any[]>('http://localhost:8080/polimarket/v1/ventas/clientes')
      .subscribe({
        next: (data) => this.clientes = data,
        error: (err) => console.error('Error al llamar la API', err)
      });
  }
}

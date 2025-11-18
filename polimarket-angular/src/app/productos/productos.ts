import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
@Component({
  selector: 'app-productos',
  imports: [MatButtonModule, MatTableModule],
  templateUrl: './productos.html',
  styleUrl: './productos.css',
})
export class Productos {
  displayedColumns: string[] = ['idProducto', 'nombreProducto', 'precio', 'cantidadDisponible'];
  productos: any[] = [];

    constructor(private http: HttpClient) {
  }
      listarClientes() {
    this.http.get<any[]>('http://localhost:8080/polimarket/v1/bodega/items-disponibles')
      .subscribe({
        next: (data) => this.productos = data,
        error: (err) => console.error('Error al llamar la API', err)
      });
  }

}

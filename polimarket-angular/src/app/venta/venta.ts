import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-venta',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatIconModule,
  ],
  templateUrl: './venta.html',
  styleUrl: './venta.css',
})
export class Venta {
  ventaForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.ventaForm = this.fb.group({
      cliente: this.fb.group({
        nombre: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
      }),
      itemsVenta: this.fb.array([
        this.crearItem()   // arrancamos con 1 fila por defecto
      ]),
    });
  }

  // ---------- getters ----------
  get itemsVenta(): FormArray {
    return this.ventaForm.get('itemsVenta') as FormArray;
  }

  // ---------- helpers ----------
  private crearItem(): FormGroup {
    return this.fb.group({
      idProducto: [null, Validators.required],
      cantidad: [null, [Validators.required]],
    });
  }

  agregarItem() {
    this.itemsVenta.push(this.crearItem());
  }

  eliminarItem(index: number) {
    this.itemsVenta.removeAt(index);
  }

  guardar() {
    if (this.ventaForm.invalid) {
      this.ventaForm.markAllAsTouched();
      return;
    }

    // 👇 ESTE valor ya tiene la misma estructura que tu endpoint
    const venta = this.ventaForm.value;

    this.http.post(
      'http://localhost:8080/polimarket/v1/ventas/registrar-venta',
      venta
    ).subscribe({
      next: (resp) => {
        console.log('Venta guardada en el backend:', resp);
        this.ventaForm.reset();
        this.itemsVenta.clear();
        this.agregarItem(); // dejamos un item vacío nuevamente
      },
      error: (err) => {
        console.error('Error al guardar la venta:', err);
      }
    });
  }
}

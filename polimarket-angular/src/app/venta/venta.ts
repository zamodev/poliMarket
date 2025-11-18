import { HttpClient } from '@angular/common/http';
import { Component, TemplateRef, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-venta',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatIconModule,
    MatDialogModule, 
  ],
  templateUrl: './venta.html',
  styleUrl: './venta.css',
})
export class Venta {
  ventaForm: FormGroup;

  @ViewChild('detalleVenta') detalleVentaTpl!: TemplateRef<any>;

  constructor(private fb: FormBuilder, private http: HttpClient, private dialog: MatDialog) {
    this.ventaForm = this.fb.group({
      cliente: this.fb.group({
        nombre: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
      }),
      itemsVenta: this.fb.array([
        this.crearItem()
      ]),
    });
  }

  get itemsVenta(): FormArray {
    return this.ventaForm.get('itemsVenta') as FormArray;
  }

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

    const venta = this.ventaForm.value;

    this.http.post<any>(
      'http://localhost:8080/polimarket/v1/ventas/registrar-venta',
      venta
    ).subscribe({
      next: (resp) => {
        this.dialog.open(this.detalleVentaTpl, {
          data: resp,
          width: '600px',
        });
        this.ventaForm.reset();
        this.itemsVenta.clear();
        this.agregarItem();
      },
      error: (err) => {
        console.error('Error al guardar la venta:', err);
      }
    });
  }
}

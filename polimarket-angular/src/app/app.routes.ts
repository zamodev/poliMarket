import { Routes } from '@angular/router';
import { Clientes } from './clientes/clientes';
import { Productos } from './productos/productos';
import { Venta } from './venta/venta';
import { Inicio } from './inicio/inicio';


export const routes: Routes = [
    {path: "", component: Inicio },
    {path: "clientes", component: Clientes },
    {path: "productos", component: Productos },
    {path: "venta", component: Venta},
];

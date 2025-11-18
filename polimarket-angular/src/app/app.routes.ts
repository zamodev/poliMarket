import { Routes } from '@angular/router';
import { Clientes } from './clientes/clientes';
import { Productos } from './productos/productos';
import { Venta } from './venta/venta';
import { Inicio } from './inicio/inicio';


export const routes: Routes = [
    {path: "", component: Inicio, title: "Bienvenido a Polimarket" },
    {path: "clientes", component: Clientes, title: "Consulta de Clientes Potenciales" },
    {path: "productos", component: Productos, title:"Productos"   },
    {path: "venta", component: Venta, title: "Ventas"},
];

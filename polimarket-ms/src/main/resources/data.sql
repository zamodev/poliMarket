-- carga inicial de clientes
INSERT INTO CLIENTE (nombre, email, es_potencial)
VALUES ('Erick Saavedra', 'ericksaavedra6@gmail.com', TRUE),
       ('Manuel Diaz', 'mdiaz@algo.com', TRUE);

-- carga de productos iniciales
INSERT INTO PRODUCTO (nombre, precio, activo)
VALUES ('Agenda estudiantil', 10000, TRUE),
       ('Morral 15.6 pulgadas', 120000, TRUE),
       ('Teclado Mecanico', 150000, TRUE),
       ('Mouse ', 80000, TRUE),
       ('Audifonos gamer', 250000, TRUE),
       ('Mouse pad', 10000, TRUE);
-- carga de stock base para la demostracion
INSERT INTO STOCK (cantidad_disponible, id_producto)
VALUES (150, 1),
 (30, 2),
 (15, 3),
 (30, 4),
 (10, 5),
 (100, 6);

--Carga de tabla de proveedores
INSERT INTO PROVEEDOR (id_proveedor,nombre,nit,email)
VALUES (1,'Comercializadora La nueva sas','900250125-5','pedidos@comercializadoralanueva.com'),
       (2,'Importadores Electronicos sas','850471265-3','contactenos@importadoressas.co'),
    (3,'Super Retail El Fantasma','850472547-2','pedidos@retailfantasma.co');
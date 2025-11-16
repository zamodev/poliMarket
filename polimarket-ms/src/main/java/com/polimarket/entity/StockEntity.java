package com.polimarket.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STOCK")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;
    @OneToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;
}

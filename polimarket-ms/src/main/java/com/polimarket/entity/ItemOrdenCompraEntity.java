package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "ITEMORDENCOMPRA")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrdenCompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_orden")
    private Long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto")
    ProductoEntity producto;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_orden")
    OrdenCompraEntity ordenCompra;
}

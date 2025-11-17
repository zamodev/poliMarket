package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "DETALLE_VENTA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name= "total" )
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    VentasEntity ventasEntity;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    ProductoEntity productoEntity;
}

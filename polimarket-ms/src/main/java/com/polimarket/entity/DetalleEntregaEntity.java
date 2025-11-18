package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DETALLE_ENTREGA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleEntregaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_entrega")
    private EntregaEntity entrega;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    private Integer cantidad;
}
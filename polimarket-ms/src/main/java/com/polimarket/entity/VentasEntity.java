package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "VENTAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private int id;

    @Column(name ="total_venta")
    private BigDecimal totalVenta;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @OneToMany(mappedBy = "ventasEntity")
    List<DetalleVentaEntity> detalleVenta;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    ClienteEntity cliente;
}

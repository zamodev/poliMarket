package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDENCOMPRA")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdenCompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long id;
    @Column(name = "fecha")
    private LocalDateTime fecha;
    @OneToOne
    @JoinColumn(name = "id_proveedor")
    ProveedorEntity proveedor;
    @OneToMany(mappedBy = "ordenCompra")
    List<ItemOrdenCompraEntity> items;

}

package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Table(name = "PRODUCTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "producto")
    private List<ItemOrdenCompraEntity> itemsOrdenCompras;
}

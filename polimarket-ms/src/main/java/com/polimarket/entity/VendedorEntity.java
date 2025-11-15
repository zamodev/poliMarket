package com.polimarket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VENDEDOR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendedorEntity {
    @Id
    @Column(name = "id_vendedor")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="estado")
    private boolean estado;
}

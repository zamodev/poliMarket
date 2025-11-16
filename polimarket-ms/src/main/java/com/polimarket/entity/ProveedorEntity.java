package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PROVEEDOR")
public class ProveedorEntity {
    @Id
    @Column(name = "id_proveedor")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nit")
    private String nit;
    @Column(name = "email")
    private String email;

}

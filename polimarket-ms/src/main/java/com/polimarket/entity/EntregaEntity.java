package com.polimarket.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ENTREGA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long idEntrega;

    private Date fecha;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<DetalleEntregaEntity> detalles;
}
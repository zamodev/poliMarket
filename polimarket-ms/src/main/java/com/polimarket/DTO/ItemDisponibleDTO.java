package com.polimarket.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDisponibleDTO {

    private Long idProducto;
    private String nombreProducto;
    private BigDecimal precio;
    private Integer cantidadDisponible;

}
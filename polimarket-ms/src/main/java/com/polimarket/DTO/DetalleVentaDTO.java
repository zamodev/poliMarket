package com.polimarket.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {
    private Long idProducto;
    private String descripcion;
    private BigDecimal precioUnitario;
    private BigDecimal total;
    private int cantidad;
}

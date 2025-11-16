package com.polimarket.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleOrdenCompraDTO {
    private Long idProducto;
    private BigDecimal precioUnitario;
    private int cantidad;
}

package com.polimarket.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompraDTO {
    private int idProveedor;
    private List<DetalleOrdenCompraDTO> detalles;
    private BigDecimal total;
}

package com.polimarket.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VentaDTO {
    private int idVenta;
    private Cliente cliente;
    private List<DetalleVentaDTO> itemsVenta;
    private BigDecimal totalVenta;
    private LocalDateTime fechaVenta;
}

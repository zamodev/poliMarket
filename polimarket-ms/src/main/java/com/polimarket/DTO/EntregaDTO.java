package com.polimarket.DTO;

import lombok.Data;
import java.util.List;

@Data
public class EntregaDTO {
    private Long idCliente;
    private List<DetalleEntregaDTO> detalles;
}
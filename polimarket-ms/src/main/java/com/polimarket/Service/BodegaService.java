package com.polimarket.Service;

import com.polimarket.DTO.MensajeDTO;
import com.polimarket.DTO.OrdenCompraDTO;

public interface BodegaService {
    MensajeDTO registrarCompra(OrdenCompraDTO ordenCompraDTO);
}

package com.polimarket.Service;

import com.polimarket.DTO.ItemDisponibleDTO;
import com.polimarket.DTO.MensajeDTO;
import com.polimarket.DTO.OrdenCompraDTO;

import java.util.List;

public interface BodegaService {
    MensajeDTO registrarCompra(OrdenCompraDTO ordenCompraDTO);
    List<ItemDisponibleDTO> listarItemsDisponibles();
}

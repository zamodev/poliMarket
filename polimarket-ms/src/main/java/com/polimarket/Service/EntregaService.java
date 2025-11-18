package com.polimarket.Service;

import com.polimarket.DTO.EntregaDTO;
import com.polimarket.DTO.MensajeDTO;

public interface EntregaService {
    MensajeDTO gestionarEntrega(EntregaDTO entregaDTO);
}
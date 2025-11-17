package com.polimarket.Service;

import com.polimarket.DTO.Cliente;
import com.polimarket.DTO.VentaDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VentasService {
    List<Cliente> listarClientesPosibles();

    VentaDTO registrarVenta( VentaDTO ventaDTO);
}

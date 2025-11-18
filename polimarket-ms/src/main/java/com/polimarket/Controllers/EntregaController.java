package com.polimarket.Controllers;

import com.polimarket.DTO.EntregaDTO;
import com.polimarket.DTO.MensajeDTO;
import com.polimarket.Service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polimarket/v1/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/gestionar")
    public MensajeDTO gestionarEntrega(@RequestBody EntregaDTO entregaDTO) {
        return entregaService.gestionarEntrega(entregaDTO);
    }
}
package com.polimarket.Controllers;

import com.polimarket.DTO.OrdenCompraDTO;
import com.polimarket.Service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polimarket/v1/bodega")
public class BodegaController {

    @Autowired
    private BodegaService bodegaService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarCompra(@RequestBody OrdenCompraDTO ordenCompraDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.registrarCompra(ordenCompraDTO));
    }
}

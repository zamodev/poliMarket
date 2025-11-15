package com.polimarket.Controllers;

import com.polimarket.Service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polimarket/v1/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping("/clientes")
    public ResponseEntity<?> findPosibles() {
        return ResponseEntity.status(HttpStatus.OK).body(ventasService.listarClientesPosibles());
    }
}

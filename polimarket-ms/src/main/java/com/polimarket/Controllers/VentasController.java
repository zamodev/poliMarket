package com.polimarket.Controllers;

import com.polimarket.DTO.DetalleVentaDTO;
import com.polimarket.DTO.VentaDTO;
import com.polimarket.Service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polimarket/v1/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping("/clientes")
    public ResponseEntity<?> findPosibles() {
        return ResponseEntity.status(HttpStatus.OK).body(ventasService.listarClientesPosibles());
    }

    @PostMapping("/registrar-venta")
    public ResponseEntity<?> registrarVenta(@RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventasService.registrarVenta(ventaDTO));
    }
}

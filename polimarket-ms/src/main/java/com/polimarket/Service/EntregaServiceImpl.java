package com.polimarket.Service;

import com.polimarket.DTO.DetalleEntregaDTO;
import com.polimarket.DTO.EntregaDTO;
import com.polimarket.DTO.MensajeDTO;
import com.polimarket.Repository.ClienteRepository;
import com.polimarket.Repository.ProductoRepository;
import com.polimarket.Repository.EntregaRepository;
import com.polimarket.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntregaServiceImpl implements EntregaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    @Override
    public MensajeDTO gestionarEntrega(EntregaDTO entregaDTO) {

        MensajeDTO mensaje = new MensajeDTO();

        try {
            ClienteEntity cliente = clienteRepository.findById(entregaDTO.getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

            EntregaEntity entrega = new EntregaEntity();
            entrega.setFecha(new Date());
            entrega.setEstado("PENDIENTE");
            entrega.setCliente(cliente);

            List<DetalleEntregaEntity> detalles = new ArrayList<>();

            for (DetalleEntregaDTO d : entregaDTO.getDetalles()) {
                ProductoEntity producto = productoRepository.findById(d.getIdProducto())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

                DetalleEntregaEntity det = new DetalleEntregaEntity();
                det.setProducto(producto);
                det.setCantidad(d.getCantidad());
                det.setEntrega(entrega);

                detalles.add(det);
            }

            entrega.setDetalles(detalles);
            entregaRepository.save(entrega);

            mensaje.setMensaje("Entrega registrada con ID " + entrega.getIdEntrega());

        } catch (Exception e) {
            mensaje.setMensaje("Error gestionando la entrega: " + e.getMessage());
        }

        return mensaje;
    }
}
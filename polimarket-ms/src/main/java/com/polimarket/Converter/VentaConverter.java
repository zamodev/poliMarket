package com.polimarket.Converter;

import com.polimarket.DTO.DetalleVentaDTO;
import com.polimarket.DTO.VentaDTO;
import com.polimarket.entity.DetalleVentaEntity;
import com.polimarket.entity.VentasEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VentaConverter {

    public static VentasEntity ventaDTOtoEntity(VentaDTO ventaDTO) {
        return VentasEntity.builder()
                .fechaVenta(LocalDateTime.now())
                .build();
    }

    public static VentaDTO ventaEntitytoVentaDTO(VentasEntity ventaEntity) {
        return VentaDTO.builder()
                .cliente(ClienteConverter.ClienteConverterEntityTODTO(ventaEntity.getCliente()))
                .totalVenta(ventaEntity.getTotalVenta())
                .idVenta(ventaEntity.getId())
                .fechaVenta(ventaEntity.getFechaVenta())
                .build();
    }

    public static DetalleVentaDTO detalleVentaEntityToDTO(DetalleVentaEntity detalleVenta) {


        return DetalleVentaDTO.builder()
                .idProducto(detalleVenta.getProductoEntity().getId())
                .cantidad(detalleVenta.getCantidad())
                .precioUnitario(detalleVenta.getProductoEntity().getPrecio())
                .descripcion(detalleVenta.getProductoEntity().getNombre())
                .total(detalleVenta.getTotal())
                .build();

    }

    public static DetalleVentaEntity detalleVentaDTOtoEntity(DetalleVentaDTO detalleVentaDTO) {
        return DetalleVentaEntity.builder()
                .cantidad(detalleVentaDTO.getCantidad())
                .build();
    }


}

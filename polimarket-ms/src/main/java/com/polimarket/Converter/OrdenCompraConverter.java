package com.polimarket.Converter;

import com.polimarket.DTO.DetalleOrdenCompraDTO;
import com.polimarket.DTO.OrdenCompraDTO;
import com.polimarket.entity.ItemOrdenCompraEntity;
import com.polimarket.entity.OrdenCompraEntity;
import com.polimarket.entity.ProductoEntity;
import com.polimarket.entity.ProveedorEntity;

import java.time.LocalDateTime;
import java.util.List;

public class OrdenCompraConverter {

    public static OrdenCompraEntity converterDTOToEntity(OrdenCompraDTO ordenCompraDTO, ProveedorEntity proveedor){
        return OrdenCompraEntity.builder()
                .fecha(LocalDateTime.now())
                .proveedor(proveedor)
                .build();
    }

    public static ItemOrdenCompraEntity convertItemsDTOToEntity(DetalleOrdenCompraDTO item, OrdenCompraEntity ordenCompra, ProductoEntity producto){
        return ItemOrdenCompraEntity.builder()
                .cantidad(item.getCantidad())
                .precioUnitario(item.getPrecioUnitario())
                .ordenCompra(ordenCompra)
                .producto(producto)
                .build();
    }
}

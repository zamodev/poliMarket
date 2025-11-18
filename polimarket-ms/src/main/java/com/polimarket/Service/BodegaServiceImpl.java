package com.polimarket.Service;

import com.polimarket.Converter.OrdenCompraConverter;
import com.polimarket.DTO.DetalleOrdenCompraDTO;
import com.polimarket.DTO.ItemDisponibleDTO;
import com.polimarket.DTO.MensajeDTO;
import com.polimarket.DTO.OrdenCompraDTO;
import com.polimarket.Repository.*;
import com.polimarket.entity.ItemOrdenCompraEntity;
import com.polimarket.entity.OrdenCompraEntity;
import com.polimarket.entity.ProductoEntity;
import com.polimarket.entity.ProveedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BodegaServiceImpl implements BodegaService{

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
    @Autowired
    private ItemOrdenCompraRepository itemOrdenCompraRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public MensajeDTO registrarCompra(OrdenCompraDTO ordenCompraDTO) {
        MensajeDTO mensajeDTO = new MensajeDTO();
        try {
            Optional<ProveedorEntity> proveedor=proveedorRepository.findById(ordenCompraDTO.getIdProveedor());
            if(proveedor.isPresent()){
                OrdenCompraEntity ordenCompra= OrdenCompraConverter.converterDTOToEntity(ordenCompraDTO,proveedor.get());
                ordenCompra=ordenCompraRepository.save(ordenCompra);
                for(DetalleOrdenCompraDTO i:ordenCompraDTO.getDetalles())
                {
                    ProductoEntity producto=productoRepository.findById(i.getIdProducto()).get();
                    ItemOrdenCompraEntity item=OrdenCompraConverter.convertItemsDTOToEntity(i,ordenCompra,producto);
                    item=itemOrdenCompraRepository.save(item);
                }
                mensajeDTO.setMensaje("Orden de compra registrada con el id "+ordenCompra.getId());

            }
            else
            {
                mensajeDTO.setMensaje("el proveedor indicado no existe");
            }

        }catch (Exception e){
            mensajeDTO.setMensaje("se encontro un error al registrar la orden de compra "+e.getMessage());
        }
        finally {
            return mensajeDTO;
        }
    }

    @Override
    public List<ItemDisponibleDTO> listarItemsDisponibles() {
        return stockRepository.findItemsDisponibles()
                .stream()
                .map(s -> ItemDisponibleDTO.builder()
                        .idProducto(s.getProducto().getIdProducto())        // ✔ ya existe
                        .nombreProducto(s.getProducto().getNombre())        // ✔ ok
                        .precio(s.getProducto().getPrecio())                // ✔ ok
                        .cantidadDisponible(s.getCantidadDisponible())      // ✔ ok
                        .build()
                )
                .collect(Collectors.toList());
    }
}

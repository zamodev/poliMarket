package com.polimarket.Service;

import com.polimarket.Converter.ClienteConverter;
import com.polimarket.Converter.VentaConverter;
import com.polimarket.DTO.Cliente;
import com.polimarket.DTO.DetalleVentaDTO;
import com.polimarket.DTO.VentaDTO;
import com.polimarket.Repository.ClienteRepository;
import com.polimarket.Repository.DetalleVentasRepository;
import com.polimarket.Repository.ProductoRepository;
import com.polimarket.Repository.StockRepository;
import com.polimarket.Repository.VentasRepository;
import com.polimarket.entity.ClienteEntity;
import com.polimarket.entity.DetalleVentaEntity;
import com.polimarket.entity.ProductoEntity;
import com.polimarket.entity.StockEntity;
import com.polimarket.entity.VentasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VentaServiceImpl implements VentasService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VentasRepository ventasRepository;

    @Autowired
    DetalleVentasRepository detalleVentasRepository;


    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Cliente> listarClientesPosibles() {
        return ClienteConverter.ClienteConverterListEntityTODTO(clienteRepository.findPosibles());
    }

    @Override
    public VentaDTO registrarVenta(VentaDTO ventaDTO) {
        //Validar Cliente y/o crear cliente
        ClienteEntity clienteCompra;

        if (ventaDTO.getCliente().getId() != null) {
            Optional<ClienteEntity> cliente = clienteRepository.findById(ventaDTO.getCliente().getId());
            clienteCompra = cliente.get();
        } else {
            clienteCompra = clienteRepository.save(ClienteConverter.ClienteConverterTOEntity(ventaDTO.getCliente()));
        }
        //Registrar Venta
        VentasEntity ordenVenta = ventasRepository.save(VentaConverter.ventaDTOtoEntity(ventaDTO));
        //registrar detalle
        BigDecimal totalVenta = BigDecimal.valueOf(0);
        List<DetalleVentaDTO> detalles = new ArrayList<>();

        for (DetalleVentaDTO item : ventaDTO.getItemsVenta()) {
            Optional<ProductoEntity> productoOpt = productoRepository.findById(item.getIdProducto());

            if (productoOpt.isPresent()) {
                ProductoEntity productoEntity = productoOpt.get();

                Optional<StockEntity> stockOpt = stockRepository.findByProducto(productoEntity);
                if (stockOpt.isPresent()) {
                    StockEntity stock = stockOpt.get();

                    int cantidadActual = stock.getCantidadDisponible();
                    int nuevaCantidad = cantidadActual - item.getCantidad();
                    stock.setCantidadDisponible(nuevaCantidad);
                    stockRepository.save(stock);
                }
                DetalleVentaEntity itemDB = new DetalleVentaEntity();
                itemDB.setProductoEntity(productoEntity);
                itemDB.setVentasEntity(ordenVenta);
                itemDB.setCantidad(item.getCantidad());
                itemDB.setTotal(
                        productoEntity.getPrecio().multiply(
                                BigDecimal.valueOf(item.getCantidad())
                        )
                );
                itemDB = detalleVentasRepository.save(itemDB);

                totalVenta = totalVenta.add(itemDB.getTotal());
                detalles.add(VentaConverter.detalleVentaEntityToDTO(itemDB));
            }
        }
        //actualizar total venta
        ordenVenta.setTotalVenta(totalVenta);
        ordenVenta.setCliente(clienteCompra);
        ventasRepository.save(ordenVenta);
        VentaDTO ventaRegistrada = VentaConverter.ventaEntitytoVentaDTO(ordenVenta);
        ventaRegistrada.setItemsVenta(detalles);
        //convertir venta a dto y retornar
        return ventaRegistrada;
    }
}

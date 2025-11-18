package com.polimarket.Repository;

import com.polimarket.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    @Query("SELECT s FROM StockEntity s " +
            "JOIN s.producto p " +
            "WHERE p.activo = TRUE " +
            "AND s.cantidadDisponible > 0")
    List<StockEntity> findItemsDisponibles();
}
package com.polimarket.Repository;

import com.polimarket.entity.ItemOrdenCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrdenCompraRepository extends JpaRepository<ItemOrdenCompraEntity,Long> {
}

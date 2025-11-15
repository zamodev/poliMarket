package com.polimarket.Repository;

import com.polimarket.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
    @Query("SELECT a FROM ClienteEntity a WHERE a.esPotencial=true")
    List<ClienteEntity> findPosibles();
}


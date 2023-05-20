package com.bank.bankink.repository;

import com.bank.bankink.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    Tarjeta findByProductId(Long productId);
}

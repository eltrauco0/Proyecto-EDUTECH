package com.example.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edutech.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}



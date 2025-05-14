package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}

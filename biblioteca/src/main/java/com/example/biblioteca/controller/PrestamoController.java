package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.Prestamo;
import com.example.biblioteca.services.PrestamoService;


@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listar() {
        List<Prestamo> prestamos = prestamoService.findAll();
        if (prestamos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prestamos);
    }

    @PostMapping
    public ResponseEntity<Prestamo> guardar(@RequestBody Prestamo prestamo) {
        Prestamo pres = prestamoService.save(prestamo, prestamo.getUsuario().getId(), prestamo.getLibro().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(pres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> buscar(@PathVariable Long id) {
        try {
            Prestamo prestamo = prestamoService.findById(id);
            return ResponseEntity.ok(prestamo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizar(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        try {
            Prestamo pre = prestamoService.findById(id);
            pre.setFechaPrestamo(prestamo.getFechaPrestamo());
            prestamoService.save(pre, pre.getUsuario().getId(), pre.getLibro().getId());
            return ResponseEntity.ok(pre);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            prestamoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

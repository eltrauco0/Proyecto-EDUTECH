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

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.services.LibroService;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listar() {
        List<Libro> libros = libroService.findAll();
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
            // alternativa 2 -> return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(libros);
        // alternativa 2 -> return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Libro> guardar(@RequestBody Libro libro) {
        Libro productoNuevo = libroService.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    // return new ResponseEntity<>(productoNuevo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable Long id) {
        try {
            Libro libro = libroService.findById(id);
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        try {
            Libro lib = libroService.findById(id);
            lib.setId(id);
            lib.setNombreLibro(libro.getNombreLibro());
            lib.setAutor(libro.getAutor());
            lib.setGenero(libro.getGenero());
            lib.setAñoSalida(libro.getAñoSalida());
            lib.setPrecio(libro.getPrecio());
            libroService.save(lib);
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            libroService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

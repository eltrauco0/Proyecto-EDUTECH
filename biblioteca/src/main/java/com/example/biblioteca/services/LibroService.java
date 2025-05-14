package com.example.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Libro findById(Long id) { 
        return libroRepository.findById(id).get();
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}

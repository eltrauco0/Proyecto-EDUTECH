package com.example.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.model.Prestamo;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.repository.PrestamoRepository;
import com.example.biblioteca.repository.UsuarioRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Prestamo findById(Long id) {
        return prestamoRepository.findById(id).get();
    }

    public Prestamo save(Prestamo prestamo, Long usuarioId, Long libroId) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
    Libro libro = libroRepository.findById(libroId).orElseThrow();
    prestamo.setUsuario(usuario);
    prestamo.setLibro(libro);
    return prestamoRepository.save(prestamo);
}
    public void delete(Long id) {
        prestamoRepository.deleteById(id);
    }
}

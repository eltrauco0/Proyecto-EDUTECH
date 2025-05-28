package com.example.edutech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edutech.model.Curso;
import com.example.edutech.model.Pago;
import com.example.edutech.model.Usuario;
import com.example.edutech.repository.CursoRepository;
import com.example.edutech.repository.PagoRepository;
import com.example.edutech.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Pago findById(Long id) {
        return pagoRepository.findById(id).get();
    }

    public Pago save(Pago pago, Long usuarioId, Long cursoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        pago.setUsuario(usuario);
        pago.setCurso(curso);
        return pagoRepository.save(pago);
    }

    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
}


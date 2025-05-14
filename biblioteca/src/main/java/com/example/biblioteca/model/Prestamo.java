package com.example.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "prestamos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(nullable=false, name="usuario_id", referencedColumnName="id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(nullable=false, name="libro_id", referencedColumnName="id")
    private Libro libro;
    
    @Column(nullable=false)
    private String fechaPrestamo;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return this.libro;
    } 
}



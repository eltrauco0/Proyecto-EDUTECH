package com.example.biblioteca.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 30,nullable = false)
    private String nombreLibro;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Integer añoSalida;

    @Column(nullable = true)
    private Integer precio;
}



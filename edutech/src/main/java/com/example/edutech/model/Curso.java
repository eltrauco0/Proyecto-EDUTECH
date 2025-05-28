package com.example.edutech.model;

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
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30, nullable = false)
    private String nombreCurso;

    @Column(nullable = false)
    private String profesion;

    @Column(nullable = false)
    private String descripcionCurso;

    @Column(nullable = false)
    private Integer mesesDuracion;

    @Column(nullable = true)
    private Integer precio;
}




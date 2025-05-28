package com.example.edutech.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 12,nullable = false)
    private String rut;

    @Column(nullable = false)
    private String nombreUsuario;

    @Column(nullable = false)
    private String apPaterno;

    @Column(nullable = false)
    private String apMaterno;

    @Column(nullable = true)
    private String correo;

    @Column(nullable = true)
    private String telefono;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaNacimiento;
}
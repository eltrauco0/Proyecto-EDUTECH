package com.example.edutech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.edutech.model.Usuario;
import com.example.edutech.services.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginPage() {
        return "forward:/frontend/login.html";
    }

    @PostMapping("/api/v1/login")
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseEntity<String> login(@RequestBody Usuario loginRequest) {
        String username = loginRequest.getNombreUsuario();
        String password = loginRequest.getContraseña();

        // Verificar si el usuario existe
        Usuario user = usuarioService.findByNombreUsuario(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        // Verificar la contraseña
        if (!user.getContraseña().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        // Aquí podrías generar un token de sesión o JWT si es necesario
        return ResponseEntity.ok("Inicio de sesión exitoso");
    }
}


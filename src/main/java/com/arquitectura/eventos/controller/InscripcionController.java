package com.arquitectura.eventos.controller;


import com.arquitectura.eventos.service.InscripcionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public boolean registrar(@RequestParam String nombre) {
        return service.registrar(nombre);
    }

    @DeleteMapping("/cancelar")
    public boolean cancelar(@RequestParam String nombre) {
        return service.cancelar(nombre);
    }

    @GetMapping("/cupos")
    public int consultarCupos() {
        return service.consultarCupos();
    }

    @GetMapping("/listar")
    public List<String> listar() {
        return service.listar();
    }
}
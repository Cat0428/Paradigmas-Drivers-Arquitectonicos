package com.arquitectura.eventos.service;

import java.util.List;

public interface InscripcionService {
    boolean registrar(String nombre);
    boolean cancelar(String nombre);
    int consultarCupos();
    List<String> listar();
}

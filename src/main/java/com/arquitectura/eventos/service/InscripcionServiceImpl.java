package com.arquitectura.eventos.service;

import com.arquitectura.eventos.model.Participante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    private final ConcurrentHashMap<String, Participante> inscritos =
            new ConcurrentHashMap<>();

    private final int cupoMaximo = 5;

    @Override
    public synchronized boolean registrar(String nombre) {

        if (inscritos.size() >= cupoMaximo) {
            return false;
        }

        if (inscritos.containsKey(nombre)) {
            return false;
        }

        inscritos.put(nombre, new Participante(nombre));
        return true;
    }

    @Override
    public synchronized boolean cancelar(String nombre) {
        return inscritos.remove(nombre) != null;
    }

    @Override
    public int consultarCupos() {
        return cupoMaximo - inscritos.size();
    }

    @Override
    public List<String> listar() {
        return inscritos.values()
                .stream()
                .map(Participante::getNombre)
                .toList();
    }
}
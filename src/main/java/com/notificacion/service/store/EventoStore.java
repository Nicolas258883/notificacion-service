package com.notificacion.service.store;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.notificacion.service.eventos.CarroCreadoEvento;

@Service
public class EventoStore {

    // Lista en memoria donde guardaremos los eventos recibidos desde Kafka.
    private final List<CarroCreadoEvento> eventos =
            new CopyOnWriteArrayList<>();

    // Guarda un evento recibido.
    public void guardar(CarroCreadoEvento evento) {
        eventos.add(evento);
    }

    // Devuelve todos los eventos recibidos hasta el momento.
    public List<CarroCreadoEvento> obtenerTodos() {
        return eventos;
    }
}

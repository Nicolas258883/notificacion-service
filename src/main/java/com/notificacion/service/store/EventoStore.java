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

 // Guarda temporalmente en memoria los eventos recibidos desde Kafka.
 // Lo utilizamos solo para el laboratorio, para poder consultar después
 // qué mensajes ha consumido notificacion-service mediante GET /eventos.
 // En un proyecto real, aquí podríamos guardar la información en BD,
 // enviar un correo, actualizar otro sistema, etc.
 // Al estar en memoria, estos datos se pierden al reiniciar la aplicación
    public void guardar(CarroCreadoEvento evento) {
        eventos.add(evento);
    }

    // Devuelve todos los eventos recibidos hasta el momento.
    public List<CarroCreadoEvento> obtenerTodos() {
        return eventos;
    }
}

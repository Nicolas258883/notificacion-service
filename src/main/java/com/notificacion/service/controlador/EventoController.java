package com.notificacion.service.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notificacion.service.eventos.CarroCreadoEvento;
import com.notificacion.service.store.EventoStore;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    // Almacen en memoria donde el Consumer va guardando los eventos recibidos desde Kafka.
    private final EventoStore eventoStore;

    // Spring inyecta EventoStore mediante el constructor.
    public EventoController(EventoStore eventoStore) {
        this.eventoStore = eventoStore;
    }

    // Endpoint:
    // GET /eventos
    //
    // Devuelve todos los eventos que notificacion-service
    // ha recibido desde Kafka y tiene guardados en memoria.
    @GetMapping
    public List<CarroCreadoEvento> obtenerEventos() {
        return eventoStore.obtenerTodos();
    }
}

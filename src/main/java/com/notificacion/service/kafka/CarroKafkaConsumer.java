package com.notificacion.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.notificacion.service.eventos.CarroCreadoEvento;
import com.notificacion.service.store.EventoStore;

@Service
public class CarroKafkaConsumer {

    // Almacén temporal en memoria donde guardaremos
    // los eventos recibidos desde Kafka.
    private final EventoStore eventoStore;

    // Spring inyecta EventoStore mediante el constructor.
    public CarroKafkaConsumer(EventoStore eventoStore) {
        this.eventoStore = eventoStore;
    }

    // Este método escucha el topic "carro-creado".
    // Cada vez que llega un mensaje, Spring lo convierte
    // a CarroCreadoEvento y ejecuta este método.
    @KafkaListener(
        topics = "carro-creado",
        groupId = "notificaciones-group"
    )
    public void recibirCarroCreado(CarroCreadoEvento evento) {

        // Mostramos por consola el evento recibido.
        System.out.println(
            "Mensaje recibido: "
            + evento.getMarca()
            + " "
            + evento.getModelo()
        );

        // Guardamos el evento en memoria.
        eventoStore.guardar(evento);
    }
}
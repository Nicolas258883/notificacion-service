package com.notificacion.service;

// SpringApplication es la clase que arranca la aplicación Spring Boot.
import org.springframework.boot.SpringApplication;

// @SpringBootApplication indica que esta es la clase principal
// de nuestra aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Esta anotación hace tres cosas principalmente:
// - Marca esta clase como configuración de Spring.
// - Activa la autoconfiguración de Spring Boot.
// - Hace que Spring busque componentes (@Service, @RestController, etc.)
//   dentro de este paquete y sus subpaquetes.
@SpringBootApplication
public class NotificacionServiceApplication {


    // Este es el método principal de Java.
    // Es el punto de entrada cuando arrancamos la aplicación.
    public static void main(String[] args) {


        // Arranca Spring Boot y crea el contexto de la aplicación.
        //
        // A partir de aquí Spring buscará y creará los beans:
        // - CarroKafkaConsumer
        // - EventoStore
        // - EventoController
        // - configuración de Kafka
        // - servidor web en el puerto 8004
        SpringApplication.run(NotificacionServiceApplication.class, args);
    }
}
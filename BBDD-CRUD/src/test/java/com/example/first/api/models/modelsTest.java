package com.example.first.api.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class modelsTest {

    @Test
    void has_id_type_message_size_and_color() {

        models model = new models(1, "Camiseta", "Hola", "XL", "Azul");

        int id = model.getId();
        String name = model.getProdType();
        String destination = model.getProdMessage();
        String details = model.getProdSize();
        String email = model.getProdColor();

        assertEquals(1L, id);
        assertEquals("Camiseta", name);
        assertEquals("Hola", destination);
        assertEquals("XL", details);
        assertEquals("Azul", email);
    }
}
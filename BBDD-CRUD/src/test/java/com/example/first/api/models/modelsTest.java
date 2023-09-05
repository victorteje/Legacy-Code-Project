package com.example.first.api.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class modelsTest {

    @Test
    void has_id_type_message_size_and_color() {

        models model = new models(1, "Camiseta", "Hola", "XL", "Azul");

        int id = model.getId();
        String prodType = model.getProdType();
        String prodMessage = model.getProdMessage();
        String prodSize = model.getProdSize();
        String prodColor = model.getProdColor();

        assertEquals(1L, id);
        assertEquals("Camiseta", prodType);
        assertEquals("Hola", prodMessage);
        assertEquals("XL", prodSize);
        assertEquals("Azul", prodColor);
    }
}
package com.example.first.api.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CProductTest {

    @Test
    void has_id_type_message_size_and_color() {

        CProduct model = new CProduct(1, "Camiseta", "Hola", "XL", "Azul");

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
package com.example.first.api.models;

import com.example.first.api.models.CProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CProductTest {

    @Test
    void has_id_type_message_size_and_color() {

        CProduct product = new CProduct(1, "Camiseta", "Hola", "XL", "Azul");

        int id = product.getId();
        String prodType = product.getProdType();
        String prodMessage = product.getProdMessage();
        String prodSize = product.getProdSize();
        String prodColor = product.getProdColor();

        assertEquals(1L, id);
        assertEquals("Camiseta", prodType);
        assertEquals("Hola", prodMessage);
        assertEquals("XL", prodSize);
        assertEquals("Azul", prodColor);
    }
}
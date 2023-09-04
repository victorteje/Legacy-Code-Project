package com.example.first.api.services;

import com.example.first.api.models.models;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.first.api.repositories.repositories;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class servicesTest {

    @InjectMocks
    services services;

    @Mock
    repositories repositories;

//    @Test
//    void getProducts() {
//        ArrayList<models> models = new ArrayList<>();
//        models models1 = new models((int) 1, "Camiseta", "Frase 1", "XL", "Roja");
////        models models2 = new models((int) 2, "Camiseta", "Frase 2", "M", "Azul");
//
//        models.add(models1);
////        models.add(models2);
//
//        when(repositories.findAll()).thenReturn(models);
//
//        ArrayList<com.example.first.api.models.models> getProducts = services.getProducts("Camiseta");
//
//        assertTrue(models.contains(models1));
//    }



    @Test
    void getOneProduct() {
        models models1 = new models((int) 1, "Camiseta", "Frase 1", "XL", "Roja");

        when(repositories.findById((int) 1)).thenReturn(Optional.of(models1));

        Optional<models> getOneProduct = repositories.findById(1);

        assertEquals("Frase 1", getOneProduct.get().getProdMessage());
    }
//
//    @Test
//    void deleteProduct() {
//    }
//
//    @Test
//    void setProduct() {
//    }
//
//    @Test
//    void changeProduct() {
//    }

}
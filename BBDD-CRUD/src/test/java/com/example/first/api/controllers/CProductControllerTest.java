package com.example.first.api.controllers;

import com.example.first.api.models.CProduct;
import com.example.first.api.services.CProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class CProductControllerTest {

    @InjectMocks
    private CProductController myController;

    @Mock

    private CProductService myService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
    }

    @Test
    public void testGetProducts() throws Exception {

        ArrayList<CProduct> expectedProducts = new ArrayList<>(Arrays.asList(
                new CProduct(1, "Camiseta", "Mensaje1", "L", "Blanco"),
                new CProduct(2, "Sudadera", "Mensaje2", "M", "Negro"),
                new CProduct(3,"Taza", "Mensaje3", null, "Azul" ),
                new CProduct(4, "Botella", "Mensaje4", null, "Negro")
        ));

        when(myService.getProductsByType(null)).thenReturn(expectedProducts);

        mockMvc.perform(MockMvcRequestBuilders.get("/product")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$[0].prodType").value("Camiseta"))
                .andExpect(jsonPath("$[0].prodMessage").value("Mensaje1"))
                .andExpect(jsonPath("$[0].prodSize").value("L"))
                .andExpect(jsonPath("$[0].prodColor").value("Blanco"))

                .andExpect(jsonPath("$[1].prodType").value("Sudadera"))
                .andExpect(jsonPath("$[1].prodMessage").value("Mensaje2"))
                .andExpect(jsonPath("$[1].prodSize").value("M"))
                .andExpect(jsonPath("$[1].prodColor").value("Negro"))

                .andExpect(jsonPath("$[2].prodType").value("Taza"))
                .andExpect(jsonPath("$[2].prodMessage").value("Mensaje3"))
                .andExpect(jsonPath("$[2].prodColor").value("Azul"))

                .andExpect(jsonPath("$[3].prodType").value("Botella"))
                .andExpect(jsonPath("$[3].prodMessage").value("Mensaje4"))
                .andExpect(jsonPath("$[3].prodColor").value("Negro"));
    }

    @Test
    public void testSetProduct() throws Exception {
        CProduct addProduct = new CProduct(1,"Camiseta", "Mensaje1", "L", "Blanco");

        when(myService.setProduct(any(CProduct.class))).thenReturn(addProduct);

        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"prodType\": \"Camiseta\", \"prodMessage\": \"Mensaje1\", \"prodSize\": \"L\", \"prodColor\": \"Blanco\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.prodType").value("Camiseta"))
                .andExpect(jsonPath("$.prodMessage").value("Mensaje1"))
                .andExpect(jsonPath("$.prodSize").value("L"))
                .andExpect(jsonPath("$.prodColor").value("Blanco"));
    }



    /*@Test
    void getProducts() {
    }

    @Test
    void setProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void changeProduct() {
    }*/
}
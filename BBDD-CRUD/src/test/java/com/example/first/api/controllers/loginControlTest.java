package com.example.first.api.controllers;

import com.example.first.api.controllers.loginControl;
import com.example.first.api.models.loginModel;
import com.example.first.api.services.loginServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;

class loginControlTest {

    @InjectMocks
    private loginControl loginController;

    @Mock
    private loginServices myService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }



    @Test
    void addFavs() throws Exception {
        // Configura el objeto de prueba
        loginModel testData = new loginModel();
        testData.setUsername("user123");
        testData.setPassword("pass123");

        // Configura el comportamiento del servicio mock
        when(myService.addFavs(any(loginModel.class))).thenReturn(true);

        // Realiza la solicitud MockMvc
        MockHttpServletResponse response = mockMvc.perform(
                post("/login/favs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user123\",\"password\":\"pass123\"}")
        ).andReturn().getResponse();

        // Verifica que la respuesta sea la esperada
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertTrue(Boolean.parseBoolean(response.getContentAsString())); // Verifica que la respuesta sea 'true'
    }
}

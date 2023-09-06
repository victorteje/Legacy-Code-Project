package com.example.first.api.controllers;

import com.example.first.api.models.CLogin;
import com.example.first.api.services.CLoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;

class CLoginControllerTest {

    @InjectMocks
    private CLoginController loginController;

    @Mock
    private CLoginService myService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    void addFavs() throws Exception {
        CLogin testData = new CLogin();
        testData.setUsername("user123");
        testData.setPassword("pass123");

        when(myService.addFavs(any(CLogin.class))).thenReturn(true);

        MockHttpServletResponse response = mockMvc.perform(
                post("/login/favs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user123\",\"password\":\"pass123\"}")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertTrue(Boolean.parseBoolean(response.getContentAsString()));
    }
}

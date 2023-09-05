package com.example.first.api.services;

import com.example.first.api.repositories.loginRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class loginServicesTest {
    @InjectMocks
    loginServices loginServices;

    @Mock
    loginRepository loginRepository;

    @Test
    void tryLogin() {
    }

    @Test
    void addNewUser() {
    }

    @Test
    void addFavs() {
    }
}
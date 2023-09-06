package com.example.first.api.services;

import com.example.first.api.repositories.ILoginRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CLoginServiceTest {
    @InjectMocks
    CLoginService CLoginService;

    @Mock
    ILoginRepository ILoginRepository;

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
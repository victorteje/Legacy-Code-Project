package com.example.first.api.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CLoginTest {

    @Test
    void introduced_email_has_an_email_structure() {
        CLogin CLogin = new CLogin("pepe@dominio.com", "Pepe", "password", "cliente", "favoritos");

        assertTrue(CLogin.getUserEmail().contains("@"));
    }

//    @Test
//    void getUserName() {
//    }
//
//    @Test
//    void getUserPassword() {
//    }
//
//    @Test
//    void getUserType() {
//    }
//
//    @Test
//    void getUserFavs() {
//    }
//
//    @Test
//    void setUserEmail() {
//    }
//
//    @Test
//    void setUserName() {
//    }
//
//    @Test
//    void setUserPassword() {
//    }
//
//    @Test
//    void setUserType() {
//    }
//
//    @Test
//    void setUserFavs() {
//    }
}
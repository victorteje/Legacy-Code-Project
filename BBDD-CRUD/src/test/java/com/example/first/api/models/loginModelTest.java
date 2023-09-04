package com.example.first.api.models;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class loginModelTest {

    @Test
    void introduced_email_has_an_email_structure() {
        loginModel loginModel = new loginModel("pepe@dominio.com", "Pepe", "password", "cliente", "favoritos");

        assertTrue(loginModel.getUserEmail().contains("@"));
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
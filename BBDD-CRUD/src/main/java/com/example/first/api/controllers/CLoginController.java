package com.example.first.api.controllers;

import com.example.first.api.models.CLogin;
import com.example.first.api.services.CLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class CLoginController {

    @Autowired
    private CLoginService myService;



    @PostMapping(path="/logo")
    public CLogin getUser(@RequestBody CLogin loginData){
        return myService.tryLogin(loginData);
    }

    @PostMapping(path="/favs")
    public boolean addFavs(@RequestBody CLogin userData){
        return myService.addFavs(userData);
}
}
package com.example.first.api.controllers;

import com.example.first.api.models.CProduct;
import com.example.first.api.services.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class controllers {

    @Autowired
    services myService;

    @GetMapping()
    public ArrayList<CProduct> getProducts(@RequestParam(required = false) String type){
        return myService.getProductsByType(type);
    }


    @PostMapping
    public CProduct setProduct(@RequestBody CProduct newProduct){
        return myService.setProduct(newProduct);
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return myService.deleteProduct(id);
    }

    @PutMapping(path="/update/{id}")
    public CProduct changeProduct(@RequestBody int id, @RequestBody CProduct newProduct){
        return myService.setProduct(myService.changeProduct(id, newProduct));
    }
}

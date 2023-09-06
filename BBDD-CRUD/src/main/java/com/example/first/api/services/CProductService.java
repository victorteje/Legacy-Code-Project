package com.example.first.api.services;

import com.example.first.api.models.CProduct;
import com.example.first.api.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CProductService {

    @Autowired
    IProductRepository myRepo;


    public ArrayList<CProduct> getProductsByType(String type) {
        if (type == null || type.isEmpty()) {
            return (ArrayList<CProduct>) myRepo.findAll();
        } else {
            return (ArrayList<CProduct>) myRepo.findByProdType(type);
        }
    }


    public CProduct getOneProduct(int id){
        try{
            return myRepo.findById(id).orElse(null);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String deleteProduct(int id) {
        try{
            myRepo.deleteById(id);
            return "Record "+id+" was successfully deleted.";
        }
        catch(Exception e){
            return "Unable to delete record: \n"+e.getMessage();
        }
    }

    public CProduct setProduct(CProduct newProduct) {
        try{
           return myRepo.save(newProduct);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public CProduct changeProduct(int id, CProduct newProduct) {
        try{
            CProduct toUpdateProduct= myRepo.findById(id).get();
            toUpdateProduct.setProdType(newProduct.getProdType());
            toUpdateProduct.setProdMessage(newProduct.getProdMessage());
            toUpdateProduct.setProdSize(newProduct.getProdSize());
            toUpdateProduct.setProdSize(newProduct.getProdSize());
            toUpdateProduct.setProdColor(newProduct.getProdColor());

            return toUpdateProduct;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

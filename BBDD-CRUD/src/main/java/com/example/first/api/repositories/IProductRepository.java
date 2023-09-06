package com.example.first.api.repositories;

import com.example.first.api.models.CProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<CProduct, Integer> {
    List<CProduct> findByProdType(String type);
}

package com.example.first.api.services;

import com.example.first.api.models.CProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.first.api.repositories.IProductRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CProductServiceTest {

    @InjectMocks
    CProductService CProductService;

    @Mock
    IProductRepository IProductRepository;

    @Test
    void test_should_get_product_by_type() {
        ArrayList<CProduct> CProduct = new ArrayList<>();
        CProduct CProduct1 = new CProduct((int) 1, "Camiseta", "Frase 1", "XL", "Roja");

        CProduct.add(CProduct1);

        when(IProductRepository.findByProdType(CProduct1.getProdType())).thenReturn(CProduct);

        ArrayList<CProduct> getProducts = CProductService.getProductsByType("Camiseta");

        assertTrue(CProduct.contains(CProduct1));
    }



    @Test
    void getOneProduct() {
        CProduct CProduct1 = new CProduct((int) 1, "Camiseta", "Frase 1", "XL", "Roja");

        when(IProductRepository.findById((int) 1)).thenReturn(Optional.of(CProduct1));

        CProduct getOneProduct = CProductService.getOneProduct(1);

        assertEquals("Frase 1", getOneProduct.getProdMessage());
    }
//
//    @Test
//    void deleteProduct() {
//    }
//
//    @Test
//    void setProduct() {
//    }
//
//    @Test
//    void changeProduct() {
//    }

}
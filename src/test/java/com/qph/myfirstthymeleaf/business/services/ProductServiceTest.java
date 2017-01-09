package com.qph.myfirstthymeleaf.business.services;

import com.qph.myfirstthymeleaf.business.entities.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by quoc on 09/01/2017.
 */
@RunWith(JUnit4.class)
public class ProductServiceTest {
    private ProductService productService = new ProductService();
    @Test
    public void findAll() throws Exception {
        List<Product> products = productService.findAll();
        Assert.assertNotNull(products);
        Assert.assertEquals(30, products.size());
    }

    @Test
    public void findById() throws Exception {
        String expectedName= "Fresh Sweet Basil";
        boolean expectedIsInStock = true;
        BigDecimal expectedPrice = new BigDecimal("4.99");
        Product product = productService.findById(1);
        Assert.assertNotNull(product);
        Assert.assertEquals(expectedName, product.getName());
        Assert.assertEquals(expectedIsInStock, product.isInStock());
        Assert.assertEquals(expectedPrice, product.getPrice());
    }

}
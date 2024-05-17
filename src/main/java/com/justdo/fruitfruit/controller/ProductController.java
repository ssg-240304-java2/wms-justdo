package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.service.ProductService;

import java.util.List;

public class ProductController {
    ProductService productService = new ProductService();
    public void selectAllProduct() {
        List<ProductDTO> productList = productService.selectAllProduct();
    }

    public void selectByCategory() { List<ProductDTO> productList = productService.selectByCategory(); }
}

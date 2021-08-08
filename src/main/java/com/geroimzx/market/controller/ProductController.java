/*
 * Copyright (c) 2021.
 */

package com.geroimzx.market.controller;

import com.geroimzx.market.model.Product;
import com.geroimzx.market.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ProductService productService;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/productList")
    public ResponseEntity<List<Product>> readProductListByType(@RequestParam(required = false) Optional<String> type) {
        if(type.isPresent()) {
            logger.info(type.get());
            logger.info("not null");
            return new ResponseEntity<>(productService.findByType(type.get()), HttpStatus.FOUND);
        }
        logger.info("null");
        return new ResponseEntity<>(productService.findAll(), HttpStatus.FOUND);
    }

    @PostMapping(value = "/product/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @PostMapping(value = "/product/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> editProduct(@PathVariable String id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.update(id, product), HttpStatus.ACCEPTED);
    }


    @GetMapping("/productList/test")
    public ResponseEntity<List<Product>> getProductListTest() {
        productService.create(new Product("Телевізор Xiaomi Mi TV UHD 4S 43 (L43M5-5ARU)", "9499", "TV"));
        productService.create(new Product("Телевізор JVC LT32MU380", "4899", "TV"));
        productService.create(new Product("Телевізор LG 43UP75006LF", "13699", "TV"));
        productService.create(new Product("Телевізор Samsung UE55TU7100UXUA", "17499", "TV"));

        return new ResponseEntity<>(productService.findByType("TV"), HttpStatus.FOUND);
    }
}
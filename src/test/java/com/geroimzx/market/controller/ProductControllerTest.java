package com.geroimzx.market.controller;

import com.geroimzx.market.model.Product;
import com.geroimzx.market.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductController.class, excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductController productController;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    MongoTemplate mongoTemplate;

    Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);

    @BeforeTestExecution
    public void init() {
        productRepository.save(new Product("Xiaomi Mi TV UHD 4S 43 (L43M5-5ARU)", "9499", "TV"));
        productRepository.save(new Product("JVC LT32MU380", "4899", "TV"));
        productRepository.save(new Product("Watch1", "10000", "Watch"));
        productRepository.save(new Product("Watch2", "10000", "Watch"));
    }

    @Test
    void readProductListByType() throws Exception {
        given(this.productRepository.findByType("TV")).willReturn(Arrays.asList(
                new Product("Xiaomi Mi TV UHD 4S 43 (L43M5-5ARU)", "9499", "TV"),
                new Product("JVC LT32MU380", "4899", "TV")));

        this.mockMvc.perform(get("/productList").param("type", "TV").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void newProduct() {
    }

    @Test
    void editProduct() {
    }

    @Test
    void getProductListTest() {
    }
}
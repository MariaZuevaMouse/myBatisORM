package com.company.mz.orm;

import com.company.mz.orm.db.Main;
import com.company.mz.orm.db.dao.ProductsMapper;
import com.company.mz.orm.db.model.Products;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class ProductBase {
    static ProductsMapper productsMapper;
    Products product;
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {
        try {
            productsMapper = Main.getProductsMapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

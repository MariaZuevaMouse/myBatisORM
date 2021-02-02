package com.company.mz.orm;

import com.company.mz.orm.db.model.Products;
import com.company.mz.orm.db.model.ProductsExample;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductsTest extends ProductBase {
    Integer productId;


    @BeforeEach
    void setUp() {
        product = new Products();
        product.setTitle(faker.food().vegetable());
        product.setPrice((int)(Math.random()*1000));
        product.setCategory_id(1L);
        System.out.println(product);
        ProductsExample productsExample = new ProductsExample();
//        productsExample.


        productsMapper.insert(product);


//        productsMapper.selectByPrimaryKey(1L);
//        assertThat(insert, CoreMatchers.is(1));
        //create  product
        //id = <create object>.getId
    }

    @Test
    void deleteProductThroughDbTest() {
        //get product
    }
}

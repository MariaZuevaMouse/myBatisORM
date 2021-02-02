package com.company.mz.orm.db;

import com.company.mz.orm.db.dao.CategoriesMapper;
import com.company.mz.orm.db.dao.ProductsMapper;
import com.company.mz.orm.db.model.Products;
import com.company.mz.orm.db.model.ProductsExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    private static String resource = "mybatis-config.xml";
    public static void main(String[] args) {

        try {

//            SqlSession sqlSession = getSqlSession();

            CategoriesMapper categoriesMapper1 = getCategotiesMapper();

//            System.out.println(categoriesMapper.countByExample(new CategoriesExample()));

            ProductsMapper productsMapper = getProductsMapper();
//            simpleProductExampleUpdate(productsMapper);

//            ProductsExample productsExample = new ProductsExample();
//            productsExample.createCriteria().andTitleLike("Test%");
//            List<Products> productsList = productsMapper.selectByExample(productsExample);
//            productsList.forEach(product -> System.out.println(product.getTitle()));
//
//            productsMapper.selectByExample(productsExample);
//            productsMapper.selectByExample(new ProductsExample())
//                    .forEach(product -> System.out.println(product.getTitle()));

            Products product = new Products();
            product.setTitle("Mari");
            product.setPrice((int)(Math.random()*1000));
            product.setCategory_id(1L);
            System.out.println(product);


            productsMapper.insert(product);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ProductsMapper getProductsMapper() throws IOException {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.getMapper(ProductsMapper.class);
    }

    public static CategoriesMapper getCategotiesMapper() throws IOException {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.getMapper(CategoriesMapper.class);
    }

    private static SqlSession getSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return sqlSessionFactory.openSession();
    }

    private static void simpleProductExampleUpdate(ProductsMapper productsMapper) {
        Products product = productsMapper.selectByPrimaryKey(3L);
        System.out.printf("product with id = 3 is %s", product.getTitle());


        Products readProduct = productsMapper.selectByPrimaryKey(5L);
        System.out.println("\n5th product price: " + readProduct.getPrice());


        readProduct.setPrice(100000);

        ProductsExample productsExample = new ProductsExample();
        productsExample.createCriteria().andIdEqualTo(5L);

        productsMapper.updateByExample(readProduct, productsExample);

        System.out.println("5th product price: " + productsMapper.selectByPrimaryKey(5L).getPrice());
    }
}

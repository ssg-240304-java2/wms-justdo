package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.ProductMapper;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class ProductService {
    public List<ProductDTO> selectAllProduct() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDTO> productList = productMapper.selectAllUser();


        if (productList != null && productList.size() > 0 ) {
            for(ProductDTO product : productList) {
                System.out.println(product);
            }
        } else {
            System.out.println("등록된 상품이 없습니다.");
        }

        sqlSession.close();
        return productList;


    }

    public List<ProductDTO> selectByCategory() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDTO> productList = productMapper.selectByCategory();


        if (productList != null && productList.size() > 0) {
            for(ProductDTO product : productList) {
                System.out.println(product);
            }
        } else {
            System.out.println("등록된 상품이 없습니다.");
        }
        sqlSession.close();
        return productList;
    }
}

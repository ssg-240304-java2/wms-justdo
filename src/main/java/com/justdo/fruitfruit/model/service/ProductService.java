package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.ProductMapper;
import com.justdo.fruitfruit.model.dto.CategoryDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;


public class ProductService {
    private ProductMapper productMapper;

    /***
     * 카테고리 등록
     * @param category 입력 받은 상품 카테고리
     * @return ture or false
     */
    public boolean registCategory(CategoryDTO category) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        int categoryResult = productMapper.registerProdCategory(category);

        if (categoryResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return categoryResult > 0 ? true: false ;
    }

    /***
     * 카테고리 수정
     * @param category 입력 받은 상품 카테고리
     * @return ture or false
     */
    public boolean modifyCategory(CategoryDTO category) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        int categoryResult = productMapper.modifyProdCategory(category);

        if (categoryResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return categoryResult > 0 ? true: false ;
    }

    /***
     * 물품 등록 기능
     * @param product 입력 받은 상품
     * @return ture or false
     * */
    public boolean registProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        int productResult = productMapper.registerProduct(product);

        if (productResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return productResult > 0 ? true: false ;
    }

    /***
     * 물품 수정
     * @param product 입력 받은 상품
     * @return ture or false
     * */
    public boolean modifyProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        int productResult = productMapper.modifyProduct(product);

        if (productResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return productResult > 0 ? true: false ;
    }

    /***
     * 물품 삭제
     * @param code 입력 받은 상품
     * @return ture or false
     * */
    public boolean deleteProduct(String code) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        int productResult = productMapper.deleteProduct(code);

        if (productResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return productResult > 0 ? true: false ;
    }

    /***
     * 전체 조회 mapper에 userSeq 전달
     * @return userSeq에 해당하는 List
     * */
    public List<ProductDTO> selectAllProduct(int userSeq) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        List<ProductDTO> productList = productMapper.selectAllProduct(userSeq);

        sqlSession.close();
        return productList;
    }
}

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
     * @param name 입력 받은 상품
     * */
    public boolean deleteProduct(String name) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        int productResult = productMapper.deleteProduct(name);

        if (productResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return productResult > 0 ? true: false ;
    }

    public List<ProductDTO> selectAllProduct(int userSeq) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        List<ProductDTO> productList = productMapper.selectAllProduct();

        sqlSession.close();
        return productList;
    }

    /***
     * 사용자가 모든 상품목록을 조회하는 메서드
     * @return 모든 상품 목록
     */
    public List<ProductDTO> selectAllProductByConsumer() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        List<ProductDTO> productList = productMapper.selectAllProductByConsumer();

        sqlSession.close();
        return productList;
    }

    /***
     * 사용자가 입력한 카테고리별로 상품목록을 조회하는 메서드
     * @Param 카테고리 번호
     * @return 입력한 카테고리번호와 같은 모든 상품 목록
     */
    public List<ProductDTO> selectAllProductByCategory(int categoryNum) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDTO> productList = productMapper.selectAllProductByCategory(categoryNum);

        sqlSession.close();
        return productList;
    }
}

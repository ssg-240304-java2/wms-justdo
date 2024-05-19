package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.SystemMapper;
import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class SystemService {

    private SystemMapper systemMapper;

    public List<UserDTO> getUserList() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<UserDTO> userList = systemMapper.getUserList();

        sqlSession.close();

        return userList;
    }

    public int updateUserInfo(UserDTO user) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        try {
            int result = systemMapper.updateUserInfo(user);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int deleteUserInfo(String userSeq) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        int user = Integer.parseInt(userSeq);

        try {
            int result = systemMapper.deleteUserInfo(user);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    /* 판매자 관리 메뉴 */

    public List<CompanyDTO> getSellerList() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<CompanyDTO> sellerList = systemMapper.getSellerList();

        sqlSession.close();

        return sellerList;
    }

    public int updateSellerInfo(CompanyDTO company) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        try {
            int result = systemMapper.updateSellerInfo(company);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int deleteSellerInfo(String sellerSeq) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        int seller = Integer.parseInt(sellerSeq);

        try {
            int result = systemMapper.deleteSellerInfo(seller);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<CompanyDTO> getSellerRequestList() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<CompanyDTO> sellerRequestList = systemMapper.getSellerRequestList();

        sqlSession.close();

        return sellerRequestList;
    }

    public int updateSellerAuth(UserDTO authInfo) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        try {
            int result = systemMapper.updateSellerAuth(authInfo);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    /* 상품 관리 메뉴 */

    public List<ProductDTO> getProductAllList() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<ProductDTO> productList = systemMapper.getProductAllList();

        sqlSession.close();

        return productList;
    }

    public List<ProductDTO> getProductSaleList() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<ProductDTO> productList = systemMapper.getProductSaleList();

        sqlSession.close();

        return productList;
    }

    public int deleteProductInfo(String productSeq) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        int product = Integer.parseInt(productSeq);

        try {
            int result = systemMapper.deleteProductInfo(product);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}
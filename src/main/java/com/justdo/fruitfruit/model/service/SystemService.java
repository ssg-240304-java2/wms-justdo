package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.SystemMapper;
import com.justdo.fruitfruit.model.dto.*;
import org.apache.ibatis.session.SqlSession;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

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

    public List<OrderDTO> getOrderAllList() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<OrderDTO> orderList = systemMapper.getOrderAllList();

        sqlSession.close();

        return orderList;
    }

    public List<OrderDTO> getOrderOnShipping() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<OrderDTO> orderList = systemMapper.getOrderOnShipping();

        sqlSession.close();

        return orderList;
    }

    /***
     * 판매자별 월별 매출 조회
     * @param month 조회할 월
     */
    public void getSalesMonthBySeller(String month) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        List<SalesDTO> salesList = systemMapper.getSalesMonthBySeller(month);

        if (salesList != null && !salesList.isEmpty()) {
            System.out.println();
            System.out.println(String.format("******* %s월 판매자별 매출 *******", month));
            for (SalesDTO sales : salesList) {
                System.out.println(sales);
                System.out.println();
            }
        } else {
            System.out.println(String.format("%s월 매출 내역은 없습니다.", month));
        }
    }

    /***
     * 판매자별 년도별 매출 조회
     * @param year 조회할 년도
     */
    public void getSalesYearBySeller(String year) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        List<SalesDTO> salesList = systemMapper.getSalesYearBySeller(year);
        if (salesList != null && !salesList.isEmpty()) {
            System.out.println();
            System.out.println(String.format("******* %s년도 판매자별 매출 *******", year));
            for (SalesDTO sales : salesList) {
                System.out.println(sales);
                System.out.println();
            }
        } else {
            System.out.println(String.format("%s년도 매출 내역은 없습니다.", year));
        }
    }
}
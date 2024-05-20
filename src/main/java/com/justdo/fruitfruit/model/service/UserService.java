package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.CartMapper;
import com.justdo.fruitfruit.model.dao.CompanyMapper;
import com.justdo.fruitfruit.model.dao.ProductMapper;
import com.justdo.fruitfruit.model.dao.UserMapper;
import com.justdo.fruitfruit.model.dto.CartDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class UserService {

    /***
     * 회원가입을 처리하는 함수
     * @param userDTO 입력한 회원정보
     * @return 추가된 컬럼개수를 반환
     *         없을경우 0 반환
     */
    public int insertUser(UserDTO userDTO) {

        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            int result =userMapper.insertUser(userDTO);
            sqlSession.commit();
            return result;
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public void addCart(String id, int choice, int count) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int userSeq = userMapper.searchUser(id);
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);
        Map<String, Integer> params = new HashMap<>();
        params.put("choice",choice);

        Integer comSeq = companyMapper.searchCom(params);
        Map<String, Object> map = new HashMap<>();

        map.put("productSeq", choice);
        map.put("userSeq", userSeq);
        map.put("companySeq", comSeq);
        map.put("quantity", count);
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        int result = cartMapper.addCart(map);
        if(result > 0) {
            System.out.println("장바구니 등록 성공!");
            sqlSession.commit();
        } else {
            System.out.println("장바구니 등록 실패!");
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    public void viewCart(String id) {
        SqlSession sqlSession = getSqlSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        int userSeq = userMapper.searchUser(id);
        List<CartDTO> cartList = new ArrayList<>();
        cartList = cartMapper.viewCart(userSeq);
        if(cartList != null && cartList.size() > 0) {
            for (CartDTO cartDTO : cartList) {
                String productName = productMapper.productName(cartDTO.getProductSeq());
                System.out.println("상품 번호 : "+ cartDTO.getProductSeq() +" 상품명 : " + productName  + " 수량 : "+ cartDTO.getQuantity());
            }
        }else{
            System.out.println("장바구니가 비어있습니다.");
        }
        sqlSession.close();
    }

    public void deleteAllCart(String id) {
        SqlSession sqlSession = getSqlSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int userSeq = userMapper.searchUser(id);
        int result = cartMapper.deleteAllCart(userSeq);
        if(result > 0) {
            sqlSession.commit();
        }else{
            System.out.println("카트 지우기 실패!");
        }
        sqlSession.close();
    }

    public void modifyQuantity(String id, int productNum, int quantity) {
        SqlSession sqlSession = getSqlSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int userSeq = userMapper.searchUser(id);
        Map<String, Integer> params = new HashMap<>();
        params.put("userSeq", userSeq);
        params.put("productNum", productNum);
        params.put("quantity", quantity);
        int result;
        if(quantity > 0) {
            result = cartMapper.modifyQuantity(params);
        }else{
            result = cartMapper.deleteQuantity(params);
        }

        if(result > 0) {
            System.out.println("물품수정 성공!");
            sqlSession.commit();
        }else{
            System.out.println("물품수정 실패!");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}

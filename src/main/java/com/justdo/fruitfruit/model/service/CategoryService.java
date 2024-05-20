package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.CategoryMapper;
import com.justdo.fruitfruit.model.dto.CategoryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class CategoryService {

    /***
     * 사용자에게 카테고리 목록과 카테고리번호를 출력하는 메서드
     * @return 카테고리 목록과 번호 출력
     */
    public List<CategoryDTO> selectAllCategory() {
        SqlSession sqlSession = getSqlSession();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryDTO> categoryList = categoryMapper.selectAllCategory();

        sqlSession.close();
        return categoryList;

    }
}

package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.CategoryDTO;
import com.justdo.fruitfruit.model.service.CategoryService;
import com.justdo.fruitfruit.view.CategoryResultMessage;

import java.util.List;

public class CategoryController {

    private final CategoryResultMessage categoryResultMessage = new CategoryResultMessage();
    private final CategoryService categoryService = new CategoryService();

    /***
     * 카테고리 전체 출력
     */
    public void selectAllCategory() {
        List<CategoryDTO> categoryList = categoryService.selectAllCategory();

        if (categoryList == null && categoryList.isEmpty()) {
            categoryResultMessage.printAllCategoryResult("printError");
        } else {
            categoryResultMessage.printAllCategoryResult("printSuccess");
            categoryResultMessage.printAllCategory(categoryList);
        }
    }
}

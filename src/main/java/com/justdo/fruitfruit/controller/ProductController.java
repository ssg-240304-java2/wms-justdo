package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.CategoryDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.service.ProductService;
import com.justdo.fruitfruit.view.ProductResultMessage;

import java.util.List;
import java.util.Map;

public class ProductController {
    private final ProductResultMessage resultMessage;
    private final ProductService productService;

//    UserDTO userDTO = new UserDTO();

//        int userSeq = userDTO.getUserSeq; // 로그인된 userSeq 가져와야함

    public ProductController(){
        resultMessage = new ProductResultMessage();
        productService = new ProductService();
    }

    /***
     * 상품 등록 parameter 받아오기
     * */
    public void registProduct(Map<String, String> parameter){
        String name = parameter.get("productName");
        String category = parameter.get("productCategory");
        int price = Integer.parseInt(parameter.get("productPrice"));
        int amount = Integer.parseInt(parameter.get("productAmount"));
        double weight = Double.parseDouble(parameter.get("productWeight"));

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category);

        boolean isCategoryRegistered = productService.registCategory(categoryDTO);


        if (isCategoryRegistered) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setCategorySeq(categoryDTO.getCategorySeq());
//            productDTO.setUserSeq(userSeq); // userSeq 설정
            productDTO.setProductName(name);
            productDTO.setProductPrice(price);
            productDTO.setProductAmount(amount);
            productDTO.setProductWeight(weight);
            productDTO.setProductStatus(1); // 입고요청 1

            boolean isRegistered = productService.registProduct(productDTO);

            if (isRegistered) {
                resultMessage.productSuccessMessage("register");
            } else {
                resultMessage.productFailureMessage("register");
            }
        } else {
            resultMessage.productFailureMessage("register");
        }
    }

    /***
     * 상품 수정 parameter 받아오기
     * */

    public void modifyProduct(Map<String, String> parameter){
        String name = parameter.get("productName");
        String category = parameter.get("productCategory");
        int price = Integer.parseInt(parameter.get("productPrice"));
        int amount = Integer.parseInt(parameter.get("productAmount"));
        double weight = Double.parseDouble(parameter.get("productWeight"));

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category);

        boolean isCategoryModified = productService.modifyCategory(categoryDTO);

        if (isCategoryModified) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setCategorySeq(categoryDTO.getCategorySeq());
//            productDTO.setUserSeq(userSeq); // userSeq 설정
            productDTO.setProductName(name);
            productDTO.setProductPrice(price);
            productDTO.setProductAmount(amount);
            productDTO.setProductWeight(weight);
            productDTO.setProductStatus(1); // 입고요청 1

            boolean isModified = productService.modifyProduct(productDTO);

            if (isModified) {
                resultMessage.productSuccessMessage("modify");
            } else {
                resultMessage.productFailureMessage("modify");
            }
        } else {
            resultMessage.productFailureMessage("modify");
        }
    }

    /**
     * 물품 삭제
     * */
    public void deleteProduct(Map<String, String> parameter){
        String name = parameter.get("productName");

        if (productService.deleteProduct(name)) {
            resultMessage.productSuccessMessage("delete");
        } else {
            resultMessage.productFailureMessage("delete");
        }

    }

    public void selectAllProduct() {
        List<ProductDTO> productList = productService.selectAllProduct();

        if (productList != null && !productList.isEmpty()) {
            resultMessage.printAllProduct(productList);
        } else {
            resultMessage.productFailureMessage("viewAll");
        }
    }
}

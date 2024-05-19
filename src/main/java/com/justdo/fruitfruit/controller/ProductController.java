package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.ProductService;
import com.justdo.fruitfruit.view.ProductResultMessage;
import com.justdo.fruitfruit.view.UserResultMessage;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class ProductController {
    private final ProductResultMessage resultMessage;

    private final UserResultMessage userResultMessage;
    private final ProductService productService;
    private UserDTO userDTO;
    public ProductController(){
        resultMessage = new ProductResultMessage();
        userResultMessage = new UserResultMessage();
        productService = new ProductService();
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    /***
     * 로그인된 userSeq 가져오기
     * */
    private int getUserSeq() {
        return userDTO.getUserSeq();
    }

    /***
     * 상품 등록 parameter 받아오기
     * */
    public void registerProduct(Map<String, String> parameter){
        if (userDTO == null) {
            resultMessage.productFailureMessage("register");
            return;
        }

        String name = parameter.get("productName");
        int category = Integer.parseInt(parameter.get("productCategory"));
        int price = Integer.parseInt(parameter.get("productPrice"));
        int amount = Integer.parseInt(parameter.get("productAmount"));
        double weight = Double.parseDouble(parameter.get("productWeight"));
        int userSeq = userDTO.getUserSeq();

        if (category > 0) {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setCategorySeq(category);
            productDTO.setUserSeq(userSeq);
            productDTO.setProductName(name);
            productDTO.setProductPrice(price);
            productDTO.setProductAmount(amount);
            productDTO.setProductWeight(weight);
            productDTO.setProductStatus(1); // 입고요청 1

            boolean isRegistered = productService.registerProduct(productDTO);

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
        int productSeq = Integer.parseInt(parameter.get("productSeq"));
        String name = parameter.get("productName");
        int price = Integer.parseInt(parameter.get("productPrice"));
        int amount = Integer.parseInt(parameter.get("productAmount"));
        double weight = Double.parseDouble(parameter.get("productWeight"));
        int userSeq = userDTO.getUserSeq();

        if (productSeq > 0) {

            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductSeq(productSeq);
            productDTO.setUserSeq(userSeq);
            productDTO.setProductName(name);
            productDTO.setProductPrice(price);
            productDTO.setProductAmount(amount);
            productDTO.setProductWeight(weight);

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
        int productSeq = Integer.parseInt(parameter.get("productSeq"));

        if (productService.deleteProduct(productSeq)) {
            resultMessage.productSuccessMessage("delete");
        } else {
            resultMessage.productFailureMessage("delete");
        }
    }

    /***
     * 판매자 내 모든 물품 조회
     * */
    public void selectAllProduct() {
        int userSeq = userDTO.getUserSeq();

        List<ProductDTO> productList = productService.selectAllProduct(userSeq);
        if (productList != null && !productList.isEmpty()) {
            resultMessage.printAllProduct(productList);
        } else {
            resultMessage.productFailureMessage("viewAll");
        }
    }


    /***
     * 구매자 물품 전체 출력
     * */
    public void selectAllProductByConsumer() {

        List<ProductDTO> productList = productService.selectAllProductByConsumer();

        if (productList == null && productList.isEmpty()) {
            userResultMessage.printAllProductResult("printError");
        } else {
            userResultMessage.printAllProductResult("printSuccess");
            userResultMessage.printAllProductByUser(productList);
        }
    }

    /***
     * 물품 카테고리별 출력
     * @param categoryNum 카테고리 번호
     */
    public void selectAllProductByCategory(int categoryNum) {
        List<ProductDTO> productList = productService.selectAllProductByCategory(categoryNum);

        if (productList == null && productList.isEmpty()) {
            userResultMessage.printAllByCategoryResult("printError");
        } else {
            userResultMessage.printAllByCategoryResult("printSuccess");
            userResultMessage.printAllProductByUser(productList);
        }
    }
}

package com.justdo.fruitfruit.model.dto;

import lombok.*;

@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든필드초기화하는 매개변수있는생성자
@Getter    // getter메소드
@Setter     // setter메소드

public class CategoryDTO {
    private int categorySeq;
    private String categoryName;

    @Override
    public String toString() {
        return "카테고리[번호] : " + categoryName + "[" + categorySeq +"]";
    }

}

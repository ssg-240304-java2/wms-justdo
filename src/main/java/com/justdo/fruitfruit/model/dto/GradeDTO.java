package com.justdo.fruitfruit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeDTO {

    private int gradeSeq;
    private int categorySeq;
    private String gradeName;
    private int brixValue;
    private String categoryName;

}

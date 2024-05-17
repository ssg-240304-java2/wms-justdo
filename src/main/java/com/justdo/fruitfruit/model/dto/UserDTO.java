package com.justdo.fruitfruit.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer userSeq;
    private String id;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private Integer auth;
}

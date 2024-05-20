package com.justdo.fruitfruit.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int userSeq;
    private String id;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private int auth;

    public UserDTO(String id, String password, String name, String address, String phoneNumber, int auth) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.auth = auth;
    }
}

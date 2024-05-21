package com.justdo.fruitfruit.model.dto;

import lombok.*;

import java.text.DecimalFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Override
    public String toString() {
        String authName;
        if (auth == 1) {
            authName = "시스템관리자";
        } else if (auth == 2) {
            authName = "창고관리자";
        } else if (auth == 3) {
            authName = "구매자";
        } else if (auth ==4) {
            authName = "판매자";
        } else {
            authName = "unKnown";
        }

        return
                "[회원번호] " + userSeq + " | " +
                "[아이디] " + id + " " +
                "[비밀번호] " + password + " " +
                "[이름] " + name + " " +
                "[주소] " + address + " " +
                "[전화번호] " + phoneNumber + " " +
                "[권한] " + authName
                ;
    }
}

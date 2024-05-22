package com.justdo.fruitfruit.model.dto;

import com.justdo.fruitfruit.common.constant.Auth;
import lombok.*;

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

    public String getUserAuthDescription() {
        switch (auth) {
            case 1:
                return Auth.SYSADMIN.getAuth();
            case 2:
                return Auth.WAREHOUSEADMIN.getAuth();
            case 3:
                return Auth.CONSUMER.getAuth();
            case 4:
                return Auth.SELLER.getAuth();
            default:
                return "알 수 없음";
        }
    }

    @Override
    public String toString() {
        return
                "[회원번호] " + userSeq + " | " +
                        "[아이디] " + id + " " +
                        "[비밀번호] " + password + " " +
                        "[이름] " + name + " " +
                        "[주소] " + address + " " +
                        "[전화번호] " + phoneNumber + " " +
                        "[권한] " + getUserAuthDescription()
                ;
    }
}

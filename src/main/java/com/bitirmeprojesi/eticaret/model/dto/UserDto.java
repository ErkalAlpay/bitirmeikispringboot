package com.bitirmeprojesi.eticaret.model.dto;

import com.bitirmeprojesi.eticaret.exception.model.PasswordMatchRepasswordException;
import lombok.Data;



@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String repassword;
    private String first_name;
    private String last_name;
    private String telephone;

    public void checkPassword(){
        if (!this.password.equals(this.repassword)) {
            throw new PasswordMatchRepasswordException();
        }
    }
}

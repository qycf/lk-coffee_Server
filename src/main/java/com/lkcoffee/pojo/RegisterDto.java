package com.lkcoffee.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String username;
    @JsonProperty("tel")
    private String tel;
    private String password;
    @JsonProperty("verify_code")
    private String verifyCode;
}

package com.lkcoffee.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneLoginDto {

    @JsonProperty("phone_number")
    private String phoneNumber;
    private String code;
}

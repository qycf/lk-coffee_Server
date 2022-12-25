package com.lkcoffee.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelLoginDto {

    @NotNull
    private String tel;
    @JsonProperty("verify_code")
    @NotNull
    private String verifyCode;
}

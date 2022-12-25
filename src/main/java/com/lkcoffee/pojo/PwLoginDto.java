package com.lkcoffee.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwLoginDto {

    @NotNull
    private String tel;
    @NotNull
    private String password;
}

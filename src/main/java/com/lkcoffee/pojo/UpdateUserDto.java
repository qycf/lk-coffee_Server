package com.lkcoffee.pojo;


import cn.hutool.json.JSONObjectIter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {

    private String username;

    private String value;
}

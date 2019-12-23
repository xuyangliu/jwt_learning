package com.peanut.jwt_learning.Entity.PostGreSQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DwTest {

    private Integer id;
    private String name;
    private String password;

}

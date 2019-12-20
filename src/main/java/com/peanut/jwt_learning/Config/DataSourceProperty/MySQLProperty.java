package com.peanut.jwt_learning.Config.DataSourceProperty;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Configuration
@ConfigurationProperties(prefix = "data-source.mysql")
public class MySQLProperty {

    private String url;
    private String username;
    private String password;
    private String driver;

}

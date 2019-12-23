package com.peanut.jwt_learning.Config.DataSourceProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kenny Liu
 * @version 2019-12-23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Configuration
@ConfigurationProperties(prefix = "data-source.postgresql")
public class PostGreSQLProperty {

    private String url;
    private String username;
    private String password;
    private String driverClassName;

}
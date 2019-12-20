package com.peanut.jwt_learning.Config.DataSourceProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
@ConfigurationProperties(prefix = "data-source.redis")
public class RedisProperty {

    private String host;
    private Integer port;
    private Integer database;

    private Integer maxActive;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWait;

}

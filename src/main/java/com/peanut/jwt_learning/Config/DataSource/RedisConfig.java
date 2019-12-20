package com.peanut.jwt_learning.Config.DataSource;

import com.peanut.jwt_learning.Config.DataSourceProperty.RedisProperty;
import com.peanut.jwt_learning.Exception.AuthExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Kenny Liu
 * @version 2019-12-20
 **/
@Configuration
public class RedisConfig {

    private static final Logger log = LoggerFactory.getLogger(AuthExceptionHandler.class);

    @Autowired
    private RedisProperty redisProperty;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperty.getMaxActive());
        jedisPoolConfig.setMaxTotal(redisProperty.getMaxIdle());
        jedisPoolConfig.setMinIdle(redisProperty.getMinIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperty.getMaxWait());
        return jedisPoolConfig;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        // Standalone,Sentinel和RedisCluster三种模式
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisProperty.getHost());
        redisStandaloneConfiguration.setDatabase(redisProperty.getDatabase());
        redisStandaloneConfiguration.setPort(redisProperty.getPort());

        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder();
        builder.poolConfig(jedisPoolConfig);

        return new JedisConnectionFactory(redisStandaloneConfiguration, builder.build());
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }
}

package com.peanut.jwt_learning.Config.DataSource;

import com.peanut.jwt_learning.Config.DataSourceProperty.MySQLProperty;
import com.peanut.jwt_learning.Config.DataSourceProperty.PostGreSQLProperty;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Kenny Liu
 * @version 2019-12-23
 **/
@Configuration
@MapperScan(basePackages = "com.peanut.jwt_learning.Mapper.MySQL", sqlSessionFactoryRef = "mySQLSqlSessionFactory")
@MapperScan(basePackages = "com.peanut.jwt_learning.Mapper.PostGreSQL", sqlSessionFactoryRef = "postGreSQLSqlSessionFactory")
public class MyBatisConfig {

    @Autowired
    private MySQLProperty mySQLProperty;

    @Autowired
    private PostGreSQLProperty postGreSQLProperty;

    @Primary
    @Bean(name = "mySQLDataSource")
    public DataSource mySQLDataSource() {
        DataSourceBuilder<?> mySQLDataSourceBuilder = DataSourceBuilder.create();
        mySQLDataSourceBuilder.url(mySQLProperty.getUrl());
        mySQLDataSourceBuilder.username(mySQLProperty.getUsername());
        mySQLDataSourceBuilder.password(mySQLProperty.getPassword());
        mySQLDataSourceBuilder.driverClassName(mySQLProperty.getDriverClassName());
        return mySQLDataSourceBuilder.build();
    }

    @Bean(name = "postGreSQLDataSource")
    public DataSource postGreSQLDataSource() {
        DataSourceBuilder<?> postGreSQLDataSourceBuilder = DataSourceBuilder.create();
        postGreSQLDataSourceBuilder.url(postGreSQLProperty.getUrl());
        postGreSQLDataSourceBuilder.username(postGreSQLProperty.getUsername());
        postGreSQLDataSourceBuilder.password(postGreSQLProperty.getPassword());
        postGreSQLDataSourceBuilder.driverClassName(postGreSQLProperty.getDriverClassName());
        return postGreSQLDataSourceBuilder.build();
    }

    @Primary
    @Bean(name = "mySQLSqlSessionFactory")
    public SqlSessionFactory mySQLSqlSessionFactory(@Qualifier("mySQLDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasource);
        factoryBean.setTypeAliasesPackage("com.peanut.jwt_learning.Entity.MySQL");
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:MyBatis/Mapper/MySQL/*.xml"));
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:MyBatis/mybatis-config.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "postGreSQLSqlSessionFactory")
    public SqlSessionFactory postGreSQLSqlSessionFactory(@Qualifier("postGreSQLDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasource);
        factoryBean.setTypeAliasesPackage("com.peanut.jwt_learning.Entity.PostGreSQL");
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:MyBatis/Mapper/PostGreSQL/*.xml"));
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:MyBatis/mybatis-config.xml"));
        return factoryBean.getObject();
    }

    @Primary
    @Bean(name = "mySQLTransactionManager")
    public DataSourceTransactionManager mySQLTransactionManager(@Qualifier("mySQLDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "postGreSQLTransactionManager")
    public DataSourceTransactionManager postGreSQLTransactionManager(@Qualifier("postGreSQLDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "mySQLSqlSessionTemplate")
    public SqlSessionTemplate mySQLSqlSessionTemplate(
            @Qualifier("mySQLSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "postGreSQLSqlSessionTemplate")
    public SqlSessionTemplate postGreSQLSqlSessionTemplate(
            @Qualifier("postGreSQLSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
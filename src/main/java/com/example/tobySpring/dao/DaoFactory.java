package com.example.tobySpring.dao;

import com.example.tobySpring.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {


    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}

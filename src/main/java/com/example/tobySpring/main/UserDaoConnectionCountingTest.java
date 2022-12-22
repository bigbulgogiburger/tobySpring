package com.example.tobySpring.main;

import com.example.tobySpring.dao.CountingConnectionMaker;
import com.example.tobySpring.dao.CountingDaoFactory;
import com.example.tobySpring.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoConnectionCountingTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao =context.getBean("userDao",UserDao.class);
        
        /*
        * dao 사용코드
        * */
        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("ccm.getCounter() = " + ccm.getCounter());

    }
}

package com.example.tobySpring;

import com.example.tobySpring.dao.*;
import com.example.tobySpring.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class UserDaoTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		ApplicationContext context = new GenericXmlApplicationContext("spring/applicationContext.xml");
		UserDao userDao = context.getBean("userDao",UserDao.class);

		userDao.deleteAll();

		User user = new User();
		user.setId("hello5");
		user.setName("편도훈245");
		user.setPassword("123425");

		userDao.add(user);
		System.out.println(user.getId()+": 등록 성공");

		User user2 = userDao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId()+": 조회 성공");
	}

}

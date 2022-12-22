package com.example.tobySpring;

import com.example.tobySpring.dao.UserDao;
import com.example.tobySpring.dto.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/test-applicationContext.xml")
//@DirtiesContext
public class UserDaoTestTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;


	@Before
	public void setUp(){
//		this.dao = context.getBean("userDao", UserDao.class);

//		DataSource dataSource = new SingleConnectionDataSource("jdbc:h2:tcp://localhost/~/test","sa",null,true);
//		dao.setDataSource(dataSource);
		this.user1= new User("dohoon1","편도훈1","111111");
		this.user2= new User("dohoon2","편도훈2","111111");
		this.user3= new User("dohoon3","편도훈3","111111");
	}


	public static void main(String[] args) {
		JUnitCore.main("com.example.tobySpring.UserDaoTestTests");
	}


	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {

//		NOTE : 새로운 생성자로 유저 미리 만들기


//		NOTE : db내부 전부 삭제 및 검증

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));




		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(),is(2));

		System.out.println("test ended");

		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(),is(user1.getName()));
		assertThat(userget1.getPassword(),is(userget1.getPassword()));

		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(),is(user2.getName()));
		assertThat(userget2.getPassword(),is(userget2.getPassword()));


	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException {

		dao.deleteAll();
		assertThat(dao.getCount(),is(0));

		dao.get("unknown_id");
	}


}

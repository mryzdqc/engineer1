package fengzhuang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.UserDao;
import entity.User;
import service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class JTest {
	@Autowired
	UserDao dao;
	@Autowired
	UserService service;
	
	@Test
	public void aa() {
		User u = new User("admin","123456");
		User u1 = service.login(u);
		System.out.println(u1.getUsername());
	}
}

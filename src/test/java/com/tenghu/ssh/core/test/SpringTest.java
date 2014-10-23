package com.tenghu.ssh.core.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tenghu.ssh.core.model.Users;
import com.tenghu.ssh.core.service.IUsersService;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		IUsersService usersService=context.getBean(IUsersService.class);
		Users user=new Users();
		user.setUserName("admin");
		user.setPassword("admin");
		user.setSex(1);
		user.setPhone("13265748596");
		user.setEmail("234234234234@qq.com");
		user.setTrueName("张三");
		user.setCreateTime(System.currentTimeMillis());
		System.out.println(usersService.addUsers(user));
	}
}

package com.tenghu.ssh.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenghu.ssh.core.dao.IUsersDao;
import com.tenghu.ssh.core.model.Users;
import com.tenghu.ssh.core.service.IUsersService;
import com.tenghu.ssh.core.util.JsonMessageUtil;

@Service
public class UsersServiceImpl implements IUsersService{
	
	@Autowired
	private IUsersDao usersDao;

	@Override
	public Users queryUsers(int id) {
		return usersDao.queryUsersById(id);
	}

	@Override
	public Users queryUsers(String username) {
		return usersDao.queryUsersByUsername(username);
	}

	@Override
	public String addUsers(Users user) {
		try {
			usersDao.addUsers(user);
			return JsonMessageUtil.getSurressJson("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMessageUtil.getErrorJson("添加失败！");
	}

	@Override
	public String updateUsers(Users user) {
		try {
			usersDao.updateUsers(user);
			return JsonMessageUtil.getSurressJson("修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMessageUtil.getErrorJson("修改失败！");
	}
}

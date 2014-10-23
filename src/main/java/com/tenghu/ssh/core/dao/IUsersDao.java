package com.tenghu.ssh.core.dao;
import com.tenghu.ssh.core.model.Users;

public interface IUsersDao {
	//根据用户id查询用户
	public Users queryUsersById(int id);
	//根据用户名查询用户
	public Users queryUsersByUsername(String username);
	//添加用户
	public void addUsers(Users users);
	//修改用户
	public void updateUsers(Users users);
}

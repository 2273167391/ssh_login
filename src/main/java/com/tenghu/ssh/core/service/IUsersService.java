package com.tenghu.ssh.core.service;
import com.tenghu.ssh.core.model.Users;

public interface IUsersService {
	public Users queryUsers(int id);
	public Users queryUsers(String username);
	public String addUsers(Users user);
	public String updateUsers(Users user);
}

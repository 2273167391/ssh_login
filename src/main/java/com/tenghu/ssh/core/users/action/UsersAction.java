package com.tenghu.ssh.core.users.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tenghu.ssh.core.action.BaseAction;
import com.tenghu.ssh.core.common.DictKeys;
import com.tenghu.ssh.core.model.Users;
import com.tenghu.ssh.core.service.IUsersService;
import com.tenghu.ssh.core.util.JsonMessageUtil;
@Controller
public class UsersAction extends BaseAction{
	
	@Autowired
	private IUsersService usersService;
	private Users user;
	
	public String selInfo(){
		//获取当前登录用户
		Users user=(Users) getSession().getAttribute(DictKeys.CUR_LOGIN_USER);
		//将用户设置到Request中
		getRequest().setAttribute("user", user);
		return "sel";
	}
	
	/**
	 * 检查用户名
	 * @return
	 */
	public String checkUserName(){
		Users user=usersService.queryUsers(getRequest().getParameter("username"));
		if(null==user){
			json=JsonMessageUtil.getSurressJson("用户名可以使用！");
		}else{
			json=JsonMessageUtil.getErrorJson("用户名已被使用！");
		}
		return JSON_MESSAGE;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}

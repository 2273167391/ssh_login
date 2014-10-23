package com.tenghu.ssh.core.common.action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tenghu.ssh.core.action.BaseAction;
import com.tenghu.ssh.core.common.DictKeys;
import com.tenghu.ssh.core.model.Users;
import com.tenghu.ssh.core.service.IUsersService;
import com.tenghu.ssh.core.util.JsonMessageUtil;
import com.tenghu.ssh.core.util.SecurityPwdUtil;

@Controller
public class LoginAction extends BaseAction{
	@Autowired
	private IUsersService usersService;
	private String username;
	private String password;
	private String code;
	
	public String login(){
		try{
			//获取验证码
			String oldCode=(String) getSession().getAttribute(DictKeys.RANDOM_CODE_STR);
			//验证验证码
			if(code.trim().equalsIgnoreCase(oldCode)){
				//获取用户
				Users user=usersService.queryUsers(username);
				if(null!=user){
					//验证密码是否正确
					boolean isTrue=SecurityPwdUtil.authenticate(password, user.getPassword(), user.getSalt());
					if(isTrue){
						getSession().setAttribute(DictKeys.CUR_LOGIN_USER, user);
						user.setLoginTime(System.currentTimeMillis());//设置登录时间
						//更新登录时间
						usersService.updateUsers(user);
						json= JsonMessageUtil.getSurressJson("登录成功！");
					}else{
						json= JsonMessageUtil.getErrorJson("用户名或密码错误！");
					}
				}else{
					json= JsonMessageUtil.getErrorJson("用户名或密码错误！");
				}
			}else{
				json= JsonMessageUtil.getErrorJson("验证码错误！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			json=JsonMessageUtil.getErrorJson("系统发生错误！");
		}
		return JSON_MESSAGE;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

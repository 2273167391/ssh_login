package com.tenghu.ssh.core.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tenghu.ssh.core.common.DictKeys;
import com.tenghu.ssh.core.model.Users;
@Controller
public class BaseAction extends ActionSupport{
	protected final String JSON_MESSAGE="json_message";
	protected HttpSession httpSession;
	protected HttpServletRequest httpRequest;
	protected String json;
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	protected HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	protected Users getLoginUserInfo(){
		return (Users) ServletActionContext.getRequest().getAttribute(DictKeys.CUR_LOGIN_USER);
	}
}

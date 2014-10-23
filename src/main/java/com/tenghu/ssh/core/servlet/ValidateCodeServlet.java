package com.tenghu.ssh.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tenghu.ssh.core.util.RandomValidateCodeUtil;

public class ValidateCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("image/jpeg");//设置类型，告诉浏览器是图片
		response.setHeader("Pargma", "No-cache");//设置响应头信息，告诉浏览器不用缓存
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expire", 0);
		RandomValidateCodeUtil.getRandom(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

package com.tenghu.ssh.core.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tenghu.ssh.core.dao.IUsersDao;
import com.tenghu.ssh.core.model.Users;
import com.tenghu.ssh.core.util.SecurityPwdUtil;

@Repository
public class UsersDaoImpl implements IUsersDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Users queryUsersById(int id) {
		// 获取Session
		Session session = sessionFactory.getCurrentSession();
		// 查询语句
		String hql = "from Users where id=:id";
		// 创建查询
		Query query = session.createQuery(hql);
		// 设置查询参数
		query.setInteger("id", id);
		// 执行查询
		List<Users> userList = query.list();
		if (userList.size() <= 0)
			return null;
		return userList.get(0);
	}

	@Override
	public Users queryUsersByUsername(String username) {
		// 获取Session
		Session session = sessionFactory.getCurrentSession();
		// 查询语句
		String hql = "from Users where userName=:username";
		// 创建查询
		Query query = session.createQuery(hql);
		// 设置查询参数
		query.setString("username", username);
		// 执行查询
		List<Users> userList = query.list();
		return userList.size() <= 0 ? null : userList.get(0);
	}

	

	@Override
	public void addUsers(Users users) {
		try {
			// 获取密码盐
			String salt = SecurityPwdUtil.generateSalt();
			// 设置密码
			users.setPassword(SecurityPwdUtil.getEncryptedPassword(users.getPassword(), salt));
			// 设置密码盐
			users.setSalt(salt);
			// 保存用户
			sessionFactory.getCurrentSession().save(users);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUsers(Users users) {
		sessionFactory.getCurrentSession().update(users);
	}

}

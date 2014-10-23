package com.tenghu.ssh.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tenghu.ssh.core.util.StringUtil;

@Entity
@Table(name="tab_users")
public class Users {
	private int id;
	private String userName;
	private String password;
	private String salt;
	private String trueName;
	private int sex;
	private String birthday;
	private String phone;
	private String email;
	private long createTime;
	private long loginTime;
	
	private String cTime;//添加时间
	private String lTime;//登录时间
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="salt")
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="truename")
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Column(name="sex")
	public int getSex() {
		return sex;
	}
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	

	@Column(name="birthday")
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="createtime")
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="logintime")
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	
	@Transient
	public String getcTime() {
		return StringUtil.getDateStr(getCreateTime());
	}
	public void setcTime(String cTime) {
		this.cTime = cTime;
	}
	
	@Transient
	public String getlTime() {
		return StringUtil.getDateTimeStr(getLoginTime());
	}
	public void setlTime(String lTime) {
		this.lTime = lTime;
	}

	public Users() {
	}
}

package com.csy.demo.model;

import com.csy.demo.utils.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体
 * @author Administrator
 *
 */
@Entity
@Table(name="t_user")
public class Users {

	@Id
	private String id;  // 编号
	
	@NotEmpty(message="请输入用户名！")
	@Column(length=100)
	private String userName; // 用户名
	
	@NotEmpty(message="请输入密码！")
	@Column(length=100)
	private String password; // 密码
	
	@Email(message="邮箱地址格式有误！")
	@NotEmpty(message="请输入邮箱地址！")
	@Column(length=100)
	private String email; // 验证邮箱地址
	
	@Column(length=100)
	private String imageName; // 用户头像
	
	private Integer points=0; // 用户积分
	
	private boolean isVip=false; // 是否是VIP
	
	private boolean isOff=false; // 是否被封禁
	
	private String roleName="会员"; // 角色名称 会员  管理员 两种 默认 会员
	
	private Date registerDate; // 注册日期

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public boolean isOff() {
		return isOff;
	}

	public void setOff(boolean isOff) {
		this.isOff = isOff;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
}

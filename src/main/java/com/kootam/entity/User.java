package com.kootam.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class User {
	
	public static final String USERTYPE_ADMIN = "ADMIN";
	public static final String USERTYPE_BACKOFFICE = "BACKOFFICE";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lo_id")
	private Long id;
	
	@Column(name="lo_username")
	private String username;
	
	@Column(name="lo_password")
	private String password;
	
	@Column(name="lo_usertype")
	private String usertype;
	
	public User(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
public User(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	
	
}


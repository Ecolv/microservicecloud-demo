package com.springcloud.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
// @AllArgsConstructor
// @NoArgsConstructor
// @Data
// @Accessors(chain=true)
public class User implements Serializable {
	private Long id;
	private String uname;
	private String password;
	// 来自哪个数据库,因为微服务架构可以一个服务对应一个数据库
	private String db_source;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDb_source() {
		return db_source;
	}

	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}

	public User(Long id, String uname, String password, String db_source) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.db_source = db_source;
	}

	public User() {
		super();
	}

}

package com.qinkuai.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class AbstractUser {
	// 用户ID
	protected String id;
	// 用户名
	protected String username;
	// 用户密码
	protected String password;
}

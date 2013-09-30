package com.piggsoft.comms.security.model;

import java.io.Serializable;
import java.util.Set;

public abstract class Users implements Serializable, Comparable<Users>{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5741498473578771103L;
	
	/**
	 * 获取账号
	 * @return
	 */
	public abstract String getAccount();
	
	/**
	 * 获取密码
	 * @return
	 */
	public abstract String getPassword();
	
	/**
	 * 获取该用户的所有角色
	 * @return
	 */
	public abstract Set<Roles> getRoles();
	
	/**
	 * 是否可用
	 * @return
	 */
	public abstract boolean isEnabled();
	
	/**
	 * 账号是否没有失效
	 * @return
	 */
	public abstract boolean isAccountNonExpired();
	
	/**
	 * 账号是否没被锁
	 * @return
	 */
	public abstract boolean isAccountNonLocked();
	
	/**
	 * 凭证是否没有失效
	 * @return
	 */
	public abstract boolean isCredentialsNonExpired();
	
	/**
	 * 清理凭证
	 */
	public abstract void eraseCredentials();

}

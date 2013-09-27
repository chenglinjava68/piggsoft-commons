package com.piggsoft.comms.security.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public abstract class Users extends User{

	public Users(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5741498473578771103L;

	public abstract String getAccount();

	public abstract String getPassword();

	public abstract Set<Roles> getRoles();

}

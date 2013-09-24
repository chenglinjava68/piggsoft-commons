package com.piggsoft.comms.security;

import java.util.Set;

public abstract class Users {

	public abstract String getAccount();

	public abstract String getPassword();

	public abstract Set<Roles> getRoles();

}

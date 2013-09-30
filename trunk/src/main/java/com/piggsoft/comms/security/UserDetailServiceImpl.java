package com.piggsoft.comms.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.piggsoft.comms.security.model.Resources;
import com.piggsoft.comms.security.model.Roles;
import com.piggsoft.comms.security.model.Users;
import com.piggsoft.comms.security.model.UsersDao;

public class UserDetailServiceImpl implements UserDetailsService{
	private UsersDao usersDao;  
	
	private UserCache userCache;
	
    public void setUsersDao(UsersDao usersDao) {  
        this.usersDao = usersDao;  
    }  
      
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
    	Users users = (Users) userCache.getUserFromCache(username);
    	if(users == null) {
    		users = this.usersDao.findByName(username);
    	}
        if(users == null) {  
            throw new UsernameNotFoundException(username);  
        }  
        Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);  
        
        
        /*
        boolean enables = true;  
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;  
        */  
        User userdetail = new User(users.getAccount(), users.getPassword(), users.isEnabled(), 
        			users.isAccountNonExpired(), users.isCredentialsNonExpired(), users.isAccountNonLocked(), grantedAuths);  
        return userdetail;  
    }  
      
    //取得用户的权限  
    private Set<GrantedAuthority> obtionGrantedAuthorities(Users user) {  
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();  
        Set<Roles> roles = user.getRoles();  
          
        for(Roles role : roles) {  
            Set<Resources> tempRes = role.getResources();  
            for(Resources res : tempRes) {  
                authSet.add(new SimpleGrantedAuthority(res.getRoleName()));  
           }  
        }  
        return authSet;  
    }

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}  
}

package com.piggsoft.comms.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.piggsoft.comms.security.model.Resources;
import com.piggsoft.comms.security.model.RoleResourcesDao;

/**
 * 加载资源与权限的对应关系
 * 
 * @author wh1304004
 * 
 */
public class PiggsoftSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private RoleResourcesDao roleResourcesDao;
	
	private static Map<RequestMatcher, Collection<ConfigAttribute>> roleResourceMap = null;
	
	public void init() {
		loadResourceDefine();
	}
	
	// 加载所有资源与权限的关系
	private void loadResourceDefine() {
		if (roleResourceMap == null) {
			roleResourceMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
			List<Resources> resources = this.roleResourcesDao.findAll();
			for (Resources resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				// 以权限名封装为Spring的security Object
				ConfigAttribute configAttribute = new SecurityConfig(
						resource.getRoleName());
				configAttributes.add(configAttribute);
				RequestMatcher matcher = new AntPathRequestMatcher(resource.getUrl());
				roleResourceMap.put(matcher, configAttributes);
			}
		}
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : roleResourceMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
        return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : roleResourceMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        return allAttributes;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void setRoleResourcesDao(RoleResourcesDao roleResourcesDao) {
		this.roleResourcesDao = roleResourcesDao;
	}

}

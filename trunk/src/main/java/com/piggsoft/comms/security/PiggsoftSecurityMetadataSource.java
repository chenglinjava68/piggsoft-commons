package com.piggsoft.comms.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/**
 * 加载资源与权限的对应关系
 * @author wh1304004
 *
 */
public class PiggsoftSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	 //由spring调用  
    public PiggsoftSecurityMetadataSource(ResourcesDao resourcesDao) {  
        this.resourcesDao = resourcesDao;  
        loadResourceDefine();  
    }  
  
    private ResourcesDao resourcesDao; 
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
    
  //加载所有资源与权限的关系  
    private void loadResourceDefine() {  
        if(resourceMap == null) {  
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
            List<Resources> resources = this.resourcesDao.findAll();  
            for (Resources resource : resources) {  
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();  
                                //以权限名封装为Spring的security Object  
                ConfigAttribute configAttribute = new SecurityConfig(resource.getName());  
                configAttributes.add(configAttribute);  
                resourceMap.put(resource.getUrl(), configAttributes);  
            }  
        }  
    }

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();  
        if(resourceMap == null) {  
            loadResourceDefine();  
        }  
        return resourceMap.get(requestUrl); 
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}

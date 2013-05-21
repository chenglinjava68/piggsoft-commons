/**
 * 
 */
package com.piggsoft.comms.mybatis.dialect;

/**
 * @author piggsoft
 * @date 2013-5-19 下午1:05:19
 */
public abstract class Dialect {  
	  
    public static enum Type{  
        MYSQL,  
        ORACLE  
    }  
      
    public abstract String getLimitString(String sql, int skipResults, int maxResults);  
      
}  

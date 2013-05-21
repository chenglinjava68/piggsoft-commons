package com.piggsoft.comms.mybatis.plugin.helper;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-21
 * @version 1.0
 */
public class BoundSqlSqlSource implements SqlSource{
	BoundSql boundSql;
	
	public BoundSqlSqlSource(BoundSql boundSql) {  
	    this.boundSql = boundSql;  
	}  
	
	@Override
	public BoundSql getBoundSql(Object parameterObject) {  
	    return boundSql;  
	}
}

package com.piggsoft.comms.mybatis.plugin.helper;

import com.piggsoft.comms.mybatis.dialect.Dialect;
import com.piggsoft.comms.mybatis.dialect.MySql5Dialect;
import com.piggsoft.comms.mybatis.dialect.OracleDialect;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-21
 * @version 1.0
 */
public class DialectHelper {
	/**
	 * 获得数据库方言
	 * @param dialectStr
	 * @return Dialect
	 */
	public static Dialect getDialect(String dialectStr) {
		Dialect.Type databaseType = Dialect.Type.valueOf(dialectStr.toUpperCase());
		Dialect dialect = null;
		switch(databaseType){
		case MYSQL:
			dialect = new MySql5Dialect();
			break;  	
		case ORACLE:  
			dialect = new OracleDialect();
			break;
		}
		if (dialect == null) {
			throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : " + dialectStr);
		}
		return dialect;
	}
}

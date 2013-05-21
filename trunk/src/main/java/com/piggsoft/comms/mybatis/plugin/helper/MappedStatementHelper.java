package com.piggsoft.comms.mybatis.plugin.helper;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.mapping.MappedStatement.Builder;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-21
 * @version 1.0
 */
public class MappedStatementHelper {
	public static MappedStatement copyFromMappedStatement(MappedStatement ms,   
	   		 SqlSource newSqlSource) {   
		Builder builder = new MappedStatement.Builder(ms.getConfiguration(),   
		ms.getId(), newSqlSource, ms.getSqlCommandType());   
		builder.resource(ms.getResource());   
		builder.fetchSize(ms.getFetchSize());   
		builder.statementType(ms.getStatementType());   
		builder.keyGenerator(ms.getKeyGenerator());   
		builder.keyProperty(StringUtils.join(ms.getKeyProperties(), ","));   
		builder.timeout(ms.getTimeout());   
		builder.parameterMap(ms.getParameterMap());   
		builder.resultMaps(ms.getResultMaps());   
		builder.cache(ms.getCache());   
		MappedStatement newMs = builder.build();   
		return newMs;   
	}   

}

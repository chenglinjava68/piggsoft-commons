package com.piggsoft.comms.mybatis.plugin.helper;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.RowBounds;

import com.piggsoft.comms.mybatis.dialect.Dialect;
import com.piggsoft.comms.mybatis.page.AbstactPageObject;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-21
 * @version 1.0
 */
public class InvocationHelper {
	/**
	 * 对invocation的参数进行重新定义
	 * @param invocation
	 * @param page
	 * @param dialect
	 */
	public static void processInvocationArgs(Invocation invocation, AbstactPageObject page, Dialect dialect) {
		MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
		BoundSql boundSql = mappedStatement.getBoundSql(page.getParameterObject()); 
		String originalSql = boundSql.getSql().trim();
		String pagesql = dialect.getLimitString(originalSql, page.getOffset(), page.getLimit());
		BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), pagesql, boundSql.getParameterMappings(), page.getParameterObject());   
		MappedStatement newMs = MappedStatementHelper.copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));  
		invocation.getArgs()[0]= newMs;
		invocation.getArgs()[1]= page.getParameterObject();
		invocation.getArgs()[2] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);   
	}
}

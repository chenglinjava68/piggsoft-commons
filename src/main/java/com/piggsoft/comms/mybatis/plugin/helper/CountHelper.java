package com.piggsoft.comms.mybatis.plugin.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;

import com.piggsoft.comms.mybatis.page.AbstactPageObject;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-21
 * @version 1.0
 */
public class CountHelper {
	/**
	 * 计算记录总数并存储在<tt>AbstactPageObject</tt>中
	 * @param configuration
	 * @param mappedStatement
	 * @param page
	 * @return
	 * @throws SQLException
	 */
	public static int getCount(Configuration configuration, MappedStatement mappedStatement, AbstactPageObject page) throws SQLException {
		int count = 0;
		BoundSql boundSql = mappedStatement.getBoundSql(page.getParameterObject()); 
		String originalSql = boundSql.getSql().trim();
		StringBuffer countSql  = new StringBuffer(originalSql.length()+100 );
		countSql.append("select count(1) from (").append(originalSql).append(") t");
		Connection connection = configuration.getEnvironment().getDataSource().getConnection();          
		PreparedStatement countStmt = connection.prepareStatement(countSql.toString());  
		BoundSql countBS = new BoundSql(configuration, countSql.toString(), boundSql.getParameterMappings(), page.getParameterObject());  
		DefaultPatameterHelper.setParameters(countStmt, mappedStatement, countBS, page.getParameterObject());  
		ResultSet rs = countStmt.executeQuery();  
		if (rs.next()) {
			count = rs.getInt(1);
		}  
		rs.close();  
		countStmt.close();  
		connection.close();
		page.setCount(count);
		return count;
	}
}

package com.piggsoft.comms.mybatis.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.piggsoft.comms.mybatis.dialect.Dialect;
import com.piggsoft.comms.mybatis.dialect.DialectFactory;
import com.piggsoft.comms.mybatis.page.AbstactPageObject;
import com.piggsoft.comms.mybatis.plugin.helper.CountHelper;
import com.piggsoft.comms.mybatis.plugin.helper.InvocationHelper;
import com.piggsoft.comms.utils.StringUtils;

@Intercepts({@Signature(type=Executor.class,method="query",args={MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PaginationInterceptor implements Interceptor{

   
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
    	Object parameter = invocation.getArgs()[1]; 
		
		if (!(parameter instanceof AbstactPageObject)) {
			return invocation.proceed();
		}
		
		AbstactPageObject page = (AbstactPageObject)parameter;
		
		BoundSql boundSql = mappedStatement.getBoundSql(page.getParameterObject()); 
		String originalSql = boundSql.getSql().trim();   
		
		if (StringUtils.isBlank(originalSql)) {
			return null;
		}
		
		//计算记录总数
		CountHelper.getCount(mappedStatement, page);
		
		//获得数据库方言
		Dialect dialect = DialectFactory.createDialect(mappedStatement.getConfiguration().getVariables().getProperty("dialect"));


		InvocationHelper.processInvocationArgs(invocation, page, dialect);
		
		return invocation.proceed();
    }
 

	@Override
    public Object plugin(Object target) {
       return Plugin.wrap(target, this);
    }

 

    @Override
    public void setProperties(Properties properties) {
    }

}
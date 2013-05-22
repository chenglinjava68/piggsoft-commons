package com.piggsoft.comms.mybatis.dialect;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-22
 * @version 1.0
 */
public class DialectFactoryTest {
	
	@Rule
	public ExpectedException expectedExption = ExpectedException.none();
	
	@Test
	public void testCreateDialectStringNull() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		expectedExption.expect(RuntimeException.class);
		expectedExption.expectMessage("please designation the dialect");
		DialectFactory.createDialect(null);
	}
	
	@Test
	public void testCreateDialectStringNotSupport() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		expectedExption.expect(RuntimeException.class);
		expectedExption.expectMessage("do not support this dialect");
		DialectFactory.createDialect("sqlserver");
	}
	/*配置文件正确的情况下不会出现
	@Test
	public void testCreateDialectClassNotFound() throws ClassNotFoundException {
		expectedExption.expect(ClassNotFoundException.class);
		DialectFactory.createDialect("adc");
	}
	*/
	@Test
	public void testCreateDialect() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Dialect dialect = DialectFactory.createDialect("mysql");
		System.out.println(dialect);
	}
}

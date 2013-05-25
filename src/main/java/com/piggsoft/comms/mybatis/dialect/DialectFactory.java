package com.piggsoft.comms.mybatis.dialect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.piggsoft.comms.utils.StringUtils;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-22
 * @version 1.0
 */
public class DialectFactory {
	
	private final static Logger logger = Logger.getLogger(DialectFactory.class.getName());
	
	private static final Properties props = new Properties();
	
	static {
		try {
			props.load(DialectFactory.class.getResourceAsStream("dialect.properties"));
			Properties custom = initCustom();
			if (custom != null && !custom.isEmpty()) {
				props.putAll(custom);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	private static Properties initCustom() {
		final Properties custom = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("dialect.properties");
			if (in == null) {
				return null;
			}
			custom.load(in);
		} catch (IOException e) {
			return null;
		}
		return custom;
	}
	
	public static Dialect createDialect(String dialectString) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if(StringUtils.isBlank(dialectString)) {
			throw new RuntimeException("please designation the dialect");
		}
		String className = props.getProperty(dialectString.toUpperCase());
		if (StringUtils.isBlank(className)) {
			throw new RuntimeException("do not support this dialect " + dialectString);
		}
		Dialect dialect = (Dialect)Class.forName(className).newInstance();
		return dialect;
	}
}

package com.piggsoft.comms.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.piggsoft.comms.mybatis.dialect.DialectFactory;

/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-5-25
 * @version 1.0
 */
public class ResourceReader {
	public static void read(Properties props, String resourceName) throws IOException {
		props.load(DialectFactory.class.getResourceAsStream(resourceName));
		Properties custom = initCustom(resourceName);
		if (custom != null && !custom.isEmpty()) {
			props.putAll(custom);
		}
	}
	
	private static Properties initCustom(String resourceName) {
		final Properties custom = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
			if (in == null) {
				return null;
			}
			custom.load(in);
		} catch (IOException e) {
			return null;
		}
		return custom;
	}
}

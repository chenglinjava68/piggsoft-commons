package com.piggsoft.comms.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-5-25
 * @version 1.0
 */
public class ResourceReader {
	/**
	 * 读取资源文件
	 * @param clazz 传入调用这个方法的<tt>Class</tt>,检查这个目录下是否有该配置文件
	 * @param props
	 * @param resourceName 所要读取的文件名
	 * @throws IOException
	 */
	public static void read(Class<?> clazz, Properties props, String resourceName) throws IOException {
		//props.load(DialectFactory.class.getResourceAsStream(resourceName));
		Properties defaultProps = initDefault(resourceName, clazz);
		if (defaultProps != null && !defaultProps.isEmpty()) {
			props.putAll(defaultProps);
		}
		Properties customProps = initCustom(resourceName);
		if (customProps != null && !customProps.isEmpty()) {
			props.putAll(customProps);
		}
	}
	
	private static Properties initDefault(String resourceName, Class<?> clazz) {
		final Properties defaultProps = new Properties();
		try {
			InputStream in = clazz.getResourceAsStream(resourceName);
			if (in == null) {
				return null;
			}
			defaultProps.load(in);
		} catch (IOException e) {
			return null;
		}
		return defaultProps;
	}
	
	private static Properties initCustom(String resourceName) {
		final Properties customProps = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
			if (in == null) {
				return null;
			}
			customProps.load(in);
		} catch (IOException e) {
			return null;
		}
		return customProps;
	}
}

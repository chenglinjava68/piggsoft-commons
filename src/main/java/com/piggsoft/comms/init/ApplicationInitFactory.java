package com.piggsoft.comms.init;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-4-21
 * @version 1.0
 */
public class ApplicationInitFactory {
	protected static final Properties props = new Properties();
	
	
	public final static void init(String location) {
		try {
			props.load(new FileReader(location));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

	public final static String get(String key){
		return props.getProperty(key);
	}
}

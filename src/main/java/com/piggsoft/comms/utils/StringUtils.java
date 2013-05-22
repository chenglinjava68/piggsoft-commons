package com.piggsoft.comms.utils;
/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-22
 * @version 1.0
 */
public final class StringUtils {
	public static boolean isNotBlank(String s) {
		if (isNotEmpty(s) && !s.trim().equals("")) {
			return true;
		} 
		return false;
	}
	
	public static boolean isNotEmpty(String s) {
		if (s == null) {
			return false;
		} else if(s.equals("")) {
			return false;
		}
		return true;
	}

	public static boolean isBlank(String s) {
		return !isNotBlank(s);
	}
	
	public static boolean isEmpty(String s) {
		return !isNotEmpty(s);
	}
}

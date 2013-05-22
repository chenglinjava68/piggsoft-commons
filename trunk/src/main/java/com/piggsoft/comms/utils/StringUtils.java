package com.piggsoft.comms.utils;
/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-22
 * @version 1.0
 */
public final class StringUtils {
	public static boolean isNotBlank(String str) {
		 return !StringUtils.isBlank(str);
	}
	
	public static boolean isNotEmpty(String str) {
		 return !StringUtils.isEmpty(str);
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
		    return true;
		}
		for (int i = 0; i < strLen; i++) {
		    if ((Character.isWhitespace(str.charAt(i)) == false)) {
		        return false;
		    }
		}
		return true;
	}
	
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	public static String trim(String str) {
        return str == null ? null : str.trim();
    }
}

package com.piggsoft.comms.utils;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-22
 * @version 1.0
 */
public class StringUtilsTest {
	@Test
	public void testIsNotEmpty() {
		String s = null;
		assertFalse("StringUtils isNotEmpty for null is not work", StringUtils.isNotEmpty(s));
		s = "";
		assertFalse("StringUtils isNotEmpty for '' is not work", StringUtils.isNotEmpty(s));
	}
	
	@Test
	public void testIsEmpty() {
		String s = null;
		assertTrue("StringUtils isEmpty for null is not work", StringUtils.isEmpty(s));
		s = "";
		assertTrue("StringUtils isEmpty for '' is not work", StringUtils.isEmpty(s));
	}
	
	@Test
	public void testIsNotBlank() {
		String s = null;
		assertFalse("StringUtils isNotBlank for null is not work", StringUtils.isNotBlank(s));
		s = "";
		assertFalse("StringUtils isNotBlank for '' is not work", StringUtils.isNotBlank(s));
		s = "  ";
		assertFalse("StringUtils isNotBlank for '  ' is not work", StringUtils.isNotBlank(s));
	}
	
	@Test
	public void testIsBlank() {
		String s = null;
		assertTrue("StringUtils isBlank for null is not work", StringUtils.isBlank(s));
		s = "";
		assertTrue("StringUtils isBlank for '' is not work", StringUtils.isBlank(s));
		s = "  ";
		assertTrue("StringUtils isBlank for '  ' is not work", StringUtils.isBlank(s));
	}
}

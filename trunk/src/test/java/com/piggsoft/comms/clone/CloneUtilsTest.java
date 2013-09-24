package com.piggsoft.comms.clone;


import org.junit.Test;


/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-5-25
 * @version 1.0
 */
public class CloneUtilsTest {
	@Test
	public void testDeepClone() throws CloneException {
		CloneDemo cd = new CloneDemo();
		CloneDemo cd2 = new CloneDemo();
		cd.setId(1);
		cd.setName("abd");
		cd2.setId(2);
		cd2.setName("asd");
		cd.setOther(cd2);
		System.out.println(System.currentTimeMillis());
		CloneDemo cdClone = CloneUtils.deepClone(cd);
		System.out.println(System.currentTimeMillis());
		System.out.println(cdClone.getId());
		System.out.println(cdClone.getName());
		System.out.println(cdClone.getOther().getId());
		cdClone.setId(2);
		System.out.println(cd.getId());
	}
	
	@Test
	public void testDeepCloneNoSerializ() throws CloneException {
		CloneDemoNoSerialize cd = new CloneDemoNoSerialize();
		CloneDemoNoSerialize cd2 = new CloneDemoNoSerialize();
		cd.setId(1);
		cd.setName("abd");
		cd2.setId(2);
		cd2.setName("asd");
		cd.setOther(cd2);
		System.out.println(System.currentTimeMillis());
		CloneDemoNoSerialize cdClone = CloneUtils.deepClone(cd);
		System.out.println(System.currentTimeMillis());
		System.out.println(cdClone.getId());
		System.out.println(cdClone.getName());
		System.out.println(cdClone.getOther().getId());
		cdClone.setId(2);
		System.out.println(cd.getId());
	}
}

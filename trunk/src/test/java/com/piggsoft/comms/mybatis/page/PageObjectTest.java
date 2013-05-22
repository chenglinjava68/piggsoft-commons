package com.piggsoft.comms.mybatis.page;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-22
 * @version 1.0
 */
public class PageObjectTest {
	@Test
	public void testOffset(){
		PageObject page = new PageObject(100, 10, 1);
		assertEquals(0, page.getOffset());
		page = new PageObject(100, 1);
		assertEquals(0, page.getOffset());
		page = new PageObject(1);
		assertEquals(0, page.getOffset());
	}
	
	@Test
	public void testLimit(){
		PageObject page = new PageObject(100, 10, 1);
		assertEquals(10, page.getLimit());
		page = new PageObject(10, 1);
		assertEquals(10, page.getLimit());
		page = new PageObject(1);
		assertEquals(10, page.getLimit());
	}
	
	@Test
	public void testCountRows() {
		PageObject page = new PageObject(1);
		page.initByCountRecords(100);
		assertEquals(100, page.getTotalRows());
	}
	
	@Test
	public void testHasNext() {
		PageObject page = new PageObject(1);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasNextPage());
		page = new PageObject(9);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasNextPage());
		page = new PageObject(0);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasNextPage());
		page = new PageObject(-1);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasNextPage());
		page = new PageObject(10);
		page.initByCountRecords(100);
		assertEquals(false, page.isHasNextPage());
		page = new PageObject(11);
		page.initByCountRecords(100);
		assertEquals(false, page.isHasNextPage());
	}
	
	@Test
	public void testHasPrevious() {
		PageObject page = new PageObject(1);
		page.initByCountRecords(100);
		assertEquals(false, page.isHasPreviousPage());
		page = new PageObject(-1);
		page.initByCountRecords(100);
		assertEquals(false, page.isHasPreviousPage());
		page = new PageObject(0);
		page.initByCountRecords(100);
		assertEquals(false, page.isHasPreviousPage());
		page = new PageObject(5);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasPreviousPage());
		page = new PageObject(9);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasPreviousPage());
		page = new PageObject(10);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasPreviousPage());
		page = new PageObject(11);
		page.initByCountRecords(100);
		assertEquals(true, page.isHasPreviousPage());
	}
	
	@Test
	public void testCurrentPage() {
		PageObject page = new PageObject(1);
		page.initByCountRecords(100);
		assertEquals(1, page.getCurrentPage());
		page = new PageObject(0);
		page.initByCountRecords(100);
		assertEquals(1, page.getCurrentPage());
		page = new PageObject(-1);
		page.initByCountRecords(100);
		assertEquals(1, page.getCurrentPage());
		page = new PageObject(9);
		page.initByCountRecords(100);
		assertEquals(9, page.getCurrentPage());
		page = new PageObject(10);
		page.initByCountRecords(100);
		assertEquals(10, page.getCurrentPage());
		page = new PageObject(11);
		page.initByCountRecords(100);
		assertEquals(10, page.getCurrentPage());
		page = new PageObject(11);
		page.initByCountRecords(101);
		assertEquals(11, page.getCurrentPage());
	}
	
	@Test
	public void testTotalPages() {
		PageObject page = new PageObject();
		page.initByCountRecords(101);
		assertNotEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(100);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(99);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(98);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(97);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(96);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(95);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(94);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(93);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(92);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(91);
		assertEquals(10, page.getTotalPages());
		page = new PageObject();
		page.initByCountRecords(90);
		assertNotEquals(10, page.getTotalPages());
		
		page = new PageObject();
		page.initByCountRecords(0);
		assertEquals(0, page.getTotalPages());
	}
}

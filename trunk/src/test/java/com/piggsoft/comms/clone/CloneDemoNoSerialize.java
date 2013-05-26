package com.piggsoft.comms.clone;


/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-5-25
 * @version 1.0
 */
public class CloneDemoNoSerialize{
	
	
	private int id;
	private String name;
	private CloneDemoNoSerialize other;
	public CloneDemoNoSerialize getOther() {
		return other;
	}
	public void setOther(CloneDemoNoSerialize other) {
		this.other = other;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

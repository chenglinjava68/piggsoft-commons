package com.piggsoft.comms.clone;

import java.io.Serializable;

/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-5-25
 * @version 1.0
 */
public class CloneDemo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6312962524093445477L;
	
	private int id;
	private String name;
	private CloneDemo other;
	public CloneDemo getOther() {
		return other;
	}
	public void setOther(CloneDemo other) {
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

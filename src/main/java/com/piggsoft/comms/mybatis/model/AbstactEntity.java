package com.piggsoft.comms.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstactEntity<PK extends Serializable> implements Serializable, Identifyable<PK>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4785506213327168173L;

	protected String creator;
	protected Date createTime;
	protected String updator;
	protected Date updateTime;
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

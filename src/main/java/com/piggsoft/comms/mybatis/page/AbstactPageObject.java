package com.piggsoft.comms.mybatis.page;


/**
 * 可以自己继承该类
 * @author CharChen
 * @e-mail piggsoft@163.com
 * @since 2013-5-19
 * @version 1.0
 */
public abstract class AbstactPageObject{
	
	protected int offset;
	
	protected int limit;
	
	protected int count;
	
	private Object parameterObject;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Object getParameterObject() {
		return parameterObject;
	}

	public void setParameterObject(Object parameterObject) {
		this.parameterObject = parameterObject;
	}
	
	/**
	 * 通过总记录数对AbstactPageObject进行初始化
	 * @param count 总记录数
	 */
	public abstract void initByCountRecords(int count);
}

package com.piggsoft.comms.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-4-21
 * @version 1.0
 * Tag 的共同基类
 */
public abstract class AbstractTag extends SimpleTagSupport{
	protected static final String TAG_END = "/>";
	
	/**
	 * 页面的context
	 */
	private PageContext pageContext;
	
	protected JspContext jspContext;
	
	/**
	 * 
	 * @param name 属性名 like src | href | action 
	 * @param value 属性的值
	 * @return 返回拼接的字符串
	 */
	protected String getHtmlString(String name, String value) {
		return name + "=\"" + value + "\" ";
	}
	
	protected void appendHtmlString(StringBuilder sb, String name, String value) {
		if(StringUtils.isNotEmpty(value)) {
			sb.append(getHtmlString(name, value));
		}
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		jspContext = getJspContext();
		pageContext = (PageContext)jspContext;
		StringBuilder sb = new StringBuilder();
		sb.append(getTagStart());
		invoke(sb);
		if(StringUtils.isEmpty(getTagEnd()))
			sb.append(TAG_END);
		else 
			sb.append(getTagEnd());
		write(sb.toString());
	}
	
	protected String getServletContextPath(){
		return pageContext.getServletContext().getContextPath();
	}
	
	protected String getServletContextPathWithFile(String filePath){
		return pageContext.getServletContext().getContextPath() + filePath;
	}
	
	protected String getFullPath(){
		return pageContext.getServletContext().getContextPath() + getPath();
	}
	
	public void write(String s) throws IOException{
		if (StringUtils.isNotEmpty(s))
			jspContext.getOut().write(s);
	}
	
	/**
	 * 子类必须实现的方法,在方法中像sb里面添加所要的字符串
	 * @param sb
	 * @throws IOException
	 * @throws JspException
	 */
	public abstract void invoke(StringBuilder sb) throws IOException, JspException;
	
	/**
	 * 
	 * @return 像img之类的标签对应的文件名 并且在两端加上 "/"
	 */
	public abstract String getPath();
	
	/**
	 * 
	 * @return 标签开始的字符串
	 */
	public abstract String getTagStart();
	
	public abstract String getTagEnd();
}

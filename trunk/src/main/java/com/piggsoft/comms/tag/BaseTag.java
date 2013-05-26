package com.piggsoft.comms.tag;


import org.apache.commons.lang.StringUtils;

/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-4-20
 * @version 1.0
 */
public abstract class BaseTag extends AbstractTag{
	
	protected String className;
	
	protected String name;
	
	protected String id;
	
	protected String onblur;
	
	protected String onchange;
	
	protected String onclick;
	
	protected String ondblclick;
	
	protected String onfocus;
	
	protected String onhelp;
	
	protected String onkeydown;
	
	protected String onkeyup;
	
	protected String onkeypress;
	
	protected String onmousedown;
	
	protected String onmouseup;
	
	protected String onmousemove;
	
	protected String onmouseout;
	
	protected String onmouseover;
	

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return ondblclick;
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnfocus() {
		return onfocus;
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	public String getOnhelp() {
		return onhelp;
	}

	public void setOnhelp(String onhelp) {
		this.onhelp = onhelp;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeyup() {
		return onkeyup;
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnkeypress() {
		return onkeypress;
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmouseup() {
		return onmouseup;
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public String getOnmousemove() {
		return onmousemove;
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return onmouseout;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		return onmouseover;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}
	
	public void addEvent(StringBuilder sb) {
		if (StringUtils.isNotEmpty(onblur))
			sb.append(getHtmlString("onblur", onblur));
		
		if (StringUtils.isNotEmpty(onchange))
			sb.append(getHtmlString("onchange", onchange));
		
		if (StringUtils.isNotEmpty(onclick))
			sb.append(getHtmlString("onclick", onclick));
		
		if (StringUtils.isNotEmpty(ondblclick))
			sb.append(getHtmlString("ondblclick", ondblclick));
		
		if (StringUtils.isNotEmpty(onfocus))
			sb.append(getHtmlString("onfocus", onfocus));
		
		if (StringUtils.isNotEmpty(onhelp))
			sb.append(getHtmlString("onhelp", onhelp));
		
		if (StringUtils.isNotEmpty(onkeydown))
			sb.append(getHtmlString("onkeydown", onkeydown));
		
		if (StringUtils.isNotEmpty(onkeyup))
			sb.append(getHtmlString("onkeyup", onkeyup));
		
		if (StringUtils.isNotEmpty(onkeypress))
			sb.append(getHtmlString("onkeypress", onkeypress));
		
		if (StringUtils.isNotEmpty(onmousedown))
			sb.append(getHtmlString("onmousedown", onmousedown));
		
		if (StringUtils.isNotEmpty(onmouseup))
			sb.append(getHtmlString("onmouseup", onmouseup));
		
		if (StringUtils.isNotEmpty(onmousemove))
			sb.append(getHtmlString("onmousemove", onmousemove));
		
		if (StringUtils.isNotEmpty(onmouseout))
			sb.append(getHtmlString("onmouseout", onmouseout));
		
		if (StringUtils.isNotEmpty(onmouseover))
			sb.append(getHtmlString("onmouseover", onmouseover));
	}
}

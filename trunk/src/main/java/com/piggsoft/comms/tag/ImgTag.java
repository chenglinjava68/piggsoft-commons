package com.piggsoft.comms.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.piggsoft.comms.init.ApplicationInitFactory;


/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-4-20
 * @version 1.0
 */
public class ImgTag extends BaseTag{
	
	private String src;
	
	private static final String IMG_PATH_NAME = ApplicationInitFactory.get("IMG_PATH_NAME");
	
	private static final String TAG_START = "<img ";

	@Override
	public void invoke(StringBuilder sb) throws IOException, JspException{
		sb.append(getHtmlString("src", getFullPath() + src));
		addEvent(sb);
	}
	
	@Override
	public String getPath() {
		return IMG_PATH_NAME;
	}
	
	@Override
	public String getTagStart() {
		return TAG_START;
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String getTagEnd() {
		return null;
	}
	
}

package com.piggsoft.comms.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.piggsoft.comms.init.ApplicationInitFactory;


/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-4-21
 * @version 1.0
 */
public class ScriptTag extends AbstractTag{
	private static final String TAG_START = "<script type=\"text/javascript\" ";
	
	private static final String SCRIPT_PATH_NAME = ApplicationInitFactory.get("SCRIPT_PATH_NAME");
	
	private static final String TAG_END = "></script>";
	
	private String src;
	
	@Override
	public void invoke(StringBuilder sb) throws IOException, JspException {
		sb.append(getHtmlString("src", getFullPath() + src));
	}
	
	@Override
	public String getPath() {
		return SCRIPT_PATH_NAME;
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
		return TAG_END;
	}
	
}

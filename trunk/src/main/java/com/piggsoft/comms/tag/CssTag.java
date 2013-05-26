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
public class CssTag extends AbstractTag{
	private static final String TAG_START = "<link rel=\"stylesheet\" type=\"text/css\" ";
	
	private static final String CSS_PATH_NAME = ApplicationInitFactory.get("CSS_PATH_NAME");
	
	private static final String TAG_END = "></link>";
	
	private String href;
	
	private String media;
	
	@Override
	public void invoke(StringBuilder sb) throws IOException, JspException {
		sb.append(getHtmlString("href", getFullPath() + href));
		appendHtmlString(sb, "media", media);
	}

	@Override
	public String getPath() {
		return CSS_PATH_NAME;
	}

	@Override
	public String getTagStart() {
		return TAG_START;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String getTagEnd() {
		return TAG_END;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}
	
}

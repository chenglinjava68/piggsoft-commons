package com.piggsoft.comms.mail;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.piggsoft.comms.utils.StringUtils;

public class MailHelper {
	
	private JavaMailSender mailSender;
	
	public void sendSimpleMail(String from, String[] to, String[] cc, String suject, String text) {
		sendSimpleMail(from, to, cc, null, null, suject, text);
	}
	
	public void sendSimpleMail(String from, String to, String[] cc, String suject, String text) {
		sendSimpleMail(from, new String[]{to}, cc, suject, text);
	}
	
	public void sendSimpleMail(String from, String[] to, String cc, String suject, String text) {
		sendSimpleMail(from, to, new String[]{cc}, suject, text);
	}
	
	public void sendSimpleMail(String from, String to, String cc, String suject, String text) {
		sendSimpleMail(from, new String[]{to}, new String[]{cc}, suject, text);
	}
	
	/**
	 * 
	 * @param from
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param replyTo
	 * @param suject
	 * @param text
	 */
	public void sendSimpleMail(String from, String[] to, String[] cc, 
						String[] bcc, String replyTo, String suject, String text) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(from);
		mail.setTo(to);
		
		if (cc != null && cc.length > 0) {
			mail.setCc(cc);
		}
		if (bcc != null && bcc.length > 0) {
			mail.setBcc(bcc);
		}
		if (StringUtils.isEmpty(replyTo)) {
			mail.setReplyTo(replyTo);
		}
		
		mail.setText(text);
		mail.setSentDate(new Date());
		mailSender.send(mail);
	}
	
	public void sendHtmlMail(String from, String[] to, String[] cc, 
			String[] bcc, String replyTo, String suject, String text) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
		messageHelper.setFrom(from);
		messageHelper.setTo(to);
		
		if (cc != null && cc.length > 0) {
			messageHelper.setCc(cc);
		}
		if (bcc != null && bcc.length > 0) {
			messageHelper.setBcc(bcc);
		}
		if (StringUtils.isEmpty(replyTo)) {
			messageHelper.setReplyTo(replyTo);
		}
		
		messageHelper.setText(text);
		messageHelper.setSentDate(new Date());
		
		mailSender.send(mimeMessage);
	}
	
	public void sendAttachmentMail(String from, String[] to, String[] cc, 
			String[] bcc, String replyTo, String suject, String text, Map<String, String> imgItem,
			Map<String, String> attachmentItem) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
		messageHelper.setFrom(from);
		messageHelper.setTo(to);
		
		if (cc != null && cc.length > 0) {
			messageHelper.setCc(cc);
		}
		if (bcc != null && bcc.length > 0) {
			messageHelper.setBcc(bcc);
		}
		if (StringUtils.isEmpty(replyTo)) {
			messageHelper.setReplyTo(replyTo);
		}
		
		messageHelper.setText(text);
		messageHelper.setSentDate(new Date());
		
		for (Map.Entry<String, String> entry : imgItem.entrySet()) {
			messageHelper.addInline(entry.getKey(), new File(entry.getValue()));
		}
		
		for (Map.Entry<String, String> entry : attachmentItem.entrySet()) {
			messageHelper.addAttachment(entry.getKey(), new File(entry.getValue()));
		}
		
		mailSender.send(mimeMessage);
	}
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
}

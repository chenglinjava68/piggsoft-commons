package com.piggsoft.comms.utils;

public class DictionryHelper {
	
	public static final byte ENABLE = 01;
	
	public static final byte ACCOUNT_EXPIRED = 02;
	
	public static final byte CREDENTIALS_EXPIRED = 04;
	
	public static final byte ACCOUNT_LOCKED = 010;
	
	public static boolean isEnable(byte status) {
		return getStatus(status, ENABLE);
	}
	
	public static byte setEnable(byte status) {
		return setStatus(status, ENABLE);
	}
	
	public static boolean isAccountExpired(byte status) {
		return getStatus(status, ACCOUNT_EXPIRED);
	}
	
	public static byte setAccountExpired(byte status) {
		return setStatus(status, ACCOUNT_EXPIRED);
	}
	
	public static boolean isCredentialsExpired(byte status) {
		return getStatus(status, CREDENTIALS_EXPIRED);
	}
	
	public static byte setCredentialsExpired(byte status) {
		return setStatus(status, CREDENTIALS_EXPIRED);
	}
	
	public static boolean isAccountLocked(byte status) {
		return getStatus(status, ACCOUNT_LOCKED);
	}
	
	public static byte setAccountLocked(byte status) {
		return setStatus(status, ACCOUNT_LOCKED);
	}
	
	
	private static boolean getStatus(byte status, byte type) {
		switch (type) {
			case ENABLE:
				return (status & ENABLE) != 0;
			case ACCOUNT_EXPIRED:
				return (status & ACCOUNT_EXPIRED) != 0;
			case CREDENTIALS_EXPIRED:
				return (status & CREDENTIALS_EXPIRED) != 0;
			case ACCOUNT_LOCKED:
				return (status & ACCOUNT_LOCKED) != 0;
			default :
				return false;
		}
	}
	
	private static byte setStatus(byte status, byte type) {
		switch (type) {
			case ENABLE:
				return (byte) (status | ENABLE);
			case ACCOUNT_EXPIRED:
				return (byte) (status | ACCOUNT_EXPIRED);
			case CREDENTIALS_EXPIRED:
				return (byte) (status | CREDENTIALS_EXPIRED);
			case ACCOUNT_LOCKED:
				return (byte) (status | ACCOUNT_LOCKED);
			default :
				return status;
		}
	}
	
	public static void main(String[] args) {
		byte b = 07;
		System.out.println(isEnable(b));
		System.out.println(isAccountExpired(b));
	}
}

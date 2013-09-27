package com.piggsoft.comms.utils;

public final class ByteStateHelper {
	
	/**
	 * 一个字节的第一位
	 * <br>值为:{@value}
	 */
	public static final int FIRST_BIT = 0x1;
	/**
	 * 一个字节的第二位
	 * <br>值为:{@value}
	 */
	public static final int SECOND_BIT = 0x2;
	/**
	 * 一个字节的第三位
	 * <br>值为:{@value}
	 */
	public static final int THIRD_BIT = 0x4;
	/**
	 * 一个字节的第四位
	 * <br>值为:{@value}
	 */
	public static final int FOURTH_BIT = 0x8;
	/**
	 * 一个字节的第五位
	 * <br>值为:{@value}
	 */
	public static final int FIFTH_BIT = 0x10;
	/**
	 * 一个字节的第六位
	 * <br>值为:{@value}
	 */
	public static final int SIXTH_BIT = 0x20;
	/**
	 * 一个字节的第七位
	 * <br>值为:{@value}
	 */
	public static final int SEVENTH_BIT = 0x40;
	/**
	 * 一个字节的第八位
	 * <br>值为:{@value}
	 */
	public static final int EIGHTH_BIT = 0x80;
	
	/**
	 * 
	 * @param status 所要取状态的本身
	  * @param type &nbsp;{@link ByteStateHelper#FIRST_BIT}&nbsp;&nbsp;{@link ByteStateHelper#SECOND_BIT}
	 * 				<br>{@link ByteStateHelper#THIRD_BIT}&nbsp;&nbsp;{@link ByteStateHelper#FOURTH_BIT}
	 * 				<br>{@link ByteStateHelper#FIFTH_BIT}&nbsp;&nbsp;{@link ByteStateHelper#SIXTH_BIT}
	 * 				<br>{@link ByteStateHelper#SEVENTH_BIT}&nbsp;&nbsp;{@link ByteStateHelper#EIGHTH_BIT}
	 * @return 返回要取得的状态，OK为1，KO为0
	 * <br>如果type值有误，返回-1
	 */
	public static final int getStatus(int status, int type) {
		if (!validateType(type)) {
			return -1;
		}
		return (status & type) == 0 ? 0 : 1;
	}
	
	private static boolean validateType(int type) {
		boolean result = true;
		switch (type) {
		case FIRST_BIT:
			break;
		case SECOND_BIT:
			break;
		case THIRD_BIT:
			break;
		case FOURTH_BIT:
			break;
		case FIFTH_BIT:
			break;
		case SIXTH_BIT:
			break;
		case SEVENTH_BIT:
			break;
		case EIGHTH_BIT:
			break;
		default:
			result = false;
		}
		return result;
	}
	
	/**
	 * 
	 * @param status 所要设置的状态值
	 * @param type &nbsp;{@link ByteStateHelper#FIRST_BIT}&nbsp;&nbsp;{@link ByteStateHelper#SECOND_BIT}
	 * 				<br>{@link ByteStateHelper#THIRD_BIT}&nbsp;&nbsp;{@link ByteStateHelper#FOURTH_BIT}
	 * 				<br>{@link ByteStateHelper#FIFTH_BIT}&nbsp;&nbsp;{@link ByteStateHelper#SIXTH_BIT}
	 * 				<br>{@link ByteStateHelper#SEVENTH_BIT}&nbsp;&nbsp;{@link ByteStateHelper#EIGHTH_BIT}
	 * @param flag 在该位上设置为0还是1，如果是1传true，如果是0传false
	 * @return 返回设置后的status 
	 * 	<br>如果type值有误，返回-1
	 */
	public static int setStatus(int status, int type, boolean flag) {
		if (!validateType(type)) {
			return -1;
		}
		int result = 0;
		if (flag) {
			result = status | type;
		} else {
			result = status & (~type);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(setStatus(1, FIRST_BIT, false));
	}
}

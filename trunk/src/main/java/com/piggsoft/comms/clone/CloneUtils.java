package com.piggsoft.comms.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author piggsoft
 * @e-mail piggsoft@163.com
 * @since 2013-5-25
 * @version 1.0
 */
public class CloneUtils {
	@SuppressWarnings("unchecked")
	public static <T> T deepClone(T t) throws CloneException {
		if (!(t instanceof Serializable)) {
			return reflectDeeoClone(t);
		}
		ByteArrayOutputStream byteOut = null;
		ObjectOutputStream objOut = null;
		ByteArrayInputStream byteIn = null;
		ObjectInputStream objIn = null;

		try {
			byteOut = new ByteArrayOutputStream();
			objOut = new ObjectOutputStream(byteOut);
			objOut.writeObject(t);

			byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			objIn = new ObjectInputStream(byteIn);

			return (T)objIn.readObject();
		} catch (Exception e) {
			throw new CloneException(e);
		} finally {
			try {
				byteIn = null;
				byteOut = null;
				if (objOut != null) {
					objOut.close();
				}
				if (objIn != null) {
					objIn.close();
				}
			} catch (IOException e) {
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> T reflectDeeoClone(T t) throws CloneException {
		try{
			return (T)BeanUtils.cloneBean(t);
		} catch (Exception e) {
			throw new CloneException(e);
		}
	}
}

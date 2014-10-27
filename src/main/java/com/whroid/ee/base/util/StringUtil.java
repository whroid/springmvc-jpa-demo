package com.whroid.ee.base.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Random;

public class StringUtil {
	
	final private static String randomSource = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	final private static Charset charset = Charset.forName("UTF-8");	
	
	public static boolean isEmpty(String s) {
		return (s == null || s.length() == 0);
	}
	
	public static String GenerateRandomKey(int length) {
		
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < length; i ++){
			int number = random.nextInt(62);
			sb.append(randomSource.charAt(number));
		}
		//System.out.
		return sb.toString();
	}
	
	public static byte[] encode(String str) {
		if (isEmpty(str)) {
			return null;
		}
		ByteBuffer buffer = charset.encode(str);
		return buffer.array();
	}
	
	public static String decode(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		return charset.decode(buffer).toString();
	}

}

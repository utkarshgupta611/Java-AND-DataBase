package com.ust.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MyPasswordHandler {

	public static String decrypt(String strData) {
		String decrValue = "";
		byte[] keyValue = new byte[]
				{'T','o','p','S','e','c','r','e','t','K','e','y','1','2','3','4'};
		Key key = new SecretKeySpec(keyValue, "AES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decrBytes = new BASE64Decoder().decodeBuffer(strData);
			byte[] decrArr = cipher.doFinal(decrBytes);
			decrValue = new String(decrArr);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}		
		return decrValue;
	}

	public static String encrypt(String strData) {
		String encrValue="";
		try {
			// 1. Create key
			byte[] keyValue = new byte[]
					{'T','o','p','S','e','c','r','e','t','K','e','y','1','2','3','4'};
			// using AES allows 16, 24, 32
			Key key = new SecretKeySpec(keyValue, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encrBytes = cipher.doFinal(strData.getBytes());
			encrValue = new BASE64Encoder().encode(encrBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return encrValue;
	}

	public static void main(String[] args) {
		String pswd = "12345"; // your password here
		String encr = MyPasswordHandler.encrypt(pswd);
		System.out.println(encr); // copy the encrypted password
		String decr = MyPasswordHandler.decrypt(encr);
		System.out.println(decr); // confirm it is original password
	}
}

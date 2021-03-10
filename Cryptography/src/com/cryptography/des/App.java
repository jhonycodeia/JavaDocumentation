package com.cryptography.des;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class App {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String plainText = "This is a secret message!";
		
		//the private key is a 64 bits long sequence
		SecretKey key = KeyGenerator.getInstance("DES").generateKey();
		
		DataEncryptionStandard des = new DataEncryptionStandard();
		
		String cipherText = des.encrypt(plainText, key);
		
		System.out.println("Encrypted text: "+cipherText);
		
		System.out.println("Decrypte text: "+des.decrypt(cipherText, key));
	}
}

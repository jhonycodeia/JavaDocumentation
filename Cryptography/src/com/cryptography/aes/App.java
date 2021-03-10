package com.cryptography.aes;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class App {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String plainText = "This is a secret message let's encrypt it!";
		
		//the private key is a 64 bits long sequence
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();
		
		AdvancedEncryptionStandard aes = new AdvancedEncryptionStandard();
		
		String cipherText = aes.encrypt(plainText, key);
		
		System.out.println("Encrypted text: "+cipherText);
		
		System.out.println("Decrypte text: "+aes.decrypt(cipherText, key));
	}
}

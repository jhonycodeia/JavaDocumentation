package com.cryptography.vigenere;

public class App {

	public static void main(String[] args) {
		 
		VigenereCipher vigenereCipher = new VigenereCipher();
		String cipherText = vigenereCipher.encrypt("Cryptography is quite important in cryptocurrencies", "table");
	
		System.out.println("Cipher text: "+cipherText);
		
		String plainText = vigenereCipher.decrypt(cipherText, "table");
		System.out.println("Plain text is: "+plainText);
	}
}

package com.cryptography.crackcaesar;

public class CaesarCrack {

	//cracking the Caesar encryption algorithm with brute-force
	public void crack(String cipherText) {

		//we try all the possible key values so the size of the ALPHABET
		//thats why Caesar cipher is weak: 27 possible encryptions
		for(int key=0;key<Constants.ALPHABET.length();++key) {
			
			//reinitialize this to be an empty string
			String plainText = "";
			
			//we just have to make a simple Caesar decryption
			for (int i = 0; i < cipherText.length(); ++i) {
				char character = cipherText.charAt(i);
				int charIndex = Constants.ALPHABET.indexOf(character);
				int decryptedIndex = Math.floorMod(charIndex - key,Constants.ALPHABET.length());
				plainText = plainText + Constants.ALPHABET.charAt(decryptedIndex);
			}
			
			//print the actual decrypted string with the given key
			System.out.format("Cracking Caesar-cipher with %s key the result is: %s%n", key, plainText);
		}	
	}
}

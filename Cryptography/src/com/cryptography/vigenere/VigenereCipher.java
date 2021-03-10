package com.cryptography.vigenere;

public class VigenereCipher {

	public String encrypt(String plainText, String key) {
	
		//this is the text we want to encrypt
		plainText = plainText.toUpperCase();
		//we make the algorithm case insensitive
		key = key.toUpperCase();
		
		String cipherText = "";
		//it represents the index for the key
		int keyIndex = 0;

		//we have to consider all the characters in the plain_text
		for(int i=0;i<plainText.length();++i) {
			char c = plainText.charAt(i);
			//number of shifts = (index of the character in the alphabet + index of the character in the key)%26
			int index = Math.floorMod(Constants.ALPHABET.indexOf(c)+Constants.ALPHABET.indexOf(key.charAt(keyIndex)),Constants.ALPHABET.length());
			cipherText = cipherText + Constants.ALPHABET.charAt(index);
			//increment the key index because we consider the next letter in the key
			keyIndex++;
			//if we've considered the last letter of the key we start again
			if(keyIndex==key.length())
				keyIndex=0;
		}
		
		return cipherText;
	}
	
	// decryption is the same except now we use the following formula:
    //number of shifts = index of the character in the alphabet - index of the character in the key
	public String decrypt(String cipherText, String key) {
		
		cipherText = cipherText.toUpperCase();
		key = key.toUpperCase();
		
		String plainText = "";
		int keyIndex = 0;

		for(int i=0;i<cipherText.length();++i) {
			char c = cipherText.charAt(i);
			int index = Math.floorMod(Constants.ALPHABET.indexOf(c)-Constants.ALPHABET.indexOf(key.charAt(keyIndex)),Constants.ALPHABET.length());
			plainText = plainText + Constants.ALPHABET.charAt(index);
			keyIndex++;
			
			if(keyIndex==key.length())
				keyIndex=0;
		}
		
		return plainText;
	}
}

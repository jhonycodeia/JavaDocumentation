package com.cryptography.caesar;

public class CaesarCipher {

	//caesar encryption algorithm
	public String encrypt(String plainText) {

		//the encrypted message
		String cipherText = "";
		//we make the algorithm case insensitive
		plainText = plainText.toUpperCase();

		//consider all the letters in the plain_text
		for (int i = 0; i < plainText.length(); ++i) {
			char character = plainText.charAt(i);
			//find the numerical representation (index) associated with that character in the alphabet
			int charIndex = Constants.ALPHABET.indexOf(character);
			//caesar encryption is just a simple shift of characters according to the key
			//use modular arithmetic to transform the values within the range [0,num_of_letters_in_alphabet]
			int encryptedIndex = Math.floorMod(charIndex + Constants.KEY,Constants.ALPHABET.length());
			//keep appending the encrypted character to the cipher_text
			cipherText = cipherText + Constants.ALPHABET.charAt(encryptedIndex);
		}

		return cipherText;
	}

	//caesar decryption algorithm: basically the same but using -KEY in this case
	public String decrypt(String cipherText) {

		//the input cipherText is already upper case
		//cipherText = cipherText.toUpperCase();
		String plainText = "";

		for (int i = 0; i < cipherText.length(); ++i) {
			char character = cipherText.charAt(i);
			int charIndex = Constants.ALPHABET.indexOf(character);
			int decryptedIndex = Math.floorMod(charIndex - Constants.KEY,Constants.ALPHABET.length());
			plainText = plainText + Constants.ALPHABET.charAt(decryptedIndex);
		}

		return plainText;
	}
}

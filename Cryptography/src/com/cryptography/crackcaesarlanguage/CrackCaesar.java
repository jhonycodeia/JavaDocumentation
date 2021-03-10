package com.cryptography.crackcaesarlanguage;

public class CrackCaesar {
	
	private LanguageDetector languageDetector;

	public CrackCaesar() {
		this.languageDetector = new LanguageDetector();
	}

	//this is how we crack the cipher with frequency analysis
	public void crack(String cipherText) {
		

			//we try all the possible key values so the size of the ALPHABET
			//thats why Caesar cipher is weak: 26 possible encryptions
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
				if(languageDetector.isTextEnglish(plainText)) {
					System.out.println("Cracking caesar cipher brute-force with language detection! Key is: " + key);
					System.out.println(plainText);
					return;
				}
			}	
	}
}

package com.cryptography.crackcaesarfrequency;

import java.util.Map;

public class CrackCaesar {

	//we have to calculate the frequencies of the letters in the cipherText
	private FrequencyAnalysis frequencyAnalysis;

	public CrackCaesar() {
		this.frequencyAnalysis = new FrequencyAnalysis();
	}

	//this is how we crack the cipher with frequency analysis
	public void crackCaesar(String cipherText) {
		
		//a hashmap stores the character-frequency pairs
		Map<Character, Integer> letterFrequencies = frequencyAnalysis.analyze(cipherText);

		//a simple O(N) linear search to find the character with the maximum frequency
		Map.Entry<Character,Integer> maxEntry = null;

		for (Map.Entry<Character, Integer> entry : letterFrequencies.entrySet()) {
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
		        maxEntry = entry;
		    }
		}
		
		//we get the most frequent letter in the ciphertext
		char mostFrequentChar = maxEntry.getKey();
		// key ~ |most frequent letter in the cipher text - most frequent letter in English|
		// the most common letter is the whitespace: thats why we do not care about ' ' in this case
		int approximatedKey = Constants.ALPHABET.indexOf(mostFrequentChar)-Constants.ALPHABET.indexOf(' ');
		
		System.out.println("The key is: "+approximatedKey);
	}
}

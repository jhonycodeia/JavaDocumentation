package com.cryptography.crackcaesarfrequency;

import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalysis {

	//the method to do frequency analysis: we just count the occurrences of the given characters
	public Map<Character,Integer> analyze(String text) {
		
		//the text we analyze
		text = text.toUpperCase();
		
		//we use a dictionary to store the letter-frequency pair
		Map<Character,Integer> letterFrequencies = new HashMap<>();
		
		//initialize the dictionary (of course with 0 frequencies)
		for(int i=0;i<Constants.ALPHABET.length();++i)
			letterFrequencies.put(Constants.ALPHABET.charAt(i), 0);
		
		//let's consider the text we want to analyze
		for(int i=0;i<text.length();++i) {
			
			char c = text.charAt(i);
			
			//we keep incrementing the occurrence of the given letter if it is present in the ALPHABET
			if(Constants.ALPHABET.indexOf(c)!=-1)
				letterFrequencies.put(c, letterFrequencies.get(c)+1);
			
		}
		
		return letterFrequencies;
	}
}

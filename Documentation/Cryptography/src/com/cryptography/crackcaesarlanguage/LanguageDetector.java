package com.cryptography.crackcaesarlanguage;

import java.util.List;

public class LanguageDetector {

	private FileProcessor fileProcessor;
	private List<String> englishWords;
	
	public LanguageDetector() {
		this.fileProcessor = new FileProcessor();
		this.englishWords = fileProcessor.getEnglishWords();
	}
	
	private int countEnglishWordsInText(String text) {
		
		text = text.toUpperCase();
		
		String[] words = text.split(" ");
		
		int matches = 0;
		
		for(String word : words) {
			if(englishWords.contains(word))
				matches++;
		}
		
		return matches;
	}
	
	public boolean isTextEnglish(String text) {
		
		int matches = countEnglishWordsInText(text);
		
		if( ((float)matches / text.split(" ").length *100) >= 70)
			return true;
		
		return false;
	}
}

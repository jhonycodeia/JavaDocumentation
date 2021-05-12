package com.cryptography.languagedetect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

	private List<String> englishWords;
	
	public FileProcessor() {
		this.englishWords = new ArrayList<>();
		getData();
	}
	
	//let's load all the english words from a .txt file
	private void getData() {
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(new File("C:\\Users\\User\\Desktop\\english_words.txt"));
			bufferedReader = new BufferedReader(fileReader);
			
			String line = "";
			
			//initialize the ENGLISH_WORDS list with the words present in the file
			//every word is in a distinct line so that why we have to split('\n')
			while((line=bufferedReader.readLine())!=null) {
				englishWords.add(line.toUpperCase());
			}
			
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	public List<String> getEnglishWords() {
		return this.englishWords;
	}
}

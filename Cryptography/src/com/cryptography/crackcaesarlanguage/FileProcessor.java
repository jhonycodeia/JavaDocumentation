package com.cryptography.crackcaesarlanguage;

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
	
	private void getData() {
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(new File("C:\\Users\\User\\Desktop\\english_words.txt"));
			bufferedReader = new BufferedReader(fileReader);
			
			String line = "";
			
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

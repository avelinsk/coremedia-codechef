package com.coremedia.codekata.wordchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordChain {
	
	private String wordListFile;
	
	private Map<Integer, List<String>> wordLists = new HashMap<>();

	public static void main(String[] args) throws IOException {
		
		WordChain chain = new WordChain("/com/coremedia/codekata/wordchain/wordlist.txt");
		
		chain.initializeWordLists();
		
		chain.printHistogram();
		

	}
	
	public WordChain(String wordListFile) {
		this.wordListFile = wordListFile;
	}
	
	public List<String> findShortestWordChain(String from, String to) {
		return Collections.emptyList();
	}
	
	
	// === Handling Word Lists ===
	
	public void initializeWordLists() throws IOException {
		BufferedReader reader = getWordListReader();
		
		String word = reader.readLine();
		
		while (word!=null) {
			word = word.toLowerCase().trim();
			storeWord(word);
			word = reader.readLine();
			
		};
		
	}
	
	private void storeWord(String word) {
		List<String> wordList = wordLists.get(word.length());
		
		if (wordList==null) {
			wordList = new LinkedList<>();
			wordLists.put(word.length(), wordList);
		}
		
		wordList.add(word);
	}

	private BufferedReader getWordListReader() {
		InputStream is = getClass().getResourceAsStream(wordListFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		return reader;
	}
	
	private List<String> getWordList(int length) {
		return Collections.unmodifiableList(wordLists.get(length));
	}
	
	public void printHistogram() {
		List<Integer> lengths = new LinkedList<>(wordLists.keySet());
		Collections.sort(lengths);
		
		for (Integer i : lengths) {
			System.out.println(String.format("%d chars :  %d words", i, wordLists.get(i).size()));
		}
	}

}

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
	
	

	public static void main(String[] args) throws IOException {
		
		WordChain chain = new WordChain("/com/coremedia/codekata/wordchain/wordlist.txt");
		
		chain.initializeWordLists();
		
		chain.printHistogram();
		
		System.out.println("==================================");
		System.out.println("Finding WordChain 'mouse' -> 'cheese'");
		long time = System.currentTimeMillis();
		
		List<String> wordChain = chain.findShortestWordChain("mouse", "cheese");
		
		time = System.currentTimeMillis() - time;
		
		System.out.println(wordChain.size()==0 ? "No solution found" : wordChain);
		
		System.out.println("Time " + time + " ms");

		System.out.println("==================================");
		

	}
	
	
	
	// === CONSTRUCTOR ===
	
	public WordChain(String wordListFile) {
		this.wordListFile = wordListFile;
	}
	
	// === FINDING WORD CHAINS ===
	
	public List<String> findShortestWordChain(String from, String to) {
		Map<String, String> tree = new HashMap<>();
		
		tree.put(from, null);
		
		traverseTree(tree, Collections.singletonList(from), to);
		
		return getWordChain(tree, to);
	}
	
	private void traverseTree(Map<String, String> tree, List<String> parentStage, String stopWord) {
		System.out.println("[DEBUG] Words on stage: " + parentStage.size());
		List<String> nextStage = new LinkedList<>();
		for (String parent : parentStage) {
			List<String> similarWords = findSimilarWords(parent);
			for (String word : similarWords) {
				if (!tree.containsKey(word)) {
					tree.put(word, parent);
					nextStage.add(word);
					if (word.equals(stopWord)) {
						return;
					}
				}
			}
		}
		
		if (!nextStage.isEmpty()) {
			traverseTree(tree, nextStage, stopWord);
		}
	}
	
	private List<String> findSimilarWords(String word) {
		List<String> similarWords = new LinkedList<>();
		for (String w : getWordList(word.length())) {
			if (isSimilar(w, word)) {
				similarWords.add(w);
			}
		};
		for (String w : getWordList(word.length()-1)) {
			if (isSimilar(w, word)) {
				similarWords.add(w);
			}
		};
		for (String w : getWordList(word.length()+1)) {
			if (isSimilar(w, word)) {
				similarWords.add(w);
			}
		};
		return similarWords;
	}
	
	public boolean isSimilar(String a, String b) {
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		if (charA.length == charB.length) {
			int diff = 0;
			for (int i=0; i<a.length() && diff<=1; i++) {
				if (charA[i]!=charB[i]) {
					diff++;
				}
			}
			return diff == 1;
		}
		else if (Math.abs(charA.length - charB.length) == 1) {
			char[] longChars = (charA.length > charB.length) ? charA : charB;
			char[] shortChars = (charA.length > charB.length) ? charB : charA;
			int diff = 0;
			int l, s;
			for (l=0,s=0; l<longChars.length && s<shortChars.length && diff<=1; l++, s++) {
				if (longChars[l]!=shortChars[s]) {
					diff++;
					s--;
				}
			}
			return diff == 1;
		}
		return false;
	}
	
	private List<String> getWordChain(Map<String,String> tree, String endWord) {
		List<String> chain = new LinkedList<>();
		String word = endWord;
		while (word!=null) {
			chain.add(0, word);
			word = tree.get(word);
		}
		return chain;
	}
	
	// === HANDLING WORD LISTS ===
	
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
		List<String> list = wordLists.get(length);
		return (List<String>) (list==null ? Collections.emptyList() : Collections.unmodifiableList(list));
	}
	
	public void printHistogram() {
		List<Integer> lengths = new LinkedList<>(wordLists.keySet());
		Collections.sort(lengths);
		System.out.println("==============================");
		System.out.println("Histogram: ");
		for (Integer i : lengths) {
			System.out.println(String.format("  %2d chars :  %d words", i, wordLists.get(i).size()));
		}
	}

	// === ATTRIBUTES ===
	
	private String wordListFile;
	private Map<Integer, List<String>> wordLists = new HashMap<>();
}

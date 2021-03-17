package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	Map<String,Word> mappaWord;
	
	public AlienDictionary() {
		
    mappaWord = new HashMap<String,Word>();
	
	}
	
	public void addWord(String alienWord, String translation) {
		
		Word w = new Word(alienWord,translation);
		mappaWord.put(alienWord, w);
	}
	
	public String translateWord(String alienWord) {
	
		if(mappaWord.get(alienWord).getTranslation()!=null) {
			 return mappaWord.get(alienWord).getTranslation();
		 }else
		return null;
	
		
		/* 
		 for(Word w :mappaWord.values()) {
			 if(w.equals(alienWord)) {
				 return w.getTranslation();
			 }
		 }
		 return null;
		 */
	}


}

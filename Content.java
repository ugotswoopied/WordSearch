package gaweda.edward.project;

import java.io.BufferedReader;
import java.io.FileReader;

public class Content {
	
	String[] rows;
	String[] words;
	String wordsFile = "C:/Users/Edward/workspace/WordSearch/FrozenWords.txt";
	String file = "C:/Users/Edward/workspace/WordSearch/FrozenWordSearch.txt";
	
	public Content () throws Exception {
		
		this.rows = new String [Puzzle.ARRAY_SIZE];
		setRows(file);
		setWords(wordsFile);
	}
	
	private void setRows(String filename) throws Exception {
		String line;
		String text = "";
		
		// wrap a BufferedReader around FileReader
		BufferedReader bR = new BufferedReader(new FileReader(filename));

		// use the readLine method of the BufferedReader to read one line at a time.
		// the readLine method returns null when there is nothing else to read.
		while ((line = bR.readLine()) != null) {
			text += line + "\n";
			}
		
		// close the BufferedReader when we're done
			bR.close();
			rows = text.split("\n");
	}
	
	private void setWords(String filename) throws Exception {
		String line;
		String text = "";
		
		BufferedReader bR = new BufferedReader(new FileReader(filename));
		
		while ((line = bR.readLine()) != null) {
			text += line + "\n";
		}
		
		bR.close();
		words = text.split("\n");
	
	}
	
	public String[] getRows() {
		
		return this.rows;
	}
	
	public String[] getWords() {
		
		return this.words;
	}
	
}




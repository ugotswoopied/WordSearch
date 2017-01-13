package gaweda.edward.project;

public class Puzzle {
	
	public String[][] wordSearch;
	public String[] words;
	public static final int ARRAY_SIZE = 14;
	
	public Puzzle (Content words) {
		
		this.wordSearch = new String[ARRAY_SIZE][ARRAY_SIZE];
		this.words = words.getWords();
		String[] temp = words.getRows();
		for (int i = 0; i < temp.length; i++) {
			String wordInRow = (temp[i].toString());
			for (int j = 0; j < temp.length; j++) {
				this.wordSearch[i][j] = Character.toString(wordInRow.charAt(j)); 
			}
		}
	
	}
	
	
	/** Need to figure out logic for non-arg constructor later
	
	public Puzzle () {
		
		String[][] wordSearch
		
	}
	
	**/

	public String[][] getWordSearch() {
		
		return this.wordSearch;
	}
	
	@Override
	public String toString () {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("WORD SEARCH PUZZLE \n\n");
		
		for (int i = 0; i < wordSearch.length; i++) {
			for (int j = 0; j < wordSearch[i].length; j++) {
				sb.append(wordSearch[i][j] + "   ");
			}
			sb.append("\n\n");
		}
		String wordSearchPrint = sb.toString();
		return wordSearchPrint;
	}
	
}

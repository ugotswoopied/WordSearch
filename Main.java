package gaweda.edward.project;

public class Main {

	public static void main(String[] args) throws Exception {
	
		/**   This right now is just used for testing functionality. 
		 *    Eventual goal is to make this adaptable to full animation,
		 *    and an interface that allows users to choose different
		 *    word searches, find words, ask for words to be found etc.
		 */   
		
		
		Content words = new Content();
		Puzzle puzzle = new Puzzle(words);
		SortStrings sort = new SortStrings(puzzle);
		Search search = new Search(sort);
		System.out.println(puzzle.toString());
		search.searchDiag(puzzle.words[9]);
	
		System.out.println(puzzle.words[9]);
	}
}
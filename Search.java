package gaweda.edward.project;

import java.util.List;
import java.util.ArrayList;

public class Search {

	List<String[]> allStringsInPuzzle = new ArrayList<String[]>(); 
	
	public Search (SortStrings sort) {
		this.allStringsInPuzzle = sort.sortedStrings;
		
	}
	
	public void searchRows(String word) {
		
		String[] rows = allStringsInPuzzle.get(0);
		String[] backRows = allStringsInPuzzle.get(1);
		boolean found = false;
		
		while (found == false) {
		for (int i = 0; i < rows.length; i++) {
			if (rows[i].contains(word)) {
				int startLocation = rows[i].indexOf(word);
				int endLocation = rows[i].indexOf(word) + (word.length()-1);
				String locationCoords = i + "," + startLocation + " " + i + "," + endLocation;
				foundWord(locationCoords);
				found = true;
			}
			else if (backRows[i].contains(word)) {
				int startLocation = backRows[i].length()-1 - backRows[i].indexOf(word);
				int endLocation = startLocation - (word.length()-1);
				String locationCoords = i + "," + startLocation + " " + i + "," + endLocation;
				foundWord(locationCoords);
				found = true;
			}
		}
		break;
		}
	}
	public void searchCols(String word) {
		
		String[] cols = allStringsInPuzzle.get(2);
		String[] backCols = allStringsInPuzzle.get(3);
		
		boolean found = false;
		
		while (found == false) {
		for (int i = 0; i < cols.length; i++) {
			if (cols[i].contains(word)) {
				int startLocation = cols[i].indexOf(word);
				int endLocation = cols[i].indexOf(word) + (word.length()-1);
				String locationCoords = i + "," + startLocation + " " + i + "," + endLocation;
				foundWord(locationCoords);
				found = true;
			}
			else if (backCols[i].contains(word)) {
				int startLocation = backCols[i].length()-1 - backCols[i].indexOf(word);
				int endLocation = startLocation - (word.length()-1);
				String locationCoords = startLocation + "," + i + " " + endLocation + "," + i;
				foundWord(locationCoords);
				found = true;
			}
		}
		break;
		}
	}
	
	public void searchDiag(String word) {
		
		String[] leftDiag = allStringsInPuzzle.get(4);
		String[] backLeftDiag = allStringsInPuzzle.get(5);
		String[] rightDiag = allStringsInPuzzle.get(6);
		String[] backRightDiag = allStringsInPuzzle.get(7);
		
	boolean found = false;
		
		while (found == false) {
			int startLocationRow;
			int endLocationRow;
			int startLocationCol;
			int endLocationCol;
		for (int i = 0; i < leftDiag.length; i++) {
			if (leftDiag[i].contains(word)) {
				if (i < 14) {
					startLocationRow = i - leftDiag[i].indexOf(word);
					startLocationCol = leftDiag[i].indexOf(word);
					endLocationRow = startLocationRow - (word.length()-1);
					endLocationCol = startLocationCol + (word.length()-1);
				}
				else {
					startLocationRow = (Puzzle.ARRAY_SIZE-1) - leftDiag[i].indexOf(word);
					startLocationCol = (i - (Puzzle.ARRAY_SIZE-1)) + leftDiag[i].indexOf(word);
					endLocationRow = startLocationRow - (word.length()-1);
					endLocationCol = startLocationCol + (word.length()-1);
				}
				String locationCoords = startLocationRow + "," + startLocationCol + " " + endLocationCol + "," + endLocationRow;
				foundWord(locationCoords);
				found = true;
			}
			else if (backLeftDiag[i].contains(word)) {
				if (i < 14) {
					startLocationRow = backLeftDiag[i].indexOf(word);
					startLocationCol = i - backLeftDiag[i].indexOf(word);
					endLocationRow = startLocationRow + (word.length()-1);
					endLocationCol = startLocationCol - (word.length()-1);
				}
				else {
					startLocationRow = (i - (Puzzle.ARRAY_SIZE-1)) + backLeftDiag[i].indexOf(word);
					endLocationRow = startLocationRow + (word.length()-1);
					startLocationCol = (Puzzle.ARRAY_SIZE-1) - backLeftDiag[i].indexOf(word);
					endLocationCol = startLocationCol - (word.length()-1);
				}
				String locationCoords = startLocationRow + "," + startLocationCol + " " + endLocationRow + "," + endLocationCol;
				foundWord(locationCoords);
				found = true;
			}
		}

		for (int j = 0; j < rightDiag.length; j++) {
			if (rightDiag[j].contains(word)) {
				if (j < 14) {
					startLocationRow = j - rightDiag[j].indexOf(word);
					startLocationCol = (Puzzle.ARRAY_SIZE-1) - rightDiag[j].indexOf(word);
					endLocationRow = startLocationRow - (word.length()-1);
					endLocationCol = startLocationCol - (word.length()-1);
				}
				else {
					startLocationRow = (Puzzle.ARRAY_SIZE-1) - rightDiag[j].indexOf(word);
					endLocationRow = startLocationRow - (word.length()-1);
					startLocationCol = (rightDiag[j].length()-1) - (word.length()-1);
					endLocationCol = startLocationCol - (word.length()-1);
				}
				String locationCoords = startLocationRow + "," + startLocationCol + " " + endLocationRow + "," + endLocationCol;
				foundWord(locationCoords);
				found = true;
			}
			else if (backRightDiag[j].contains(word)) {
				if (j < 14) {
					startLocationRow = backRightDiag[j].indexOf(word);
					startLocationCol = ((Puzzle.ARRAY_SIZE-1) - j) + backRightDiag[j].indexOf(word);
					endLocationRow = startLocationRow + (word.length()-1);
					endLocationCol = startLocationCol + (word.length()-1);
				}
				else {
					startLocationRow = j - (Puzzle.ARRAY_SIZE-1) + backRightDiag[j].indexOf(word);
					startLocationCol = backRightDiag[j].indexOf(word);
					endLocationRow = startLocationRow + (word.length()-1);
					endLocationCol = startLocationCol + (word.length()-1);
				}
				String locationCoords = startLocationRow + "," + startLocationCol + " " + endLocationRow + "," + endLocationCol;
				foundWord(locationCoords);
				found = true;
			}
		}
		break; // force-ends loop if word is not located
			
		}
	}
	

	public void foundWord(String locationCoords) { //temp for testing
		System.out.println(locationCoords);
	}

}




















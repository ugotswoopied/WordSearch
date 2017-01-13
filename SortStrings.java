package gaweda.edward.project;

import java.util.List;
import java.util.ArrayList;

public class SortStrings {

	String[][] puzzleArray;
	List<String[]> sortedStrings = new ArrayList<String[]>();
	
	
	public SortStrings (Puzzle puzzle) {
		
		this.puzzleArray = puzzle.wordSearch;
		sortRows();
		sortCols();
		sortLeftDiag();
		sortRightDiag();
	}
	
	public void sortRows() {
		
		String[] rows = new String[Puzzle.ARRAY_SIZE];
		for (int z = 0; z < Puzzle.ARRAY_SIZE; z++) {
				rows[z] = "";
		}
		
		for (int i = 0; i < Puzzle.ARRAY_SIZE; i++) {
			for (int j = 0; j < Puzzle.ARRAY_SIZE; j++) {
				rows[i] += puzzleArray[i][j];
			}
		}
		
		sortedStrings.add(rows);
		sortBackRows(rows);
	}
	
	public void sortBackRows(String[] rows) {
		
		String[] backRows = new String[Puzzle.ARRAY_SIZE];
		
		for (int i = 0 ; i < rows.length ; i++)   //creates a backwards string for each row, stored in backRows[]
		{
			backRows[i] = new StringBuilder(rows[i]).reverse().toString();
		}
		
		sortedStrings.add(backRows);
	}
	
	public void sortCols() {
		
		String[] cols = new String[Puzzle.ARRAY_SIZE];
		
		for (int z = 0; z < Puzzle.ARRAY_SIZE; z++) {
			cols[z] = "";
		}
		
		for (int i = 0; i < Puzzle.ARRAY_SIZE; i++) {
			for (int j = 0; j < Puzzle.ARRAY_SIZE; j++) {
				cols[i] += puzzleArray[j][i];
			}
		}
		
		sortedStrings.add(cols);
		sortBackCols(cols);
	}
	
	public void sortBackCols(String[] cols) {
		
		String[] backCols = new String[Puzzle.ARRAY_SIZE];
		
		for (int i = 0 ; i < cols.length ; i++)   //creates a backwards string for each row, stored in backRows[]
		{
			backCols[i] = new StringBuilder(cols[i]).reverse().toString();
		}
		
		sortedStrings.add(backCols);
	}
	
	public void sortLeftDiag() {
		
		String[] leftDiag = new String[(Puzzle.ARRAY_SIZE*2)-1];
		
		for (int g = 0; g < leftDiag.length; g++) { //removes null
			leftDiag[g] = "";
		}
		
		for (int i = 0; i < Puzzle.ARRAY_SIZE*2-1; i++) { //27 total strings, iterates through each
			for (int j = 0; j <Puzzle.ARRAY_SIZE; j++) { 	// 14 total subscripts, iterates through
				int k = i-j; // [x][y] x-y constant determines how many times x-1, y+1 must be performed                            
				if (k == 0 && i == 0) {   // 0,0
					leftDiag[i] += puzzleArray[i][j];
				}
				else if (k == 0 && i == (Puzzle.ARRAY_SIZE)-1) {  // 13,13
 					leftDiag[(Puzzle.ARRAY_SIZE*2)-2] += puzzleArray[i][j];
				}
				else if (k > 0 && k == i && i < Puzzle.ARRAY_SIZE) { // represents column 0, rows 0-13 where first 14 strings begin 
					int a = i;
					int b = j;
					for (int l = 0; l <= i; l++) { // perform "x" times: x-1, y+1 
						leftDiag[i] += puzzleArray[a][b];
						a--;
						b++;
					}
				}	
				else if (i > (Puzzle.ARRAY_SIZE)-1 && k == (Puzzle.ARRAY_SIZE)-1 && j > 0 && i < (leftDiag.length)-1) { // represents row 13, columns 1-13, where latter 13 strings begin
					int c = (Puzzle.ARRAY_SIZE)-1; // value of "i" used to increment safely - while array is being iterated beyond 13 to create all diagonal strings 
					int d = j;  // value of j used to increment safely
					int e = j;
					int f = (Puzzle.ARRAY_SIZE-1)-e; // constant representing x-y for row 13
					for (int m = 0; m <= f; m++) { // perform "x-y" times: x-1, y+1 
						leftDiag[i] += puzzleArray[c][d];
						c--;
						d++;
					}
				}
			}
		}
		/**
		for (int x = 0; x < leftDiag.length; x++) {   // testing output
			System.out.println(leftDiag[x]);
		}
		**/
		sortedStrings.add(leftDiag);                    // adding array to list       
		sortBackLeftDiag(leftDiag);          // sends array to method that creates reverse of each string  
	}
	
	public void sortBackLeftDiag(String[] leftDiag) {
		
		String[] backLeftDiag = new String[(Puzzle.ARRAY_SIZE*2)-1];
		
		for (int i = 0 ; i < leftDiag.length ; i++)   //creates a backwards string for each left diagonal, stored in backLeftDiag[]
		{
			backLeftDiag[i] = new StringBuilder(leftDiag[i]).reverse().toString();
		}
		
		sortedStrings.add(backLeftDiag);
	}
	
	public void sortRightDiag() {
		
		String[] rightDiag = new String[(Puzzle.ARRAY_SIZE*2)-1];
		
		for (int z = 0; z < rightDiag.length; z++) { //removes null
			rightDiag[z] = "";
		}
		
		for (int i = 0; i <= Puzzle.ARRAY_SIZE; i++) { //using 15 values, creates 27 total strings: 14 total strings with i=0-13 & 13 strings with i=14 
			for (int j = 0; j < Puzzle.ARRAY_SIZE; j++) { 	// 14 total subscripts, iterates through
				int k = j-i; // [x][y] y-x constant
				if (k == Puzzle.ARRAY_SIZE-1 && j == Puzzle.ARRAY_SIZE-1) { // [0,13] (top right diagonal) 
					rightDiag[i] += puzzleArray[i][j]; //stored in first array index, 1st string
				}
				else if (k == -(Puzzle.ARRAY_SIZE-1) && i == Puzzle.ARRAY_SIZE-1) { // [13,0] (bottom left diagonal)
					rightDiag[(Puzzle.ARRAY_SIZE*2)-2] += puzzleArray[i][j]; // stored in final array index, 27th string
				}
				else if (i > 0 && k < Puzzle.ARRAY_SIZE-1 && k > -1 && j == Puzzle.ARRAY_SIZE-1) { // strings 2-14 
					int decI = i;
					int decJ = j;
					for (int count1 = 0; count1 <= i; count1++) {
						rightDiag[i] += puzzleArray[decI][decJ];
						decI--;
						decJ--;
					}
				}
				else if (i > Puzzle.ARRAY_SIZE-1 && j == 0) { // 14th string, starts immediately at column 0 
					int row = Puzzle.ARRAY_SIZE-1;
					int col = Puzzle.ARRAY_SIZE-2;
					int incrementI = i;
					int insideCounter = Puzzle.ARRAY_SIZE-2;
					for (int apple = 0; apple < Puzzle.ARRAY_SIZE-2; apple++) { // creates strings 15-26 : 27 stored @ L145
							int rowDec = row;
							int colDec = col;
							for (int orange = insideCounter; orange >= 0; orange-- ) {
							rightDiag[incrementI] += puzzleArray[rowDec][colDec];
							colDec--;
							rowDec--;
						}
						insideCounter--;
						incrementI++;
						col--;
					}
					break;
				}
			}
		}
		/**
		for (int x = 0; x < rightDiag.length; x++) {   // testing output
			System.out.println(rightDiag[x]);
		}
		**/
		sortedStrings.add(rightDiag);
		sortBackRightDiag(rightDiag);
	}
	
	public void sortBackRightDiag(String[] rightDiag) {
		
		String[] backRightDiag = new String[(Puzzle.ARRAY_SIZE*2)-1];
		
		for (int i = 0 ; i < rightDiag.length ; i++)   //creates a backwards string for each right diagonal, stored in backRightDiag[]
		{
			backRightDiag[i] = new StringBuilder(rightDiag[i]).reverse().toString();
		}
		
		sortedStrings.add(backRightDiag);
	}
}

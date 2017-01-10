package gaweda.edward.project;

public class Main {

	public static void main(String[] args) {
		
		// word search puzzle
		
		String[][] Puzzle = { 	{ "D","L","N","S","S","C","L","A","H","N","O","C","S","E" } , 
								{ "L","S","P","S","A","U","S","T","A","A","E","O","W","N" } ,
								{ "N","F","E","S","A","W","A","E","N","M","E","E","S","F" } ,
								{ "E","S","T","A","R","C","S","U","S","S","G","E","D","L" } ,
								{ "N","L","A","N","E","S","A","I","T","O","L","S","U","L" } ,
								{ "E","T","T","N","N","S","N","S","A","N","O","T","A","T" } ,
								{ "E","L","S","A","D","V","S","O","O","G","V","A","S","A" } ,
								{ "R","L","A","S","E","S","V","S","W","S","E","I","C","E" } ,
								{ "O","O","N","E","L","A","E","W","H","M","S","N","S","S" } ,
								{ "N","O","F","E","L","A","N","N","K","N","A","N","L","A" } ,
								{ "S","R","A","O","E","E","N","I","F","L","C","N","S","A" } ,
								{ "N","L","L","F","F","O","T","S","I","R","K","A","S","O" } ,
								{ "E","A","O","G","C","S","R","E","W","O","P","A","G","A" } ,
								{ "A","R","L","L","S","E","N","A","L","L","T","N","S","A" } };
								 
		String[] words = { "ELSA" , "ANNA" , "KRISTOFF" , "SVEN" , "HANS" , "OLAF" , "ARENDELLE" , "SONGS" , "ICE" , 
							"SNOWMAN" , "CASTLE" , "POWERS" , "GLOVES" , "SAUNA" };
		
		String[] Brow = new String[14];
		String[] Row = createRows(Puzzle, Brow);
		String[] Bcol = new String[14];
		String[] Col = createCols(Puzzle, Bcol);
		String[] backLdiag = new String[27];
		String[] Ldiag = createLdiag(Puzzle, backLdiag);
		String[] backRdiag = new String[27];
		String[] Rdiag = createRdiag(Puzzle);
		reorderRdiag(Rdiag, backRdiag);
		
		searchRows(words, Row, Brow);
		searchCols(words, Col, Bcol);
		searchLdiag(words, Ldiag, backLdiag);
		searchRdiag(words, Rdiag, backRdiag);
		
	}
		
	public static String[] createRows (String[][] Puzzle, String[] Brow) {	//converts each row to a string stored in Row[]
		
		String[] Row = { "","","","","","","","","","","","","","", }; //removes null
		
		for (int i = 0 ; i < Row.length ; i++)
			{
				for (int j = 0; j < Puzzle.length ; j++)
					{
							Row[i] += Puzzle[i][j];
					}
			}	
	
		
		for (int k = 0 ; k < Row.length ; k++)								//creates a backwards string for each row, stored in Brow[]
		{
			Brow[k] = new StringBuilder(Row[k]).reverse().toString();
		}
		
		return Row;
		
	}
	
	public static String[] createCols (String[][] Puzzle, String[] Bcol) { //converts each column to a string stored in Col[]

		String[] Col = { "","","","","","","","","","","","","","", }; //removes null
		
		for (int i = 0 ; i < Col.length; i++)
		{
			for (int j = 0 ; j < Puzzle[i].length ; j++)
			{
				Col[i] += Puzzle [j][i];
			}
		}
		
		for (int k = 0 ; k < Col.length ; k++)								//creates a backwards string for each col, stored in Bcol[]
		{
			Bcol[k] = new StringBuilder(Col[k]).reverse().toString();
		
		}
		
		return Col;
		
	}
	
	public static String[] createLdiag (String[][] Puzzle, String[] backLdiag) {
		
		String[] Ldiag = { "","","","","","","","","","","","","","","","","","","","","","","","","","","" }; //removes null
		

		for (int i = 0 ; i < Puzzle.length * 2 ; i++)
		{
			for (int j = 0 ; j <= i ; j++)
			{
				int k = i - j;
				if (k < Puzzle.length && j < Puzzle.length)
				{
					
					Ldiag[i] += Puzzle[k][j];
					
				}
			}
		}
		
		for (int l = 0 ; l < Ldiag.length ; l++)
		{
			backLdiag[l] = new StringBuilder(Ldiag[l]).reverse().toString();
		}
	
		return Ldiag;
		
	}
	
	public static String[] createRdiag (String[][] Puzzle) {
	
		String[] Rdiag = { "","","","","","","","","","","","","","","","","","","","","","","","","","","" }; //removes null
		
		// top half diag
		
		int x = 0;
				
		for (int i = 0 ; i <= Puzzle.length -1 ; i++)
		{
			for (int j = Puzzle.length -1 ; j >= 0 ; j--)
			{
				int k = j - i;
					if (k < 0 || k >= Puzzle.length)
					{	}
					else
					Rdiag[x] += Puzzle[k][j];
			}
			x++;
		}	
			// bottom half diag
			
		for (int r = 1 ; r <= Puzzle.length -1 ; r++)
		{
			for (int s = Puzzle.length -1 ; s >= 0 ; s--)
			{
				int t = s - r;
					if (t < 0 || t >= Puzzle.length)
					{	}
					else
					Rdiag[x] += (Puzzle[s][t]);
			}
			x++;
		} 	
		
		return Rdiag;
	}	
		
	public static void reorderRdiag (String[] Rdiag, String[] backRdiag ) {
		
		String [] temp = new String[14];
		
		for (int i = 0 ; i < temp.length ; i++)
		{
			temp[i] = Rdiag[13-i];
		}
		
		for (int j = 0 ; j < temp.length ; j++)
		{
			Rdiag[j] = temp[j];
		}
		
		for (int k = 0 ; k < Rdiag.length ; k++)
		{
			backRdiag[k] = new StringBuilder(Rdiag[k]).reverse().toString();
		}
	}
	
	public static void searchRows(String[] words, String[] Row, String[] Brow) {
		
		for (int i = 0 ; i < Row.length ; i++)
		{
			for (int j = 0 ; j < words.length ; j++)
			{
				if (Row[i].contains(words[j]))
				{
					System.out.println(words[j] + " is found in row " + i + ". Start Location: "
											+ i + "," + Row[i].indexOf(words[j]) + " End Location: " 
											+ i + "," + (Row[i].indexOf(words[j]) + words[j].length())  );						
				}
				else if (Brow[i].contains(words[j]))
				{
					System.out.println(words[j] + " is found backwards in row " + i + ". Start Location: "
											+ i + "," + Brow[i].indexOf(words[j]) + " End Location: " 
											+ i + "," + (Brow[i].indexOf(words[j]) + words[j].length())  );	
				}
			}
		}
			
	}
	
	public static void searchCols(String[] words, String[] Col, String[] Bcol) {
		
		for (int i = 0 ; i < Col.length ; i++)
		{
			for (int j = 0 ; j < words.length ; j++)
			{
				if (Col[i].contains(words[j]))
				{
					System.out.println(words[j] + " is found in column " + i + ". Start Location: "
										 + i + "," + Col[i].indexOf(words[j]) + " End Location: " 
										 + i + "," + (Col[i].indexOf(words[j]) + words[j].length())  );						
				}
				else if (Bcol[i].contains(words[j]))
				{
					System.out.println(words[j] + " is found backwards in column " + i + ". Location: "
											+ i + "," + Bcol[i].indexOf(words[j]) + " End Location: " 
											+ i + "," + (Bcol[i].indexOf(words[j]) + words[j].length())  );	
				}
				else
					continue;
			}
		}
		
	}
	
	public static void searchLdiag(String[] words, String[] Ldiag, String[] backLdiag) {
		
		for (int i = 0 ; i < Ldiag.length ; i++)
		{
			for (int j = 0 ; j < words.length ; j++)
			{
				if (Ldiag[i].contains(words[j]))
				{
					if (i < 14)
					{
						System.out.println(words[j] + " is found diagonally left-to-right. Start Location: "
										+ (i - Ldiag[i].indexOf(words[j])) + "," + (0 + Ldiag[i].indexOf(words[j]))
										+ " End Location: " + (i - Ldiag[i].indexOf(words[j]) - (words[j].length() -1))
										+ "," + (Ldiag[i].indexOf(words[j]) + (words[j].length() -1)));
					}
					else
					{
						System.out.println(words[j] + " is found diagonally left-to-right. Start location: "  
											+ (13 - Ldiag[i].indexOf(words[j])) + "," + ((i-13) + Ldiag[i].indexOf(words[j])) 
											+ " End Location: " + (13 - Ldiag[i].indexOf(words[j]) - (words[j].length() -1))
											+ "," + ((i-13) + Ldiag[i].indexOf(words[j]) + (words[j].length() -1)) );
						
					}
				}
				else if (backLdiag[i].contains(words[j]))
				{
					if (i < 14)
					{
						System.out.println(words[j] + " is found diagonally (backwards) left-to-right. Start Location: "
										+ (i - backLdiag[i].indexOf(words[j])) + "," + (0 + backLdiag[i].indexOf(words[j]))
										+ " End Location: " + (i - backLdiag[i].indexOf(words[j]) - (words[j].length() -1))
										+ "," + (backLdiag[i].indexOf(words[j]) + (words[j].length() -1)));
					}
					else
					{
						System.out.println(words[j] + " is found diagonally (backwards) left-to-right. Start location: "  
											+ (13 - backLdiag[i].indexOf(words[j])) + "," + ((i-13) + backLdiag[i].indexOf(words[j])) 
											+ " End Location: " + (13 - backLdiag[i].indexOf(words[j]) - (words[j].length() -1))
											+ "," + ((i-13) + backLdiag[i].indexOf(words[j]) + (words[j].length() -1)) );
						
					}
				}
				else
					continue;
			}
		}
		
		
	}
	
		public static void searchRdiag(String[] words, String[] Rdiag, String[] backRdiag) {
			
			int x = -26;
		
			for (int i = 0 ; i < Rdiag.length ; i++)
			{
				for (int j = 0 ; j < words.length ; j++)
			{
					if (Rdiag[i].contains(words[j]))
					{
					if (i < 14)
					{
						System.out.println(words[j] + " is found diagonally right-to-left. Start Location: "
								+ (i - Rdiag[i].indexOf(words[j])) + "," + (13 - Rdiag[i].indexOf(words[j]))
								+ " End Location: " + (i - Rdiag[i].indexOf(words[j]) - (words[j].length() -1))
								+ "," + (13 - Rdiag[i].indexOf(words[j]) - (words[j].length() -1)));
					}
					else
					{
						System.out.println(words[j] + " is found diagonally right-to-left. Start location: "  
								+ (13 - Rdiag[i].indexOf(words[j])) + "," + ((i - x) - Rdiag[i].indexOf(words[j]))
								+ " End Location: " + (13 - Rdiag[i].indexOf(words[j]) - (words[j].length() -1))
								+ "," + ((i-x) - Rdiag[i].indexOf(words[j]) - (words[j].length() -1)));
					}	
				}
			
			
				
					else if (backRdiag[i].contains(words[j]))
					{
					if (i < 14)
					{
						System.out.println(words[j] + " is found diagonally (backwards) right-to-left. Start Location: "
								+ (i - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length())) + "," 
								+ (13 - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length()))
								+ " End Location: " 
								+ (i - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length()) - (words[j].length() -1))
								+ "," 
								+ (13 - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length()) - (words[j].length() -1)));
					}
					else
					{
						System.out.println(words[j] + " is found diagonally (backwards) right-to-left. Start location: "  
								+ (13 - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length())) + ","
								+ ((i-x) - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length()))
								+ " End Location: " 
								+ (13 - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length()) - (words[j].length() -1))
								+ "," 
								+ ((i-x) - (backRdiag[i].length() - backRdiag[i].indexOf(words[j]) - words[j].length()) - (words[j].length() -1)));
					}	
					}
					else
						continue;
					
				
			}
				x +=2;
		}
		
	
	}	
}		
		

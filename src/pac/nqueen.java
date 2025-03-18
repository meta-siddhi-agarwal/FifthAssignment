package pac;

import java.util.Arrays;
import java.util.Scanner;

public class nqueen {

	//scanner obj. for taking input from user
	static Scanner scannerObject=new Scanner(System.in);
	
	//class obj. for calling non-static class functions
	static nqueen nqueenObject=new nqueen();
	

	public static void main(String[] args) {
			try {
				System.out.println("Enter value of n");				
				int noOfRowAndColumn=scannerObject.nextInt();
				
				/*if no. of rows and column exceed 14
				throw assertion error since stack cannot handle*/
				if(noOfRowAndColumn>=15) throw new AssertionError("Value of n should not exceed 14");
				int nQueenMatrix[][]=new int[noOfRowAndColumn][noOfRowAndColumn];
				
				boolean isPlaced=canPlaceNQueens(nQueenMatrix, 0, 0);
				
				//no solution exists means we can't place queens at every row
				if(isPlaced==false) {
					System.out.println("No solution exists for given value of n");
				}
				else {
					System.out.println("Resultant matrix is");
					
					//print matrix
					for(int rowIndex=0;rowIndex<noOfRowAndColumn;rowIndex++) {
						for(int columnIndex=0;columnIndex<noOfRowAndColumn;columnIndex++) {
							System.out.print(nQueenMatrix[rowIndex][columnIndex]+" ");
						}
						System.out.println();
					}
				}
			}
			//invalid inputs eg. string or char
			catch(Exception e) {
				System.out.println("Enter valid input");
			}
	}
	
	/**
	 * function will place n queens into chessboard
	 * @param board n*n matrix where n represents row and column
	 * @param row index of the board
	 * @param column index of the board
	 * @return boolean result where true represents queens are placed
	 */
	static boolean canPlaceNQueens(int [][] board,int row,int column) {
		/*edge case 
		 * will return from function in case row or column goes outside matrix
		 */
		if(row <0 || column<0) return false;
		
		//if backtrack is true function will return to previous state else not
		boolean backtrack=false;
		
		//it will keep record upto how many row queens are placed
		int previousRow=0;
		
		//outer loop for checking row
		for(int indexOfRow=row;indexOfRow<board.length;indexOfRow++) {
			previousRow=indexOfRow;
			/*since queen is not placed at current row,
			therefore setting is placed as false*/
			boolean isPlaced=false;
			
			//inner loop for checking column
			for(int indexOfColumn=column;indexOfColumn<board.length;indexOfColumn++) {
				
				//check whether specific cell is safe to place a queen
				if(checkIfSafe(board,indexOfRow,indexOfColumn)) {
					
					//if safe, then will place a queen(here 1 means a queen)
					board[indexOfRow][indexOfColumn]=1;
					
					/*if isplaced is true, it means queen is placed at a specific
					cell of a row*/
					isPlaced=true;
					break;
				}
			}
			/* if isplaced is false, it means queen cannot be placed
			   anywhere in the row*/
			if(isPlaced==false) {
				//here we will set backtrack as true to reverse to previous row
				backtrack=true;
				break;
			}
		}
		/*if backtrack is true, reverse to previous row else return 
		to calling function*/
		if(backtrack==true)return canPlaceNQueens(board,previousRow-1,0);
		else return true;
	}
	
	/**
	 * check whether queen can be placed at specified row and column
	 * @param board n* matrix where n represents row and column
	 * @param rowOfBoard represents row index
	 * @param columnOfBoard represents column index
	 * @return boolean result where true represents cell is safe to place 
	 * a queen and false represents not safe to place queen
	 */
	static boolean checkIfSafe(int[][] board,int rowOfBoard,int columnOfBoard) {
		/*if a queen is already placed at a specific cell
		removing queen from the cell, and returning false*/
		if(board[rowOfBoard][columnOfBoard]==1) {
			board[rowOfBoard][columnOfBoard]=0;
			return false;
		}
		
		//this loop will check for column
		for(int indexOfRow=rowOfBoard-1;indexOfRow>=0;indexOfRow--) {
			if(board[indexOfRow][columnOfBoard]==1)return false;
		}
		
		int rowIndex=rowOfBoard-1;
		int columnIndex=columnOfBoard;
		//this loop will check for diagonals
		while(rowIndex>=0 && columnIndex>=0) {
			//will check right diagonals
			if(columnIndex==0) {
				if(board[rowIndex][columnIndex+1]==1)return false;
			}
			//will check left diagonals
			else if(columnIndex==board.length-1) {
				if(board[rowIndex][columnIndex-1]==1)return false;
			}
			//will check both diagonals
			else {
				if(board[rowIndex][columnIndex-1]!=1 
				&& board[rowIndex][columnIndex+1]!=1) {}
				else return false;
			}
			rowIndex--;
			columnIndex--;
		}
		return true;
		
	}
}

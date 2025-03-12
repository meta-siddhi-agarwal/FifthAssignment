package pac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class nqueen {

	public static void main(String[] args) {
		int arr[][]=new int[4][4];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				arr[i][j]=0;
			}
		}
		Map<Integer,Integer> hm=new HashMap<>();
		boolean isPlaced=toPlace(arr,0,0,hm);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	static boolean toPlace(int board[][],int row,int col,Map<Integer,Integer> hm) {
		if(row>=board.length)return true;
		if(col>=board.length)return toPlace(board,--row,hm.get(row),hm);
		
		for(int i=row;i<board.length;i++) {
			boolean isPlaced=false;
			for(int j=col;j<board.length;j++) {
				if(isSafe(board, row, col)) {
					board[i][j]=1;
					isPlaced=true;
					hm.put(i,j);
//					int u=i;
					return toPlace(board, i++, 0, hm);
				}
			}
			if(isPlaced==false) {
				int h=i;
				board[h-1][hm.get(h-1)]=0;
				System.out.println((h-1)+" "+hm.get(h-1));
				return toPlace(board, --i, hm.get(i), hm);
			}
//			return true;
		}
//		HashMap<Integer,Integer> hm=new HashMap<>();
//		
//		int j1=0, j=0;
//		for(int i=row;i<board.length;i++) {
//			int y=0;
//			if(j1>=board.length) {
//				j1=hm.get(--i);
//				--i;
//			}
//			else {
//				
//			
//			System.out.println("Row "+i+" "+j1);
//			for(j=j1;j<board.length;j++) {
//				
//				if(isSafe(board,i,j)) {
//					System.out.println(i+" "+j);
//					hm.put(i,j);
//					
//					board[i][j]=1;
//					break;
//				}
//				else y=j;
//			}
//			}
////			if(hm.containsKey(i)) {}
////			else {
//			if(y>=board.length-1) {
//				System.out.println(j1+"backtracking"+i);
//				j1=hm.get((i-1))+1;
//				board[i-1][hm.get(i-1)]=0;
//				i-=2;
//				System.out.println(j1+"backtrack"+i);
////			}
//		}
//			else j1=0;
//		
//			}
		return true;
	}

	static boolean isSafe(int board[][],int row, int col ) {
		if(row==0)return true;
		for(int i=row;i>=0;i--) {
			
				if(board[i][col]==1)return false;
			
		}
		

		if(col==0) {
			if(board[row-1][col+1]==1)return false;
			else return true;
		}
		else if(col==board.length-1) {
			if(board[row-1][col-1]==1)return false;
			else return true;
		}
		else {
			if(board[row-1][col+1]==0 && board[row-1][col-1]==0)return true;
			else return false;
		}
//		int j=col;
//		for(int i=row;i>0;i--) {
////			for(int j=col;j>=0;j--) {
//				if(col==0) {
//					if(board[i-1][j+1]!=1) {j++;}
//					else return false;
//				}
//				else if(col==board.length) {
//					if(board[i-1][j-1]!=1) {j--;}
//					else return false;
//				}
//				else {
//					if()
//				}
//			}
//		}
//		
		
		
	}
}

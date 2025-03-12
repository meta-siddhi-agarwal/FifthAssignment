package pac;

import java.util.Arrays;
import java.util.Scanner;

public class Search {

	static Search classObject=new Search();
	
	static int sizeOfArray;
	
	static int[] inputArray;
	
	static int key;
	
	static Scanner scannerObject=new Scanner(System.in);
	public static void main(String[] args) {
		try {
			System.out.println("Enter size of array ");
			sizeOfArray=scannerObject.nextInt();
			if(sizeOfArray==0)throw new AssertionError("Size cannot be 0");
			inputArray=new int[sizeOfArray];
			System.out.println("Enter elements in array ");
			for(int arrayIndex=0;arrayIndex<sizeOfArray;arrayIndex++) {
				inputArray[arrayIndex]=scannerObject.nextInt();
			}

			
			System.out.println("Enter element which needs to be searched");
			key=scannerObject.nextInt();
			
			int indexOfKey=classObject.linearSearch(inputArray, key,0);
			if(indexOfKey>=0)
			System.out.println("Element is at index "+indexOfKey);
			else System.out.println("Element not found");
			
			Arrays.sort(inputArray);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}		
		

		
	}
	
	int linearSearch(int inputArray[],int key,int inputArrayIndex) {
		if(inputArrayIndex>=inputArray.length)return -1;
		if(inputArray[inputArrayIndex]==key)return inputArrayIndex;
		return linearSearch(inputArray, key, ++inputArrayIndex);
	}
	
	int binarySearch(int inputArray[],int key,int lowerBound,int upperBound) {
		if(lowerBound>upperBound)return -1;
		int midIndex=lowerBound+((upperBound-lowerBound)/2);
		if(inputArray[midIndex]==key)return midIndex;
		else if(inputArray[midIndex]<key)return binarySearch(inputArray, key, lowerBound+=midIndex, upperBound);
		else return binarySearch(inputArray, key, lowerBound, upperBound-=midIndex);
	}

}

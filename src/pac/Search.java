package pac;

import java.util.Arrays;
import java.util.Scanner;

public class Search {

	//class obj. for calling non-static functions
	static Search classObject=new Search();
	
	//global variable size of array
	static int sizeOfArray;
	
	//global int array
	static int[] inputArray;
	
	//global variable key(items which needs to be searched)
	static int key;
	
	//scanner obj. for taking input from user
	static Scanner scannerObject=new Scanner(System.in);
	
	//variable will control the loop
	static boolean isValid=true;
	
	//index where element is found
	static int indexOfKey;
	
	public static void main(String[] args) {
	
		while(isValid) 
		{
			try 
			{
				System.out.println("Enter size of array ");
				sizeOfArray=scannerObject.nextInt();
				if(sizeOfArray==0)throw new AssertionError("Size cannot be 0");
				inputArray=new int[sizeOfArray];
				System.out.println("Enter elements in array ");
				for(int arrayIndex=0;arrayIndex<sizeOfArray;arrayIndex++) {
					inputArray[arrayIndex]=scannerObject.nextInt();
				}
				isValid=false;
			}
				catch(Exception e) {
					System.out.println("Enter valid no.");
					scannerObject.nextLine();
				}
				
		}
				isValid=true;
				while(isValid) 
				{
					try {					
					System.out.println("Select which searching you want to perform\n"
				    +"1.Linear Search\n"+"2.Binary Search\n"+"3.Exit");
					int input=scannerObject.nextInt();
					switch(input) {
					
					//case 1 for linear search
					case 1:
						System.out.println("Enter element which needs to be searched");
						key=scannerObject.nextInt();
						indexOfKey=classObject.linearSearch(inputArray, key,0);
						if(indexOfKey>=0)
						System.out.println("Element is at index "+indexOfKey);
						else System.out.println("Element not found");
						break;
						
					//case 2 for binary search
					case 2:
						System.out.println("Enter element which needs to be searched");
						key=scannerObject.nextInt();
         				int maxValueOfArray=inputArray[0];
         				boolean canPerformSearch=true;
						for(int inputArrayIndex=0;inputArrayIndex<inputArray.length;inputArrayIndex++) {
							if(inputArray[inputArrayIndex]>=maxValueOfArray) {maxValueOfArray=inputArray[inputArrayIndex];}
							else {System.out.println("Binary search cannot be done");
							canPerformSearch=false;
							break;
							}
							
						}
						if(canPerformSearch) {
							indexOfKey=classObject.binarySearch(inputArray, key, 0, inputArray.length-1);
							if(indexOfKey>=0)
							System.out.println("Element is at index "+indexOfKey);
							else System.out.println("Element not found");	
						}											
						break;
						
					//case 1 for terminating program
					case 3:
						System.out.println("Program terminated successfully");
						isValid=false;
						break;		
				   
					/*default test case in case user provides input other 
					than the given choices*/
					default:
						System.out.println("Please choose valid option");
					}					
				}
				catch(Exception e) {
					System.out.println("Enter valid input");
					scannerObject.nextLine();
				}												
		}		
	}
	
	/**
	 * 
	 * @param inputArray provided by the user
	 * @param key element which needs to be searched from the array
	 * @param inputArrayIndex which is initially 0 since we are 
	 * traversing from index 0
	 * @return index at which element is present or -1 in case element 
	 * is not present
	 */
	int linearSearch(int inputArray[],int key,int inputArrayIndex) {
		if(inputArrayIndex>=inputArray.length)return -1;
		if(inputArray[inputArrayIndex]==key)return inputArrayIndex;
		return linearSearch(inputArray, key, inputArrayIndex+1);
	}
	
	/**
	 * 
	 * @param inputArray provided by the user
	 * @param key element which needs to be searched from the array
	 * @param lowerBound pointer initially pointing to index 0
	 * @param upperBound pointer initially pointing to last index
	 * @return index at which element is present or -1 in case element 
	 * is not present
	 */
	int binarySearch(int inputArray[],int key,int lowerBound,int upperBound) {
		if(lowerBound>upperBound)return -1;
		int midIndex=lowerBound+((upperBound-lowerBound)/2);
		if(inputArray[midIndex]==key)return midIndex;
		else if(inputArray[midIndex]<key)return binarySearch(inputArray, key, lowerBound=midIndex+1, upperBound);
		else return binarySearch(inputArray, key, lowerBound, upperBound=midIndex-1);
	}

}

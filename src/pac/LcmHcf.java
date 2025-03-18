package pac;

import java.util.Scanner;

public class LcmHcf {

	//class obj. for calling non-static functions of class
	static LcmHcf classObject=new LcmHcf();
	
	//variable will control the loop
	static boolean isValid=true;
	
	//numbers which will be taken as input from user
	static int firstNumber,secondNumber;
	
	//scanner obj. for taking input from user
	static Scanner scannerObject=new Scanner(System.in);
	
	public static void main(String[] args) {
		while(isValid) {
			try {
			    System.out.println("Which operation you want to perform \n"+
			    "1.HCF\n"+"2.LCM\n"+"3.Exit");
			    int input=scannerObject.nextInt();
			    switch(input) {
			    
			    //case 1 will compute hcf
			    case 1:
			    firstNumber=classObject.inputFromUser();
				secondNumber=classObject.inputFromUser();
			    if(firstNumber<secondNumber) {
			    	System.out.println("HCF of two no. is "+
			    (classObject.computeHcf(firstNumber, secondNumber, firstNumber)));
			    }
			    else System.out.println("HCF of two no. is "+
			    (classObject.computeHcf(firstNumber, secondNumber, secondNumber)));
			    break;
			    
			    //case 2 will compute lcm
			    case 2:
			    firstNumber=classObject.inputFromUser();
				secondNumber=classObject.inputFromUser();			    
			    System.out.println("LCM of two no. is "+
				(classObject.computeLcm(firstNumber, secondNumber, 1, 2)));
			    break;
			    
			    //case 3will terminate the program
			    case 3:
			    	System.out.println("Program ended");
			    	isValid=false;
			    	
			    //default case in case user enters no. other than provided option
			    default:
			    	System.out.println("Enter valid no.");
	
			    }
			}
			catch(Exception e) {
				System.out.println("Enter valid input");
				scannerObject.nextLine();
			}			
		}    
	}
	
	/**
	 * will take a number as input from user
	 * @return number entered be the user
	 */
	int inputFromUser() {
		System.out.println("Enter a no.");
		int number=scannerObject.nextInt();
		return number;
		
	}
	
	/**
	 * will compute hcf of two numbers
	 * @param firstNumber which is entered be the user
	 * @param secondNumber which is entered be the user
	 * @param commonFactors which will depend on either first number is smaller 
	 * or second number
	 * @return hcf of the two numbers
	 */
 int computeHcf(int firstNumber,int secondNumber,int commonFactors) {
	if(firstNumber%commonFactors==0 && secondNumber%commonFactors==0)return commonFactors;
	return computeHcf(firstNumber, secondNumber, commonFactors-1);
}
    /**
     * will compute lcm of two numbers
     * @param firstNumber which is entered be the user
     * @param secondNumber which is entered be the user
     * @param product which is initially 1
     * @param commonFactors which is initially 2
     * @return lcm of two numbers
     */
 
 int computeLcm(int firstNumber,int secondNumber,int product,int commonFactors) {
	 if(commonFactors>firstNumber && commonFactors>secondNumber)   return product;
	 
	 if((firstNumber%commonFactors==0) || (secondNumber%commonFactors==0)) {
		 product*=commonFactors;
		 if(firstNumber % commonFactors==0) firstNumber/=commonFactors;
		 if(secondNumber % commonFactors==0) secondNumber/=commonFactors;
		 return computeLcm(firstNumber, secondNumber, product, commonFactors);
	 }
	 else  return computeLcm(firstNumber, secondNumber, product, ++commonFactors);
 }
}

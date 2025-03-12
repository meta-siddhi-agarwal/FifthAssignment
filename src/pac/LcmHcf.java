package pac;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.Scanner;

public class LcmHcf {

	static LcmHcf classObject=new LcmHcf();
	
	static int firstNumber,secondNumber;
	
	static Scanner scannerObject=new Scanner(System.in);
	public static void main(String[] args) {
    firstNumber=classObject.inputFromUser();
    secondNumber=classObject.inputFromUser();
    if(firstNumber<secondNumber) {
    	System.out.println("HCF of two no. is "+(classObject.computeHcf(firstNumber, secondNumber, firstNumber)));
    }
    else System.out.println("HCF of two no. is "+(classObject.computeHcf(firstNumber, secondNumber, secondNumber)));
    
    if(firstNumber<secondNumber) {
    	 System.out.println("LCM of two no. is "+(classObject.computeLcm(firstNumber, secondNumber, 1, 2, firstNumber)));
    }
    else {
    	System.out.println("dasd");
    	System.out.println("LCM of two no. is "+(classObject.computeLcm(firstNumber, secondNumber, 1, 2, secondNumber)));
    }
    
	}
	
	int inputFromUser() {
		System.out.println("Enter a no.");
		int number=scannerObject.nextInt();
		return number;
		
	}
 int computeHcf(int number1,int number2,int commonFactors) {
	if(number1%commonFactors==0 && number2%commonFactors==0)return commonFactors;
	return computeHcf(number1, number2, commonFactors-1);
}
 
 int computeLcm(int number1,int number2,int product,int commonFactors,int smallestNumber) {
	 if(commonFactors>smallestNumber)   return product;
	 
	 if((number1%commonFactors==0) && (number2%commonFactors==0)) {
		 product*=commonFactors;
		 number1/=commonFactors;
		 number2/=commonFactors;
	 }
	 return computeLcm(number1, number2, product, ++commonFactors, smallestNumber);
 }
}

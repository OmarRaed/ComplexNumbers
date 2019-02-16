package complexnumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //Initialize the two complex number objects
        Complex firstNumber = new Complex() ;
        Complex secondNumber = new Complex() ;
        
        //initialize scanner to read input from user
        Scanner scanner = new Scanner(System.in) ;
        
        //initialize a temp boolean
        boolean isComplexNumber;
        
        //a do-while statement that loops until the user enters a true complex number
        do{
            //ask the user to enter the first complex number
            System.out.println("Enter first complex number") ;
            //scan the user's next line input
            String s = scanner.nextLine() ;
            //set the first number from the entered string, if not in proper format return false
            isComplexNumber = firstNumber.setNumberFromString(s) ;
        }while(!isComplexNumber) ;
        
        //a do-while statement that loops until the user enters a true complex number
        do{
            //ask the user to enter the second complex number
            System.out.println("Enter second complex number") ;
            //scan the user's next line input
            String s = scanner.nextLine() ;
            //set the second number from the entered string, if not in proper format return false
            isComplexNumber = secondNumber.setNumberFromString(s) ;
        }while(!isComplexNumber) ;
        
        //close the scanner after reading all data from user
        scanner.close() ;
        
        //put the add and sub results in two new objects
        Complex additionResult = firstNumber.addition(secondNumber) ;
        Complex subtractionResult = firstNumber.subtraction(secondNumber) ;
        Complex multiplyResult = firstNumber.multiply(secondNumber) ;
        
        //print the add result
        System.out.println("result of addition");
        additionResult.printNumber();
        
        //print the sub result
        System.out.println("result of subtraction");
        subtractionResult.printNumber();
        
        //print the multiply result
        System.out.println("result of multiplying");
        multiplyResult.printNumber();
        
    }
    
}

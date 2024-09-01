/*
			Level -2  Task-2: Password Strength Checker

Description: Create a program that checks the strength of a password. Prompt the user to input a
password and analyze its strength based on certain criteria, such as length, presence of
uppercase letters, lowercase letters, numbers, and special characters. Provide feedback on the
password strength.

Skills: String manipulation, conditional statements.

 */
package Level2.Task2;

import java.util.Scanner;

public class Main {

	static Scanner sc= new Scanner(System.in);
	static String Password;
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.print("\n \n Enter the Password = ");
			Password = sc.next();
	
			Password_Strength_Check p = new Password_Strength_Check(Password);
			
			if((p.Length()>=8) && p.SpecialChars() && p.Numbers() && p.UpperCase() && p.LowerCase()) {
				System.out.println("Strong Password");
				continue;
			}
			
			if(!(p.Length() >= 8)) {
				System.out.println("\nPassword length must be greater than 8.");
			}
			if(!p.UpperCase()) {
				System.out.println("\nPassword Must Contain atleast one UpperCase Letter.");
			}
			if(!p.LowerCase()) {
				System.out.println("\nPassword Must Contain atleast one LowerCase Letter.");
			}
			if(!p.Numbers()) {
				System.out.println("\nPassword Must Contain atleast one Number.");
			}
			if(!p.SpecialChars()) {
				System.out.println("\nPassword Must Contain atleast one Special Characters.");
			}
		}
	}

}
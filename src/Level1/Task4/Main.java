/*
 	Level-1  Task-4: Random Password Generator
 
Description: Build a program that generates a random password for the user. 
Prompt the user to enter the desired length of the password and specify whether
it should include numbers, lowercase letters, uppercase letters, 
and special characters. Generate the password accordingly and display it to the user.

Skills: Random number generation, string manipulation, user input.
 */
package Level1.Task4;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int length = Input.getPasswordLength(sc);
		
		if(length<4) {
		System.out.println("Password length must have atleast 4.");
		return;
		}

		Password_Options options = Input.getOptions(sc);
		
		String allchars = options.getAllcharacter();
		
		System.out.println(Password_Generation.GenetatePassword(length,options,allchars));
	}
}

/*    Level - 1    Task - 2: Palindrome Checker

Description: Implement a program that checks whether a given word or phrase is a palindrome.
 A palindrome is a word or phrase that reads the same forwards and backward, 
 ignoring spaces and punctuation.

Skills: String manipulation, loops, conditional statements. 
*/
package Level1.Task2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Word or Phase = ");
		String s = sc.next();		
		s=s.toLowerCase();
		if(s.equals(Palindrome(s))) {
			System.out.println("The Given String is Palindrome");
		}
		else {
			System.out.println("The Given String is Not Palindrome");
		}
	}
	
	public static String Palindrome(String s) {
		StringBuilder str = new StringBuilder();
		char[] c = s.toCharArray();
		
		for(char ch : c) {
			if(Character.isLetterOrDigit(ch)) {
					str.append(Character.toLowerCase(ch));
			}
		}
		return str.reverse().toString();
	}

}

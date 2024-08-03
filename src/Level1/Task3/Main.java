/*
 Level-3     Task-3: Student Grade Calculator

Description: create a program that calculates and displays the average grade of
a student. Prompt the user to enter the number of grades to be entered, and then
input each grade. Calculate the average and display it to the user.

Skills: Loops, arrays, basic arithmetic
operations
*/

package Level1.Task3;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {	
		System.out.print("Enter the Number of Grades = ");
		int n = sc.nextInt();
		double sum = Grades(n);
		System.out.print("Average of Grades = "+(sum/n));
	}
	
	public static double Grades(int n) {
		double[] grades = new double[n];
		double sum=0;
				
		for(int i=0;i<n;i++) {
			System.out.print("Enter Grade"+ (i+1) +" = ");
			grades[i] = sc.nextDouble();
			sum+=grades[i];
		}
		return sum;
	}
	
	
}

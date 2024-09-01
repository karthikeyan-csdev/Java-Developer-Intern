/*
 Level-1 - Task-1: Temperature Converter
Description: Create a program that converts temperatures between Celsius and Fahrenheit.
Prompt the user to enter a temperature value and the unit of measurement, and then perform 
the conversion. Display the converted temperature.

Skills: Basic input/output operations,
arithmetic operations
*/
package Level1.Task1;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Double temp,result;
		char c;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Temperature Value = ");
		temp = sc.nextDouble();
		System.out.print("Enter the Unit (C for Celsius, F for Fahrenheit) = ");
		c = sc.next().charAt(0);
		
		switch(c) {
		case 'C':
			result = Fahrenheit(temp);
			System.out.println(" Fahrenheit = "+result);
			break;
		case 'F':
			result = Celcius(temp);
			System.out.println(" Celcius = "+result);			
			break;
		}
	}
	public static double Fahrenheit(double t) {
		return  (t * 1.8)  + 32;
	}
	public static double Celcius(double t) {
		return (t - 32) * 5 / 9;
	}
}

/*
 	Level-2    Task-1: Tic-Tac-Toe Game

Description: Implement a two-player tic-tac-toe game. Display the game board and prompt each
player to enter their moves. Check for a winning condition or a draw after each move, and display
the result accordingly. Allow the players to play multiple rounds if desired.

Skills: Arrays or matrices, loops, conditional statements.
 */
package Level2.Task1;

import java.util.Scanner;

public class Main {
	
	static int n;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" Enter the value of NxN matrix = ");
		n=sc.nextInt();
		
		if(n<2) {
			System.out.println("N value must be greater than 1");
			System.exit(0);
		}
		
		Tic_Tac_Toe.MatrixAssign(n);
		Tic_Tac_Toe.DisplayMatrix(n);
		while(true) {
			Tic_Tac_Toe.inputmsg(sc,n);
			
		}
		
	}
	
	}

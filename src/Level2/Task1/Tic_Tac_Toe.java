package Level2.Task1;

import java.util.Scanner;

public class Tic_Tac_Toe {
	
	static String[][] a;
	static int playercount=0;

	
	public static void inputmsg(Scanner sc,int n) {
		int x,y;
		System.out.println((playercount % 2) == 0 ? " Player X's Turn" : " Player O's Turn");
		System.out.print(" Enter the Position value(x y) = ");
		x=sc.nextInt();
		y=sc.nextInt();
		System.out.println(Insert(x, y, playercount%2==0?" X" : " O",n));
		
	}

	public static void MatrixAssign(int n) {
		a = new String[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=i+""+j;
			}
		}
	}
	
	public static void DisplayMatrix(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]+ "   ");
			}
			System.out.println("\n");
		}
	}	

	public static String Insert(int x,int y,String player,int n) {
		
		if((x<n && x>=0) && (y<n && y>=0)) {
		
			if(!a[x][y].equals(" X") && !a[x][y].equals(" O")) {
			
				a[x][y] = player;
				playercount++;
				DisplayMatrix(n);
				
				if(Tic_Tac_Toe.Checkwin(n,a)) {
					System.out.println(" Player "+player +" Win...");
					System.exit(0);
				}
				else if(playercount==(n*n)) {
						System.out.println(" Game Draw...");
						System.exit(0);
				}
				return " Inserted";
			}
			else {
				return " Already Occupied";
			}
		}
		return " Unexpected Place";
	}

	public static boolean Checkwin(int n,String[][] a) {
		int i,j;
		//for row
		for(i=0;i<n;i++) {
			j=0;
			if(a[i][j].equals(" X") || a[i][j].equals(" O")){
				while(j<n-1) {
					if(a[i][j].equals(a[i][j+1])) {
						j++;
					}
					else {
						break;
					}
				}
				if(j==n-1) {
					return true;
				}
			}
			
		}
		//for column
		for(i=0;i<n;i++) {
			j=0;
			if(a[j][i].equals(" X") || a[j][i].equals(" O")){
				while(j<n-1) {
					if(a[j][i].equals(a[j+1][i])) {
						j++;
					}
					else {
						break;
					}
				}
				if(j==n-1) {
					return true;
				}
			}
			else {
				continue;
			}
			
		}		

		//for diagonal - left to right
		i=0;j=0;
		if(a[i][j].equals(" X") || a[i][j].equals(" O")) {
			while(i<n-1) {
				if(a[i][j].equals(a[i+1][j+1])) {
					i++;j++;
				}
				else {
					break;
				}
				if(i==n-1) {
					return true;
				}
			}
		}
		
		//for diagonal - right to left
		i=0;j=n-1;
		if(a[i][j].equals(" X") || a[i][j].equals(" O")) {
			while(i<n-1) {
				if(a[i][j].equals(a[i+1][j-1])) {
					i++;j--;
				}
				else {
					break;
				}
				if(i==n-1) {
					return true;
				}
			}
		}
		return false;
	}
}

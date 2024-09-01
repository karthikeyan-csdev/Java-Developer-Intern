/*
 	Level-2   Task-3: File Encryption/Decryption 
 
 Description: Create a program that encrypts or decrypts the contents of a text file using a simple
encryption algorithm. Prompt the user to choose between encryption or decryption, and input the
file name or path. Encrypt or decrypt the file accordingly and save the result to a new file.	

Skills: File handling, string manipulation, basic input/output operations.
 */
package Level2.Task3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc  = new Scanner(System.in);
	
		System.out.println(" File Encryption / Decryption \n ---- ---------- - ----------");
		System.out.print(" 1. Encryption\n 2. Decryption ");
		
		System.out.print("\n\n Enter your choice : ");
		int c = sc.nextInt();
		
		System.out.print("Enter File Path = ");
		File f = File_Methods.InputFilePath(sc);
		
		if(!f.exists()) {
			System.out.println("File Not Found...");
			System.exit(0);
		}
		
		switch(c) {
			case 1:
				File_Methods.EncryptFile(f);
				break;
			case 2:
				File_Methods.DecryptFile(f);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
		}
		
	}
}

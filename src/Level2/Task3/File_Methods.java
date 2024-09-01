package Level2.Task3;

import java.io.*;
import java.util.Scanner;

public class File_Methods {

	//Encryption method
	public static void EncryptFile(File file) throws IOException {
		
		StringBuilder encrypt = ReadFile(file);
		char ch[] = encrypt.toString().toCharArray();
		
		FileOutputStream fout = new FileOutputStream("C:/Users/karthi/Desktop/Encrypt.txt",false);
        WriteFile(ch,fout,1);
		
        System.out.println("Encrypted : C:/Users/karthi/Desktop/Encrypt.txt");
		
	}
	//Decryption method
	public static void DecryptFile(File file) throws IOException {
		
		StringBuilder decrypt = ReadFile(file);
		char ch[] = decrypt.toString().toCharArray();
		
		FileOutputStream fout = new FileOutputStream("C:/Users/karthi/Desktop/Decrypt.txt",false);
        WriteFile(ch,fout,0);
		
        System.out.println("Decrypted : C:/Users/karthi/Desktop/Decrypt.txt");
	}

	//Write into file method
	public static void WriteFile(char[] ch,FileOutputStream fout,int x) throws IOException {
		
		char ch1[]=new char[ch.length];
    
		if(x==1) {
        	for (int i = 0; i < ch.length; i++) {
        		ch1[i] = (char) ( ((int)ch[i]) +1);
        		fout.write(ch1[i]);
        	}
        	fout.close();
        }
        else {
        	for (int i = 0; i < ch.length; i++) {
        		ch1[i] = (char) ( ((int)ch[i]) -1);
        		fout.write(ch1[i]);
        	}
        	fout.close();
        }
	}
	
	// Get filepath as input from user
	public static File InputFilePath(Scanner sc) throws FileNotFoundException {
		
		File f = new File(sc.next());
		return f;
	}

	//Read from file method
	public static StringBuilder ReadFile(File file) throws FileNotFoundException {
	
		String fileData;
		StringBuilder data = new StringBuilder();
		
		try (Scanner dataReader = new Scanner(file)) {
		
			while (dataReader.hasNextLine()) {  
			         fileData = dataReader.nextLine();
			         data.append(fileData);
			}
		}
		return data;
	}
}

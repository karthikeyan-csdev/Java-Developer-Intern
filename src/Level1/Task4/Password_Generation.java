package Level1.Task4;

import java.util.Random;

public class Password_Generation {

	public static String GenetatePassword(int length,Password_Options options,String allcharacter) {
		
		Random random = new Random();
		
		String password="";
		
		int loop=length/options.k;
		for(int i=0;i<loop;i++) {
			if(options.numbers) {
				password+= options.numbersString.charAt(random.nextInt(0,9));			
			}
			if(options.lowercase) {
				password+= options.lowerCaseLetters.charAt(random.nextInt(0,25));			
			}
			if(options.uppercase) {
				password+= options.upperCaseLetters.charAt(random.nextInt(0,25));			
			}
			if(options.specialchars) {
				password+= options.specialCharsString.charAt(random.nextInt(0,29));			
			}
		}
		loop=length % options.k;
		if(loop>0) {
			for(int i=0;i<loop;i++) {
				password+= allcharacter.charAt(random.nextInt(allcharacter.length()));
			}
		}
		return password;
	}
}


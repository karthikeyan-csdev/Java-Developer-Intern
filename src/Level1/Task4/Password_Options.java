package Level1.Task4;

public class Password_Options {

	String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	String numbersString = "0123456789";
	String specialCharsString = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
	
	int k;  // this instance is used for equally generate the password with the user options
	
	boolean numbers,uppercase,lowercase,specialchars;
	
	
	public String getAllcharacter() {
        StringBuilder allchars = new StringBuilder();
        
        if (numbers) {
        	allchars.append(numbersString);
            k++;
        }
        if (lowercase) {
        	allchars.append(lowerCaseLetters);
            k++;
        }
        if (uppercase) {
        	allchars.append(upperCaseLetters);
            k++;
        }
        if (specialchars) {
        	allchars.append(specialCharsString);
            k++;
        }

        return allchars.toString();
    }

}
package Level2.Task2;

public class Password_Strength_Check {
	
	String password;
	public Password_Strength_Check(String pass) {
		password = pass;
	}
	
	// to check the password contains uppercase letters
	public boolean UpperCase() {
		
		char[] c = password.toCharArray();
		for(char i : c) {
			if(((int)i >= (int)'A') && ((int)i <= (int)'Z')){
				return true;
			}
		}		
		return false;
	}
	
	// to check the password contains special characters(symbols)
	public boolean SpecialChars() {
		
		char[] c = password.toCharArray();
		for(char i : c) {
			if( ((int)i >= (int)'!') && ((int)i <= (int)'/') || 
				((int)i >= (int)':') && ((int)i <= (int)'@') ||
				((int)i >= (int)'[') && ((int)i <= (int)'`') ||
				((int)i >= (int)'{') && ((int)i <= (int)'~')
				){
				return true;
			}
		}		
		return false;
	}

	// to check the password contains lowercase letters
	public boolean LowerCase() {
		
		char[] c = password.toCharArray();
		for(char i : c) {
			if(((int)i >= (int)'a') && ((int)i <= (int)'z')){
				return true;
			}
		}		
		return false;
	}
	// to check the password contains numeric letters
	public boolean Numbers() {
		
		char[] c = password.toCharArray();
		for(char i : c) {
			if(((int)i >= (int)'0') && ((int)i <= (int)'9')){
				return true;
			}
		}		
		return false;
	}
	// to find the length of the string - (minimum 8)
	public int Length() {
		char[] c = password.toCharArray();
		int length=0;
		for(char i:c) {
			length++;
		}
		return length;
	}

}

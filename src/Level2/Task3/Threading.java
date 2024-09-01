package Level2.Task3;
import java.util.*; 
public class Threading {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		
//		int n = in.nextInt();
//
//		if(isPrime(n) && isPrime(reverse(n))) {
//			System.out.println("yes");
//		}else {
//			System.out.println("no");
//		}
//	
//	}
//	
//	private static int reverse(int n) {
//		int reverse = 0;
//		while(n > 0) {
//			int rem = n % 10;
//			reverse = reverse * 10 + rem;
//			n = n/10;
//			
//		}
//		System.out.println(reverse);
//		return reverse;
//	}.p
//	
//	
//	private static boolean isPrime(int n) {
//		for(int i=2;i*i<=n;i++) {
//			if(n%i == 0) return false;
//		}
//		
//		return true;
//	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		List<Integer> list = new ArrayList<>();
		String s = String.valueOf(n);
		
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				String sub = s.substring(i,j);
				if(isDiv(Integer.parseInt(sub),k)) {
//					if(!list.contains(Integer.parseInt(sub))) {
						list.add(Integer.parseInt(sub));
//					}
				}
			}
		}
		
		System.out.println(list);
		
	}
	
	private static boolean isDiv(int n,int k) {
		return n % k == 0;
	}
}

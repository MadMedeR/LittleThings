package randomStuff;

public class MyNumbers {
	public static void main(String[] args) {
		int i=0;
		char n = (char)(i+97);
		System.out.println(n);
		int j = 'a';
		System.out.println(j);
		
		int intValue = 025;
	    System.out.println("Initial int value is " + intValue);
	    
	    int cai1 = 0x4;
	    int cai2 = 0x4e;
	    char cai3 = '\u004e';

	    System.out.println(cai1);
	    System.out.println(cai2);
	    System.out.println(cai3);
	    
	    System.out.println((int)(-0.2+1));
	}
}

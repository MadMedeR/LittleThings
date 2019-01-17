package randomStuff;

public class MyStringEverything {
	
	public static void main(String [] irgendwas) {
		System.out.println("=====String Konstruktoren=====");
		String str1 = new String();
			System.out.println(str1);
		String str2 = new String(new byte[]{65,97});
			System.out.println(str2);
		String str3 = new String(new char[]{'G',66,99});
			System.out.println(str3);
		String str4 = new String(new String("New String"));
			System.out.println(str4);
		String str5 = new String(new StringBuffer("Buffer"));
			System.out.println(str5);
		String str6 = new String(new StringBuilder("Builder"));
			System.out.println(str6);
		
		System.out.println("=====String Static Methods=====");
		char[] chars = new char[]{'G','o','o','d'};
		System.out.println(String.copyValueOf(chars));
		System.out.println(String.valueOf(true));
		System.out.println(String.valueOf('H'));
		System.out.println(String.valueOf(chars));
		System.out.println(String.valueOf(1.467856369556965565663255441851533));
		System.out.println(String.valueOf(1.467856369556965565663255441851533F));
		System.out.println(String.valueOf(66));
		System.out.println(String.valueOf(5633657888456L));
		System.out.println(String.valueOf(new Object()));
		
		System.out.println("=====String Other Methods=====");
		
		String user="mmustermann";
	    System.out.println(user.matches("^[a-z]+$"));
	}
}

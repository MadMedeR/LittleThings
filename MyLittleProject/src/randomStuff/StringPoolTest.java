package randomStuff;

public class StringPoolTest {
	public static void main(String[] args) {
		String s1 = new String("Hallo");
		String s2 = "Hallo";
		String s3 = "Hallo";
		String s4 = s2;
		String s5 = s2+s3; //s2.concats(s3);
		String s6 = "HalloHallo";
		
		System.out.println("s1==s2:" + (s1==s2));
		System.out.println("s2==s3:" + (s2==s3));
		System.out.println("s3==s1:" + (s3==s1));
		System.out.println("s3==s4:" + (s2==s4));
		System.out.println("s5==s6:" + (s5==s6));
	}
}

package randomStuff;

import java.util.Arrays;

//import Prog1Tools.IOTools;

public class KeyGen {
	private String licence = "";
	private String keyword = "";
	private String codeword = "";
	private String anticode = "";
	private static final char[] X; //[!#$%&-,0-9,A-Z,a-z] Ab index=42 Kleinbuchstaben
	private char[] S;
	
	static {
		X = new char[68];
		int i = 0;
		char j;
		X[i++] = 33;
		for(j=35;j<39;j++)  X[i++] = j;
		X[i++] = 45;
		for(j=48;j<58;j++)  X[i++] = j;
		for(j=65;j<91;j++)  X[i++] = j;
		for(j=97;j<123;j++) X[i++] = j; //i: 42-67
		System.out.println("X " + Arrays.toString(X));
	}
	
	public static void main(String[] args) {
		String user = "randomguy";
		System.out.println("licence  = " + new KeyGen(user));
	}
	
	public KeyGen(String user) {
		shuffleS();
		randKey(user);
		randCode();
		encodeLicence();
		decodeLicence();
	}

	private void shuffleS() {
		int l = X.length;
		S = new char[68];
		for (int i=0;i<l;i++) S[i] = X[i]; //Kopieren
		for (int i=0;i<l;i++) { //Shufflen
			int z = (int)(Math.random()*l);
			char tmp  = S[i];
			S[i] = S[z];
			S[z] = tmp;
		}
		System.out.println("S = " + stoString(S));
	}

	private void randKey(String user) {
		int r = 32 - user.length();
		int n = (int)(Math.random()*(r/3)+3);
		for (int i = 0; i < n; i++) {
			keyword += X[(int)(Math.random()*42)];
		}
		keyword += user;
		keyword += X[(int)(Math.random()*42)];
		for (int i=1; i<r-n; i++) {
			keyword += X[(int)(Math.random()*68)];
		}
		System.out.println("keyword  = "+keyword);
	}
	
	private void randCode() {
		for (int i=0; i<32; i++) {
			int n = (int)(Math.random()*68);
			codeword += S[n];
			anticode += S[67-n];
		}
		System.out.println("codeword = "+codeword);
		System.out.println("anticode = "+anticode);
	}
	
	private void encodeLicence(){
		int l = S.length;
		for (int i=0;i<32;i++) {
			int k=0;
			for (;k<l;k++) if (S[k] == keyword.charAt(i)) break;
			int c=0;
			for (;c<l;c++) if (S[c] == codeword.charAt(i)) break;
			int n = (k+c)%l;
			licence += S[n];
		}
	}
	
	private void decodeLicence(){
		String result="";
		boolean endIsNear = false;
		int l = S.length;
		for (int i=0;i<32;i++) {
			int k=0;
			for (;k<l;k++) if (S[k] == licence.charAt(i)) break;
			int c=0;
			for (;c<l;c++) if (S[c] == anticode.charAt(i)) break;
			int n = (k+c+1)%l;
			if (S[n]>=95) {
				result += S[n];
				endIsNear = true;
			}
			if (endIsNear && S[n]<95) break;
		}
		System.out.println("result   = "+result);
	}
	
	@Override
	public String toString() {
		return licence;
	}
	
	private String stoString(char[] S) {
		String result = "{";
		for (int i = 0; i < S.length; i++) {
			if(i>0) result += ", ";
			result += "'" + S[i] + "'";
		}
		result += "}";
		return result;
	}
}
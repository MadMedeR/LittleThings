package randomStuff;

import Prog1Tools.IOTools;

public class DecToBinary {
	public static void main(String[] args) {
		long z;
		do {
			z = IOTools.readLong("Zahl eingeben (0 = Abbruch): ");
			System.out.println("Binärcode: " + berechnen(z));
		} while (z != 0);
		System.out.println("Ende");
	}
	
	private static String berechnen(long dezimalZahl) {
		int anzahlStellen;
		long zweierPotenz;
		String output;
		if (dezimalZahl<=0) output = "0"; else output = "";
		anzahlStellen =  (int)(Math.log(dezimalZahl)/Math.log(2));
		for (int i=anzahlStellen;i>=0;i--) {
			zweierPotenz = (long)Math.pow(2, i);
			output += dezimalZahl/zweierPotenz;
			dezimalZahl -= dezimalZahl/zweierPotenz*zweierPotenz;
		}
		return output;
	}
}
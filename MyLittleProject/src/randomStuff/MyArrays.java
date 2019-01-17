package randomStuff;

public class MyArrays {
		
	public static void shuffle(int[] array) {
		int l = array.length;
		for (int i=0;i<l;i++) {
			int z = (int)(Math.random()*l);
			int tmp  = array[i];
			array[i] = array[z];
			array[z] = tmp;
		}
	}
	
	public static void shuffle(String[] array) {
		int l = array.length;
		for (int i=0;i<l;i++) {
			int z = (int)(Math.random()*l);
			String tmp  = array[i];
			array[i] = array[z];
			array[z] = tmp;
		}
	}
	
	public static void shuffle(Object[] array) {
		int l = array.length;
		for (int i=0;i<l;i++) {
			int z = (int)(Math.random()*l);
			Object tmp  = array[i];
			array[i] = array[z];
			array[z] = tmp;
		}
	}

	static public int[] enlarge (int[] array) {
		int l = array.length;
		int[] enlarged = new int[l+1];
		for(int i=0;i<l;i++) {
			enlarged[i]=array[i];
		}
		return enlarged;
	}

	static public String[] enlarge (String[] array) {
		int l = array.length;
		String[] enlarged = new String[l+1];
		for(int i=0;i<l;i++) {
			enlarged[i]=array[i];
		}
		return enlarged;
	}
	
	static public Object[] enlarge (Object[] array) {
		int l = array.length;
		Object[] enlarged = new Object[l+1];
		for(int i=0;i<l;i++) {
			enlarged[i]=array[i];
		}
		return enlarged;
	}
}

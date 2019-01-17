package randomStuff;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class ClassAndPathAnalyzer {
	public static void main(String[] args) {
		int l = 140;
		WritingTools.writeHeadline("ClassAnalyzer", l, '=');//========================================================
		ClassAndPathAnalyzer a = new ClassAndPathAnalyzer();
		
		List<Entry<Object,Object>> table = new ArrayList<>();
			table.add(new SimpleEntry<>("Object", "" + a));
			table.add(new SimpleEntry<>("getClass", "" + a.getClass()));
			table.add(new SimpleEntry<>("getClass.getName", a.getClass().getName()));
			table.add(new SimpleEntry<>("getClass.getSimpleName", a.getClass().getSimpleName()));
			table.add(new SimpleEntry<>("getClass.getClassLoader", "" + a.getClass().getClassLoader()));
			table.add(new SimpleEntry<>("hashCode (Dec)", "" + a.hashCode()));
			table.add(new SimpleEntry<>("hashCode (Hex)", "" + Integer.toHexString(a.hashCode())));
			table.add(new SimpleEntry<>("Original toString", a.getClass().getName() + '@' + Integer.toHexString(a.hashCode())));
			table.add(new SimpleEntry<>("getClass.getResource(\"\")", "" + a.getClass().getResource("")));
			table.add(new SimpleEntry<>("getClass.getProtectionDomain", "" + a.getClass().getProtectionDomain()));
			table.add(new SimpleEntry<>(".getCodeSource", "" + a.getClass().getProtectionDomain().getCodeSource()));
			table.add(new SimpleEntry<>(".getLocation", "" + a.getClass().getProtectionDomain().getCodeSource().getLocation()));
		WritingTools.setTable(table).printSimpleTable();
		System.out.println();
		
		WritingTools.writeHeadline("PathAnalyzer", l, '=');//========================================================
		System.out.println();
		
		table = new ArrayList<>();
			String p = a.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
			table.add(new SimpleEntry<>("...getLocation().getPath", p));
				p = p.replaceAll("%20", " ").substring(1, p.lastIndexOf("/")+1);
			table.add(new SimpleEntry<>(".getPath (bereinigt)", p));
			table.add(new SimpleEntry<>("Paths.get(bereinigt))", "" + Paths.get(p)));
				Path one = Paths.get(p);
				if (one.endsWith("bin")) one=one.getParent();
				one = Paths.get(one.toString(),"config.ini");
			table.add(new SimpleEntry<>(".../config.ini", "" + one));
			table.add(new SimpleEntry<>("Paths.get(\"hello.txt\")", "" + Paths.get("hello.txt")));
			table.add(new SimpleEntry<>(".toAbsolutePath", "" + Paths.get("hello.txt").toAbsolutePath()));
			table.add(new SimpleEntry<>("Paths.get(\"pics/bg.png\").toAbsolutePath", "" + Paths.get("pics/bg.png").toAbsolutePath()));
		WritingTools.setTable(table).printSimpleTable();
		System.out.println();
		
		WritingTools.writeHeadline("FileAnalyzer", l, '=');//========================================================
		System.out.println();
		
		table = new ArrayList<>();
			String  exePath="D:\\Java\\Kurs-Hilfe\\Grundlagen.txt";
			File f = new File(exePath);
			table.add(new SimpleEntry<>("new File(...)", "" + f.getAbsolutePath()));
			table.add(new SimpleEntry<>(".exists", "" + "" + f.exists()));
			table.add(new SimpleEntry<>(".isNOTDirectory", "" + "" + !f.isDirectory()));
			table.add(new SimpleEntry<>(".isFile", "" + "" + f.isFile()));
			table.add(new SimpleEntry<>(".getName", "" + f.getName()));
			table.add(new SimpleEntry<>(".getParentFile.getName", "" + f.getParentFile().getName()));
		WritingTools.setTable(table).printSimpleTable();
	}
}

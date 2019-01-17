package randomStuff;

import java.util.*;
import java.util.Map.Entry;

public class WritingTools {
	private Object input;
	private int totalLength, maxKeyLength, index=1;
	
	public static WritingTools setTable(List<Entry<Object,Object>> table) {
		return new WritingTools(table);
	}
	
	private WritingTools(List<Entry<Object,Object>> table) {
		input = table;
		maxKeyLength = table.stream().mapToInt(e -> ((String)e.getKey()).length()).max().getAsInt();
		int maxValueLength = 0;
		try {
			@SuppressWarnings("unchecked")
			List<Entry<String,List<String>>> advancedTable = (List<Entry<String,List<String>>>)input;
			maxValueLength = advancedTable.stream().flatMap(e -> e.getValue().stream()).mapToInt(s -> s.length()).max().getAsInt();
		} catch (Exception ex1) {
			try {
				@SuppressWarnings("unchecked")
				List<Entry<String,String>> simpleTable = (List<Entry<String,String>>)input;
				maxValueLength = simpleTable.stream().mapToInt(e -> e.getValue().length()).max().getAsInt();
			} catch (Exception ex2) {
				maxValueLength = maxKeyLength;
			}
		}
		totalLength = 3 + maxKeyLength + 3 + maxValueLength;	
	}
	
	public void printAdvancedTable() {
		@SuppressWarnings("unchecked")
		List<Entry<String,List<String>>> advancedTable = (List<Entry<String,List<String>>>)input;
		
		advancedTable.forEach(entry -> {
			System.out.print(String.format("%2d ", index++) + String.format("%-"+maxKeyLength+"s = ", entry.getKey()));
			
			List<String> values = entry.getValue();
			System.out.println(values.remove(0));
			values.forEach(v -> System.out.println(String.format("%-"+(maxKeyLength+6)+"s", "") + v));
		});
	}
	
	public void printSimpleTable() {
		@SuppressWarnings("unchecked")
		List<Entry<String,String>> simpleTable = (List<Entry<String,String>>)input;
		
		simpleTable.forEach(entry -> {
			System.out.println(String.format("%2d ", index++) + String.format("%-"+maxKeyLength+"s = ", entry.getKey())
			+ entry.getValue());
		});
	}
	
	//=========================================Headline=========================================
	public static void writeHeadline(String headline, int length, char... symbol) {
		char sl = symbol.length<1?'-':symbol[0];
		int left = (length - headline.length())/2;
		int right = length-headline.length()-left;
		for (int i = 0; i < left; i++) System.out.print(sl);
		System.out.print(headline);
		for (int i = 0; i < right; i++) System.out.print(sl);
		System.out.println();
	}
	
	public void writeHeadline(String headline, char... symbol) {
		writeHeadline(headline, totalLength, symbol);
	}
}

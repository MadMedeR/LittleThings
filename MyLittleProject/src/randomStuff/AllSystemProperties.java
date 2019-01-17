package randomStuff;

import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AllSystemProperties {
	public static void main(String[] args) {
		List<Entry<Object,Object>> allProperties = System.getProperties().entrySet().stream().map(entry->{
			String key = (String)entry.getKey();
			List<String> valuelist = new ArrayList<>(Arrays.asList(((String)entry.getValue()).split(";")));
			if (valuelist.size()==0) valuelist.add(";");
			Entry<Object,Object> bundled = new AbstractMap.SimpleEntry<>(key, valuelist);
			return bundled;
		}).collect(Collectors.toList());
		
		allProperties.add(new AbstractMap.SimpleEntry<>("package-folder (user.dir)", new ArrayList<>(Arrays.asList(Paths.get("").toAbsolutePath().toString()))));
		
		WritingTools table = WritingTools.setTable(allProperties);
		
		table.writeHeadline("AllSystemProperties", '=');
		
		table.printAdvancedTable();
		
		table.writeHeadline("Ende");
	}
}



package galaxy.number;

import java.util.HashMap;

public class RomanRuleNumberContextProvider {
	
	public HashMap<String, Integer> getContextUnits() {
		HashMap<String, Integer> contextUnities = new HashMap<String, Integer>();
		contextUnities.put("I", 1);
		contextUnities.put("V", 5);
		contextUnities.put("X", 10);
		contextUnities.put("L", 50);
		contextUnities.put("C", 100);
		contextUnities.put("D", 500);
		contextUnities.put("M", 1000);
		return contextUnities;
	}
	
}

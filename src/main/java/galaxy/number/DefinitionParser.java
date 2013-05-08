package galaxy.number;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefinitionParser {
	
	private List<String> input;
	Pattern numeralDefinition;
	Pattern creditsDefinition;
	private HashMap<String, String> numeral;
	private HashMap<CreditData, Double> credits;

	public DefinitionParser(List<String> input) {
		this.input = input;
		numeralDefinition = Pattern.compile("([a-zA-Z]+) is ([IVXLCDM])");
		creditsDefinition = Pattern.compile("([[a-zA-Z]+ ]+) ([a-zA-Z]+) is (\\d+) Credits");
	}

	public HashMap<String, String> getNumeral(){
		if (numeral != null) return numeral;
		numeral = new HashMap<String, String>();
		for (String line : input){
			Matcher matcher = numeralDefinition.matcher(line);
			if (matcher.matches()){
				numeral.put(matcher.group(1), matcher.group(2));
			}
		}
		return numeral;
	}
	
	public HashMap<CreditData, Double> getCredits() {
		if (credits != null) return credits;
		credits = new HashMap<CreditData, Double>();
		for (String line : input){
			Matcher matcher = creditsDefinition.matcher(line);
			if (matcher.matches()){
				credits.put(new CreditData(matcher.group(1), matcher.group(2)), new Double(matcher.group(3)));
			}
		}
		return credits;
	}

}

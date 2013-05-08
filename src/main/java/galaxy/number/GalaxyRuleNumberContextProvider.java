package galaxy.number;

import java.util.HashMap;


public class GalaxyRuleNumberContextProvider extends RomanRuleNumberContextProvider {

	protected DefinitionParser definitionParser;

	public GalaxyRuleNumberContextProvider(DefinitionParser definitionParser) {
		this.definitionParser = definitionParser;
	}
	
	@Override
	public HashMap<String, Integer> getContextUnits() {
		
		HashMap<String, Integer> parentContextUnities = super.getContextUnits();
		HashMap<String,String> numeral = definitionParser.getNumeral();

		HashMap<String, Integer> contextUnities = new HashMap<String, Integer>();
		for(String source: numeral.keySet())
			contextUnities.put(source, parentContextUnities.get(numeral.get(source)));
		return contextUnities;
	}



}

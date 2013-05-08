package galaxy.number;

import java.util.Arrays;

public class GalaxyRuleNumberTranslator extends RomanRuleNumberTranslator {

	public GalaxyRuleNumberTranslator(String number, RomanRuleNumberContextProvider galaxyContextProvider) {
		super(number, galaxyContextProvider);
	}
	
	@Override
	protected void tokenizeNumber(String number) {
		this.number = Arrays.asList(number.split(" "));		
	}	

}

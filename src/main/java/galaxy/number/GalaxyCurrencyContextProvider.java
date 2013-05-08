package galaxy.number;

import java.util.HashMap;

public class GalaxyCurrencyContextProvider extends GalaxyRuleNumberContextProvider {

	public GalaxyCurrencyContextProvider(DefinitionParser definitionParser) {
		super(definitionParser);
	}

	public HashMap<String,Double> getContextCurrency() {
		HashMap<String,Double> currency = new HashMap<String, Double>();
		HashMap<CreditData, Double> credits = definitionParser.getCredits();
		for (CreditData credit : credits.keySet()){
			double currencyValue = credits.get(credit)/new GalaxyRuleNumberTranslator(credit.number(), this).compute();
			currency.put(credit.currency(), currencyValue);
		}
		return currency;
			
	}

}

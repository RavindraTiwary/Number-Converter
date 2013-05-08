package galaxy.number;

import java.util.HashMap;

public class QueryCredits extends Query {
	
	private GalaxyCurrencyContextProvider galaxyContextProvider;
	private HashMap<String, Double> currency;
	private CreditData credits;
	
	public QueryCredits(CreditData credits, GalaxyCurrencyContextProvider galaxyContextProvider) {
		this.credits = credits;
		this.galaxyContextProvider = galaxyContextProvider;
		this.currency = galaxyContextProvider.getContextCurrency();
	}
	
	@Override
	public String ask() {
		return String.format("%s %s is %.0f Credits", 
				credits.number(), credits.currency(), calculateCredits(credits));
	}
	
	private double calculateCredits(CreditData credit) {
		return new GalaxyRuleNumberTranslator(credit.number(), galaxyContextProvider).compute() * this.currency.get(credit.currency());
	}
	
}

package galaxy.number;


public abstract class Query {

	protected DefinitionParser definitionParser;
	protected QueryValidation queryValidation;
	
	public static Query create(DefinitionParser definitionParser, QueryValidation queryValidation, String query) {
		if (queryValidation.isNumberQuery(query))
			return new QueryNumber(queryValidation.getNumber(query), new GalaxyRuleNumberContextProvider(definitionParser));
		
		if (queryValidation.isCreditsQuery(query))
			return new QueryCredits(queryValidation.getCredits(query), new GalaxyCurrencyContextProvider(definitionParser));
		
		return new QueryInvalid(); 		
	}

	public abstract String ask();
	
}

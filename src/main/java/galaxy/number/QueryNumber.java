package galaxy.number;

public class QueryNumber extends Query{

	private GalaxyRuleNumberContextProvider galaxyContextProvider;
	private String number;
	
	protected QueryNumber(String number, GalaxyRuleNumberContextProvider galaxyContextProvider){
		this.number = number;
		this.galaxyContextProvider = galaxyContextProvider;
	}
	
	@Override
	public String ask() {
		return String.format("%s is %s", 
				number, new GalaxyRuleNumberTranslator(number, galaxyContextProvider).compute());
	}

	

}

package galaxy.number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryValidation {
	
	private Pattern numberPattern;
	private Pattern creditsPattern;
	private Pattern conversionPattern;

	public QueryValidation() {
		numberPattern = Pattern.compile("how much is ([[a-zA-Z]+ ]+) \\?");
		creditsPattern = Pattern.compile("how many Credits is ([[a-zA-Z]+ ]+) ([a-zA-Z]+) \\?");
		conversionPattern = Pattern.compile("how many ([a-zA-Z]+) is ([[a-zA-Z]+ ]+) \\?");
		
	}	

	public boolean isNumberQuery(String query) {
		return numberPattern.matcher(query).matches();
	}
	
	public boolean isCreditsQuery(String query) {
		return creditsPattern.matcher(query).matches();
	}
	
	public boolean isValidQuery(String query) {
		return isCreditsQuery(query) || isNumberQuery(query);
	}

	public String getNumber(String query) {
		Matcher matcher = numberPattern.matcher(query);
		if (matcher.matches())
			return matcher.group(1);
		return "";
		
	}

	public CreditData getCredits(String query) {
		Matcher matcher = creditsPattern.matcher(query);
		if (matcher.matches())
			return new CreditData(matcher.group(1), matcher.group(2));
		return new CreditData("", "");
	}

	public boolean isConversionQuery(String query) {
		Matcher matcher = conversionPattern.matcher(query);
		return matcher.matches();
	}

}

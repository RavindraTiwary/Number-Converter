package galaxy.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RomanRuleNumberTranslator {

	protected List<String> number;
	protected HashMap<String, Integer> numberUnities;
	private int computationIndex;

	public RomanRuleNumberTranslator(String number) {
		this(number, new RomanRuleNumberContextProvider());
	}
	
	public RomanRuleNumberTranslator(String number, RomanRuleNumberContextProvider contextProvider) {
		this.tokenizeNumber(number);
		this.numberUnities = contextProvider.getContextUnits();
	}

	protected void tokenizeNumber(String number) {
		this.number = new ArrayList<String>();
		for (char token : number.toCharArray()) {
			this.number.add(""+token);
		}
	}


	public int compute() {
		int arabic = 0;
		computationIndex = 0;
		for (; computationIndex < number.size(); computationIndex++){
			arabic = subtractFromNextIfNecessary(arabic);				
			arabic += arabicValue(computationIndex);			
		}
		return arabic;
	}

	private int subtractFromNextIfNecessary(int arabic) {
		int next = computationIndex + 1;
		if (next < number.size() && arabicValue(computationIndex) < arabicValue(next)){
			arabic -= arabicValue(computationIndex);
			computationIndex++;
		}
		return arabic;
	}

	private Integer arabicValue(int index) {
		return numberUnities.get(number.get(index));
	}

}

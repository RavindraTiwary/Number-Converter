package galaxy.number;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GalaxyRuleNumberContextProviderTest {

	private HashMap<String, Integer> contextUnities;
	
	@Before
	public void setup() {
		RomanRuleNumberContextProvider galaxyContextProvider = new GalaxyRuleNumberContextProvider(new DefinitionParserMock(null));
		contextUnities = galaxyContextProvider.getContextUnits();
	}
	
	@Test
	public void glob() {		
		assertEquals(new Integer(1), contextUnities.get("glob"));
	}
	
	@Test
	public void prok() {
		assertEquals(new Integer(5), contextUnities.get("prok"));
	}
	
	@Test
	public void pish() {
		assertEquals(new Integer(10), contextUnities.get("pish"));
	}	
	
	@Test
	public void tegj() {
		assertEquals(new Integer(50), contextUnities.get("tegj"));
	}
	
	
	class DefinitionParserMock extends DefinitionParser{
		
		public DefinitionParserMock(List<String> input) {
			super(input);
		}

		@Override
		public HashMap<String, String> getNumeral(){
			HashMap<String, String> numeral = new HashMap<String, String>();
			numeral.put("glob", "I");
			numeral.put("prok", "V");
			numeral.put("pish", "X");
			numeral.put("tegj", "L");
			return numeral;
		}
		
	}

}

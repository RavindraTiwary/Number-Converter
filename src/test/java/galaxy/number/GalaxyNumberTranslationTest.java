package galaxy.number;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class GalaxyNumberTranslationTest {

	@Test
	public void translateGlob() {
		RomanRuleNumberTranslator translator = new GalaxyRuleNumberTranslator("glob", new GalaxyContextProviderMock());		
		assertEquals(1, translator.compute());
	}
	
	@Test
	public void translateProk() {
		RomanRuleNumberTranslator translator = new GalaxyRuleNumberTranslator("prok", new GalaxyContextProviderMock());		
		assertEquals(5, translator.compute());
	}
	
	@Test
	public void translatePish() {
		RomanRuleNumberTranslator translator = new GalaxyRuleNumberTranslator("pish", new GalaxyContextProviderMock());		
		assertEquals(10, translator.compute());
	}
	
	@Test
	public void translateTegj() {
		RomanRuleNumberTranslator translator = new GalaxyRuleNumberTranslator("tegj", new GalaxyContextProviderMock());		
		assertEquals(50, translator.compute());
	}
	
	@Test
	public void translatePishTegjGlobGlob() throws Exception {
		RomanRuleNumberTranslator translator = new GalaxyRuleNumberTranslator("pish tegj glob glob", new GalaxyContextProviderMock());		
		assertEquals(42, translator.compute());
	}
	
	class GalaxyContextProviderMock extends RomanRuleNumberContextProvider{
		@Override
		public HashMap<String, Integer> getContextUnits() {
			HashMap<String, Integer> context = new HashMap<String, Integer>();
			context.put("glob", 1);
			context.put("prok", 5);
			context.put("pish", 10);
			context.put("tegj", 50);
			return context;
		}
	}

}

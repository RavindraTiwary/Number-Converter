package galaxy.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumberTranslationTest {

	@Test
	public void translateI() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("I");
		assertEquals(1, translator.compute());
	}

	@Test
	public void translateV() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("V");
		assertEquals(5, translator.compute());
	}
	
	@Test
	public void translateX() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("X");
		assertEquals(10, translator.compute());
	}
	
	@Test
	public void translateL() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("L");
		assertEquals(50, translator.compute());
	}
	
	@Test
	public void translateC() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("C");
		assertEquals(100, translator.compute());
	}
	
	@Test
	public void translateD() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("D");
		assertEquals(500, translator.compute());
	}
	
	@Test
	public void translateM() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("M");
		assertEquals(1000, translator.compute());
	}
	
	@Test
	public void translateIII() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("III");
		assertEquals(3, translator.compute());
	}
	
	@Test
	public void translateXXX() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("XXX");
		assertEquals(30, translator.compute());
	}
	
	@Test
	public void translateCCC() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("CCC");
		assertEquals(300, translator.compute());
	}
	
	@Test
	public void translateMMM() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("MMM");
		assertEquals(3000, translator.compute());
	}
	
	@Test
	public void translateIV() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("IV");
		assertEquals(4, translator.compute());
	}
	
	@Test
	public void translateIX() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("IX");
		assertEquals(9, translator.compute());
	}
	
	@Test
	public void translateXL() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("XL");
		assertEquals(40, translator.compute());
	}
	
	@Test
	public void translateXC() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("XC");
		assertEquals(90, translator.compute());
	}
	
	@Test
	public void translateCD() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("CD");
		assertEquals(400, translator.compute());
	}
	
	@Test
	public void translateCM() {
		RomanRuleNumberTranslator translator = new RomanRuleNumberTranslator("CM");
		assertEquals(900, translator.compute());
	}
			
}

package galaxy.number;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

public class DefinitionParserTest {
	
	private static HashMap<String, String> numeral;
	private static HashMap<CreditData, Double> credits;
	
	@BeforeClass
	public static void setup(){
		DefinitionParser parser = new DefinitionParser(Arrays.asList("glob is I", "prok is V", "pish is X", "tegj is L",
				"hnga is C",
				"glob glob Silver is 34 Credits", "glob prok Gold is 57800 Credits", "pish pish Iron is 3910 Credits"));
		numeral = parser.getNumeral();
		credits = parser.getCredits();
	}

	@Test
	public void globNumeral() {
		assertEquals("I", numeral.get("glob"));
	}

	@Test
	public void prokNumeral() {
		assertEquals("V", numeral.get("prok"));
	}
	
	@Test
	public void pishNumeral() {
		assertEquals("X", numeral.get("pish"));
	}
	
	@Test
	public void tegjNumeral() {
		assertEquals("L", numeral.get("tegj"));
	}
	
	@Test
	public void hngaNumeral() {
		assertEquals("C", numeral.get("hnga"));
	}
	
	@Test
	public void silverCredits() {
		assertEquals(new Double(34), credits.get(new CreditData("glob glob", "Silver")));
	}

	@Test
	public void goldCredits() {
		assertEquals(new Double(57800), credits.get(new CreditData("glob prok", "Gold")));
	}
	
	@Test
	public void ironCredits() {
		assertEquals(new Double(3910), credits.get(new CreditData("pish pish", "Iron")));
	}
	
}

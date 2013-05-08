package galaxy.number;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TranslatorLoaderTest {

	private DefinitionParser definitionParser;
	private HashMap<String, String> numeral;
	private HashMap<CreditData, Double> credits;
	private List<String> queries;

	@Before
	public void setup() throws FileNotFoundException {
		TranslatorLoader loader = new TranslatorLoader(
				new FileInputStream(
						"src\\test\\resources\\input.txt"));
		definitionParser = loader.getDefinitionParser();
		numeral = definitionParser.getNumeral();
		credits = definitionParser.getCredits();
		queries = loader.getQueries();
	}

	@Test
	public void getDefinitionGlob() throws FileNotFoundException {
		assertEquals("I", numeral.get("glob"));
	}

	@Test
	public void getDefinitionProk() throws FileNotFoundException {
		assertEquals("V", numeral.get("prok"));
	}

	@Test
	public void getDefinitionPish() throws FileNotFoundException {
		assertEquals("X", numeral.get("pish"));
	}

	@Test
	public void getDefinitionTegj() throws FileNotFoundException {
		assertEquals("L", numeral.get("tegj"));
	}

	@Test
	public void getDefinitionSilver() throws FileNotFoundException {
		assertEquals(new Double(34.0), credits.get(new CreditData("glob glob", "Silver")));
	}

	@Test
	public void getDefinitionGold() throws FileNotFoundException {
		assertEquals(new Double(57800.0), credits.get(new CreditData("glob prok", "Gold")));
	}

	@Test
	public void getDefinitionIron() throws FileNotFoundException {
		assertEquals(new Double(3910.0), credits.get(new CreditData("pish pish", "Iron")));
	}

	@Test
	public void getQueries() throws FileNotFoundException {
		assertEquals(
				Arrays.asList("how much is pish tegj glob glob ?",
						"how many Credits is glob prok Silver ?",
						"how many Credits is glob prok Gold ?",
						"how many Credits is glob prok Iron ?",
						"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"),
				queries);
	}

}

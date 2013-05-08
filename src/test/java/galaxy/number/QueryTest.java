package galaxy.number;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class QueryTest {
	
	

	private DefinitionParser definitionParser;
	private QueryValidation queryValidation;
	
	@Before
	public void setup(){
		definitionParser = new DefinitionParser(Arrays.asList("glob is I", "prok is V", "pish is X", "tegj is L",
				"glob glob Silver is 34 Credits", "glob prok Gold is 57800 Credits", "pish pish Iron is 3910 Credits"));
		queryValidation = new QueryValidation();
	}

	@Test
	public void invalidQuery() {		
		assertEquals("I have no idea what you are talking about", 
				Query.create(definitionParser, queryValidation, "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?").ask());
	}
	
	@Test
	public void numberQuery() {		
		assertEquals("pish tegj glob glob is 42", 
				Query.create(definitionParser, queryValidation, "how much is pish tegj glob glob ?").ask());
	}

	@Test
	public void silverQuery() {		
		assertEquals("glob prok Silver is 68 Credits", 
				Query.create(definitionParser, queryValidation, "how many Credits is glob prok Silver ?").ask());
	}
	
	@Test
	public void goldQuery() {		
		assertEquals("glob prok Gold is 57800 Credits", 
				Query.create(definitionParser, queryValidation, "how many Credits is glob prok Gold ?").ask());
	}
	
	@Test
	public void ironQuery() {		
		assertEquals("glob prok Iron is 782 Credits", 
				Query.create(definitionParser, queryValidation, "how many Credits is glob prok Iron ?").ask());
	}
}

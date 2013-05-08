package galaxy.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueryValidationTest {

	@Test
	public void number() {
		assertTrue(new QueryValidation().isNumberQuery("how much is pish tegj glob glob ?"));		
	}
	
	@Test
	public void getNumber() {
		assertEquals("pish tegj glob glob", new QueryValidation().getNumber("how much is pish tegj glob glob ?"));		
	}
	
	@Test
	public void conversion() throws Exception {
		assertTrue(new QueryValidation().isConversionQuery("how many Silver is glob Gold ?"));
	}
	
	@Test
	public void silver() {
		assertTrue(new QueryValidation().isCreditsQuery("how many Credits is glob prok Silver ?"));		
	}
	
	@Test
	public void getSilver() {
		assertEquals(new CreditData("glob prok", "Silver"), new QueryValidation().getCredits("how many Credits is glob prok Silver ?"));		
	}
	
	@Test
	public void gold() {
		assertTrue(new QueryValidation().isCreditsQuery("how many Credits is glob prok Gold ?"));		
	}
	
	@Test
	public void getGold() {
		assertEquals(new CreditData("glob prok", "Gold"), new QueryValidation().getCredits("how many Credits is glob prok Gold ?"));		
	}
	
	@Test
	public void iron() {
		assertTrue(new QueryValidation().isCreditsQuery("how many Credits is glob prok Iron ?"));		
	}
	
	@Test
	public void getIron() {
		assertEquals(new CreditData("glob prok", "Iron"), new QueryValidation().getCredits("how many Credits is glob prok Iron ?"));		
	}
	
	@Test
	public void woodchuck() {
		assertFalse(new QueryValidation().isCreditsQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));		
		assertFalse(new QueryValidation().isNumberQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
		assertFalse(new QueryValidation().isValidQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}

}

package testSelenium;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class testPosition {

	@Test
	void test() {
		positionTest p = new positionTest();
		
		String s = p.positionT("a", "a");
		assertEquals("Your current position", s);
	}

}

package Application;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalcTest {

	Calculator calc = new Calculator();
	
	@Test
	public void testAddition() {

		String input = "2+2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("4.0", actual);
	}

	@Test
	public void testSubtraction() {
		String input = "3-1";
		String actual = calc.calculateExpression(input);
		
		assertEquals("2.0", actual);
	}
	
	@Test
	public void testMultiplication() {
		String input = "3*2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("6.0", actual);
	}
	
	@Test
	public void testAdditionAndSubtraction() {
		String input = "3+7-1";
		String actual = calc.calculateExpression(input);
		
		assertEquals("9.0", actual);
	}
	
	@Test
	public void testAdditionAndMultiplication() {
		String input = "3+7*2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("17.0", actual);
	}
	
	@Test
	public void testAdditionAndDivision() {
		String input = "3+7/2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("6.5", actual);
	}
	
	@Test
	public void testSubtractionAndMultiplication() {
		String input = "3-7*2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("-11.0", actual);
	}
	
	@Test
	public void testSubtractionAndDivision() {
		String input = "3-7*2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("-11.0", actual);
	}
	
	@Test
	public void testDivision() {
		String input = "4/2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("2.0", actual);
	}
	
	@Test
	public void testMultipleOperators() {
		String input = "3-7*5";
		String actual = calc.calculateExpression(input);
		
		assertEquals("-32.0", actual);
	}
	
	@Test
	public void testModulus() {
		String input = "2%11";
		String actual = calc.calculateExpression(input);
		
		assertEquals("2.0", actual);
	}
}

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
	public void testMultipleAdditionSigns() {
		String input = "2+2+5+2+3+1+9";
		String actual = calc.calculateExpression(input);
		
		assertEquals("24.0", actual);
	}

	@Test
	public void testSubtraction() {
		String input = "3-1";
		String actual = calc.calculateExpression(input);
		
		assertEquals("2.0", actual);
	}
	
	@Test
	public void testMultipleSubtractionSigns() {
		String input = "3-1-3-7-9-2-3-7-5";
		String actual = calc.calculateExpression(input);
		
		assertEquals("-34.0", actual);
	}
	
	@Test
	public void testMultiplication() {
		String input = "3*2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("6.0", actual);
	}
	
	@Test
	public void testMutipleMultiplicationSigns() {
		String input = "3*2*3*7*9";
		String actual = calc.calculateExpression(input);
		
		assertEquals("1134.0", actual);
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
	public void testMultipleOperators2() {
		String input = "4+3-2*5+4";
		String actual = calc.calculateExpression(input);
		
		assertEquals("1.0", actual);
	}
	
	@Test
	public void testMultipleOperators3() {
		String input = "5+6/2*2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("11.0", actual);
	}
	
	@Test
	public void testMultipleOperators4() {
		String input = "7*6/2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("21.0", actual);
	}
	
	@Test
	public void testMultipleOperators5() {
		String input = "5*4+7-3*0+4-10";
		String actual = calc.calculateExpression(input);
		
		assertEquals("21.0", actual);
	}
	
	@Test
	public void testMultipleOperators6() {
		String input = "5*4-5-3*6+2-5*2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("-11.0", actual);
	}
	
	@Test
	public void testMultipleOperators7() {
		String input = "4-5+3*5+2/5-1";
		String actual = calc.calculateExpression(input);
		
		assertEquals("13.4", actual);
	}
	
	@Test
	public void testMultipleOperators8() {
		String input = "11%3+3-4*5%2";
		String actual = calc.calculateExpression(input);
		
		assertEquals("5.0", actual);
	}

	@Test
	public void testModulus() {
		String input = "2%11";
		String actual = calc.calculateExpression(input);
		
		assertEquals("2.0", actual);
	}
}

package Application;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

public class Calculator {

//	Calculator main method
	public String calculateExpression(String expression){
//		Double result variable
		double dres = 0.0;
		
//		Temporary variables
		double num1 = 0.0;
		double tempres = 0.0;
		
//		Splitting whole string
		String[] split = expression.split("(?=[%*/+-])|(?<=[%*/+-])");
		
//		If string contains *,/,% then run this loop below, otherwise go to next loop
		if (expression.contains("*") || expression.contains("/") || expression.contains("%")) {
			for (int i = 1; i < split.length; i+= 2) {
//				op = getting all the operators
				String op = split[i];
//				num = getting all the number
				double num = Double.parseDouble(split[i+1]);
				
					switch (op) {
					case "*":
//						if index - 2 contains "%" run these if statements
						if (i > 2 && split.length != i+2) {
							if (split[i+2].contains("%")) {
								if (split[i-2].contains("-")) {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, -num);
								} else {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, num);
								}

//						if index - 2 contains "-" run these if statements
							} else if (split[i-2].contains("-")) {
								if (dres != 0.0 && split.length-2 != i) {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, -num);
									dres += tempres;
								} else if (dres != 0.0 && split.length-2 == i) {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, -num);
									dres += tempres;
								} else if (dres == 0.0) {
									dres = Double.parseDouble(split[i-1]);
									dres = Multiplication(-dres, num);
								}	
							} else {
								if (dres != 0.0 && split.length-2 != i) {
									dres = Multiplication(dres, num);
								} else if (dres != 0.0 && split.length-2 == i) {
									dres = Multiplication(dres, num);
								} else if (dres == 0.0) {
									dres = Double.parseDouble(split[i-1]);
									dres = Multiplication(dres, num);
								}	
							}

//							if index - 2 contains "-" run these if statements
						} else if (split.length > 3 && split.length != i-2 && i != 1) {
							if (split[i-2].contains("-")) {
								if (dres != 0.0 && split.length-2 != i) {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, -num);
									dres += tempres;
								} else if (dres != 0.0 && split.length-2 == i) {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, -num);
									dres += tempres;
								} else if (dres == 0.0) {
									dres = Double.parseDouble(split[i-1]);
									dres = Multiplication(-dres, num);
								}	
							} else {
								if (dres != 0.0 && split.length-2 != i) {
									dres = Multiplication(dres, num);
								} else if (dres != 0.0 && split.length-2 == i) {
									dres = Multiplication(dres, num);
								} else if (dres == 0.0) {
									dres = Double.parseDouble(split[i-1]);
									dres = Multiplication(dres, num);
								}	
							}
						} else {
							if (dres != 0.0 && split.length-2 != i) {
								dres = Multiplication(dres, num);
							} else if (dres != 0.0 && split.length-2 == i) {
								dres = Multiplication(dres, num);
							} else if (dres == 0.0) {
								dres = Double.parseDouble(split[i-1]);
								dres = Multiplication(dres, num);
							}	
						}
						break;
					case "/":

//						if index - 2 contains "/" run this if statements
						if (split.length > 3 && i != 1) {
							if (split[i-2].contains("/")) {
								dres = Division(dres, num);
//						if index - 2 contains "*" run this if statements else do the regular once
							}else if (split[i-2].contains("*")) {
								dres = Division(dres, num);
							}else if (dres != 0.0 && split.length-2 != i) {
								num1 = Double.parseDouble(split[i-1]);
								tempres = Division(num1, num);
								dres += tempres;
							}else if (dres != 0.0 && split.length-2 == i) {
								num1 = Double.parseDouble(split[i-1]);
								tempres = Division(num1, num);
								dres += tempres;
							}else if (dres == 0.0) {
								dres = Double.parseDouble(split[i-1]);
								dres = Division(dres, num);
							}
						}
						else if (dres != 0.0 && split.length-2 != i) {
							num1 = Double.parseDouble(split[i-1]);
							tempres = Division(num1, num);
							dres += tempres;
						}else if (dres != 0.0 && split.length-2 == i) {
							num1 = Double.parseDouble(split[i-1]);
							tempres = Division(num1, num);
							dres += tempres;
						}else if (dres == 0.0) {
							dres = Double.parseDouble(split[i-1]);
							dres = Division(dres, num);
						}
						break;
					case "%":
						
						if (i > 2) {			
//							if index - 2 contains "*" run these if statements
							if (split[i-2].contains("*")) {
								tempres = Modulus(tempres, num);
								dres += tempres;
							}
						}else if (dres != 0.0 && split.length-2 != i) {
							num = Double.parseDouble(split[i-1]);
							dres = Modulus(dres, num);
						}else if (dres != 0.0 && split.length-2 == i) {
							dres = Modulus(dres, num);
						}else if (dres == 0.0) {
							dres = Double.parseDouble(split[i-1]);
							dres = Modulus(dres, num);
						}
						break;
					default:
						break;
					}
			}
		}
		for (int i = 1; i < split.length; i+= 2) {
			String op = split[i];
			if (expression.contains("--")) {
				System.out.println("--");
			}
			double num = Double.parseDouble(split[i+1]);
				switch (op) {
				case "+":
					if (split.length > 5 && split.length != i+2 && i != 1) {
//						if following condition is met, the number skips since it has already been in used.
						if (split[i+2].contains("*") && split[i-2].contains("*") || split[i+2].contains("/") && split[i-2].contains("/") || split[i+2].contains("/") && split[i-2].contains("*") || split[i+2].contains("*") && split[i-2].contains("/")) {
							break;
						} else if(split[i+2].contains("*")){
							break;
						} else if (dres != 0.0 && i != 1) {
							dres = Addition(dres, num);
						} else if (dres == 0.0) {
							dres = Double.parseDouble(split[i-1]);
							dres = Addition(dres, num);
						} else if (dres != 0.0 && i == 1) {
							num = Double.parseDouble(split[i-1]);
							dres = Addition(dres, num);
						}
						
					}
					else if (dres != 0.0 && i != 1) {
						dres = Addition(dres, num);
					} else if (dres == 0.0) {
						dres = Double.parseDouble(split[i-1]);
						dres = Addition(dres, num);
					} else if (dres != 0.0 && i == 1) {
						num = Double.parseDouble(split[i-1]);
						dres = Addition(dres, num);
					}
				break;
				case "-":
//					if index + 1 contains "-" run these if statements
					if (split[i+1] == "-") {
						if (dres != 0.0 && i != 1) {
							num = Double.parseDouble(split[i-1]);
							dres = Addition(dres, num);
						} else if (dres == 0.0) {
							dres = Double.parseDouble(split[i-1]);
							dres = Addition(dres, num);
						} else if (dres != 0.0 && i == 1) {
							num = Double.parseDouble(split[i-1]);
							dres = Addition(dres, num);
						}
					}
//					if following condition is met, the number skips since it has already been in used.
					if (split.length > 3 && i > 4 && expression.contains("*") && split.length != i+2) {
						if (split[i+2].contains("*") && split[i-4].contains("*")) {
							break;
						} else if (split[i+2].contains("*")) {
							break;
						}
					}
					
					if (split.length > 3 && split.length != i+2) {

//						if index + 2 contains "*" run these if statements
						if (split[i+2].contains("*")) {
							if (dres != 0.0 && i != 1) {
								num = Double.parseDouble(split[i-1]);
								dres = Addition(dres, num);
							} else if (dres == 0.0) {
								dres = Double.parseDouble(split[i-1]);
								dres = Addition(dres, num);
							} else if (dres != 0.0 && i == 1) {
								num = Double.parseDouble(split[i-1]);
								dres = Addition(dres, num);
							}
						} else {
							if (dres != 0.0 && i == 1) {
								num1 = Double.parseDouble(split[i-1]);
								tempres = Subtraction(num1, num);
								dres += tempres;
							} else if (dres != 0.0 && split.length-2 != i) {
								dres = Subtraction(dres, num);
							} else if (dres != 0.0 && split.length-2 == i) {
								dres = Subtraction(dres, num);
							} else if (dres == 0.0) {
								dres = Double.parseDouble(split[i-1]);
								dres = Subtraction(dres, num);
							}	
						}
					} else {
						if (dres != 0.0 && i != 1) {			
							dres = Subtraction(dres, num);
						} else if (dres == 0.0) {
							dres = Double.parseDouble(split[i-1]);
							dres = Subtraction(dres, num);
						} else if (dres != 0.0 && i == 1) {
							num = Double.parseDouble(split[i-1]);
							dres = Subtraction(dres, num);
						}
					}	
					break;
				default:
					break;
				}
			}
		
//		Converting double result to string result and returning as string.
		String res = Double.toString(dres);
		return res;
	}
	
//	Addition method
	public double Addition(double d1,double d2) {
		return d1+d2;	
	}
	
//	Subtraction method
	public double Subtraction(double d1, double d2) {
		return d1-d2;
	}
	
//	Multiplication method
	public double Multiplication(double d1, double d2) {
		return d1*d2;
	}
	
//	Division method
	public double Division(double d1, double d2) {
		if (d2 == 0) {
			throw new ArithmeticException();
		}
		return d1/d2;
	}
	
//	Modulus method
	public double Modulus(double d1, double d2) {
		return d1%d2;
	}
}

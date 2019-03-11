package Application;

import java.sql.Connection;

public class Calculator {

//	Calculator main mehotde
	public String calculateExpression(String expression){
		double dres = 0.0;
		double num1 = 0.0;
		double tempres = 0.0;
		String[] split = expression.split("(?=[%*/+-])|(?<=[%*/+-])");
		if (expression.contains("*") || expression.contains("/") || expression.contains("%")) {
			System.out.println(split.length);
			for (int i = 1; i < split.length; i+= 2) {
				String op = split[i];
				double num = Double.parseDouble(split[i+1]);
				
					switch (op) {
					case "*":
						if (i > 2 && split.length != i+2) {
							if (split[i+2].contains("%")) {
								if (split[i-2].contains("-")) {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, -num);
								} else {
									num1 = Double.parseDouble(split[i-1]);
									tempres = Multiplication(num1, num);
								}
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
						if (split.length > 3) {
							if (split[i-2].contains("*")) {
								dres = Division(dres, num);
							}	else if (dres != 0.0 && split.length-2 != i) {
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
			double num = Double.parseDouble(split[i+1]);
				switch (op) {
				case "+":
					if (split.length > 5 && split.length != i+2 && i != 1) {
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
					if (split.length > 3 && i > 4 && expression.contains("*") && split.length != i+2) {
						if (split[i+2].contains("*") && split[i-4].contains("*")) {
							break;
						} else if (split[i+2].contains("*")) {
							break;
						}
					}
					
					if (split.length > 3 && split.length != i+2) {

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
		String res = Double.toString(dres);
		return res;
	}
	
	public double Addition(double d1,double d2) {
		return d1+d2;
		
	}
	
	public double Subtraction(double d1, double d2) {
		return d1-d2;
	}
	
	public double Multiplication(double d1, double d2) {
		return d1*d2;
	}
	
	public double Division(double d1, double d2) {
		return d1/d2;
	}
	
	public double Modulus(double d1, double d2) {
		return d1%d2;
	}
}

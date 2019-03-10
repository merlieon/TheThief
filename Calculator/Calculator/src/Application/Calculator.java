package Application;
public class Calculator {
	public String calculateExpression(String expression){
		double dres = 0.0;
		String[] split = expression.split("(?=[*/+-])|(?<=[*/+-])");
		for (int i = 1; i < split.length; i+= 2) {
			String op = split[i];
			double num = Double.parseDouble(split[i+1]);
				switch (op) {
				case "*":
					if (dres != 0.0 && split.length-2 != i) {
						num = Double.parseDouble(split[i-1]);
						dres = Multiplication(dres, num);
					} else if (dres != 0.0 && split.length-2 == i) {
						dres = Multiplication(dres, num);
					} else if (dres == 0.0) {
						dres = Double.parseDouble(split[i-1]);
						dres = Multiplication(dres, num);
					}	
				break;
				case "/":
					if (dres != 0.0 && split.length-2 != i) {
						num = Double.parseDouble(split[i-1]);
						dres = Division(dres, num);
					}else if (dres != 0.0 && split.length-2 == i) {
						dres = Division(dres, num);
					}else if (dres == 0.0) {
						dres = Double.parseDouble(split[i-1]);
						dres = Division(dres, num);
					}
					break;
				case "%":
					if (dres != 0.0 && split.length-2 != i) {
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
		for (int i = 1; i < split.length; i+= 2) {
			
			String op = split[i];
			double num = Double.parseDouble(split[i+1]);
				switch (op) {
				case "+":
					if (dres != 0.0 && split.length-2 != i) {
						num = Double.parseDouble(split[i-1]);
						dres = Addition(dres, num);
					} else if (dres != 0.0 && split.length-2 == i) {
						dres = Addition(dres, num);
					} else if (dres == 0.0) {
						dres = Double.parseDouble(split[i-1]);
						dres = Addition(dres, num);
					}
				break;
				case "-":
					if (dres != 0.0 && split.length-2 != i) {
						num = Double.parseDouble(split[i-1]);
						dres = Subtraction(dres, num);
					} else if (dres != 0.0 && split.length-2 == i) {
						dres = Subtraction(dres, num);
					} else if (dres == 0.0) {
						dres = Double.parseDouble(split[i-1]);
						dres = Subtraction(dres, num);
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

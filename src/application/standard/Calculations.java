package application.standard;

public class Calculations {
	public double calculate(double number1,double number2,String operator) {
		switch (operator) {
		case "+":
			return (number1 + number2);
		case "-":
			return (number1 - number2);
		case "×":
			return (number1 * number2);
		case "÷":
			if(number2 == 0)
				return 0;
			return (number1 / number2);
		case "%":
			return (number1%number2);
		default:
			return 0;
		}
	}
	public double calculate1(double n1,String operator) {
		switch(operator) {
		case "\u221A":
			return  Math.sqrt(n1);
		case "x²":
			return  Math.pow(n1, 2);
		case "1/x":
			return  Math.pow(n1, -1);
			
		}
		return 0;
		
	}
}

package application.resources;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler {
	public String value1 = "";
	public void handleLabel1Value(String lbl1) {
		if(lbl1 == "0")
			value1 = "";
		else
			value1 = lbl1;
	}
	public void handleLabel2Value(String lbl2) {
		if(lbl2 == "0")
			value1 = "";
		else
			value1 = lbl2;
	}

	public String handleDigitEvent(KeyEvent e) {

		// String event = e.getEventType().getName();
		KeyCode keycode = e.getCode();
		// System.out.println(event + ": Key Code=" + keycode.getName() + ", Text=" +
		// e.getText() + "\n");
		// System.out.println("keycode"+keycode.getName());
		if (keycode.getName().equals("Backspace")) {
			System.out.println("keycode" + keycode.getName());
			value1 = value1.substring(0, value1.length() - 1);
		}
		if (keycode.getName().equals("Enter")) {
			System.out.println("keycode" + keycode.getName());
			value1 = "";
		} else {
			switch (e.getText()) {
			case "0":
				value1 = value1 + e.getText();
				return value1;
		
			case "1":
				value1 = value1 + e.getText();
				return value1;
			case "2":
				value1 = value1 + e.getText();
				return value1;
			case "3":
				value1 = value1 + e.getText();
				return value1;
			case "4":
				value1 = value1 + e.getText();
				return value1;
			case "5":
				value1 = value1 + e.getText();
				return value1;
			case "6":
				value1 = value1 + e.getText();
				return value1;
			case "7":
				value1 = value1 + e.getText();
				return value1;
			case "8":
				value1 = value1 + e.getText();
				return value1;
			case "9":
				value1 = value1 + e.getText();
				return value1;
			case "+":
				value1 = "";
				return "+";
			case "-":
				value1 = "";
				return "-";
			case "*":
				value1 = "";
				return "×";
			case "/":
				value1 = "";
				return "÷";
			case ".":
				if(value1 == "0"||value1 == "") {
					value1 = "0." + value1;
					return value1;
				}
				if(!isInString(value1 , "."))
					return  value1;
				value1 = value1 + e.getText();
				return value1;
		
			// default:
			// n2 = Double.parseDouble(result.getText());
			// double output = calc.calculate(n1, n2, Operator);
			// result.setText(String.valueOf(output));
			// break;
			//

			}
		}
	
		return null;
	}
	private boolean isInString(String value12, String string) {
		if(value12.contains(".")) {
			return false;
		}
		return true;
	}
	public void setResultInVar(String text) {
		value1 = text;
	}
}

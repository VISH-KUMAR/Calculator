package application.standard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import application.resources.KeyHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class StandardController implements Initializable {
	@FXML
	private Label result;
	@FXML
	private GridPane gridPane;

	@FXML
	private AnchorPane rootPane, rootPane1;

	@FXML
	private JFXHamburger hamburger;
	@FXML
	private Label heading;

	@FXML
	private JFXDrawer drawer;
	private boolean start = true, operateDot = true;
	private String operator = "";
	private double n1, n2 , plusminus;
	String value = "";
	String number = "", value1 = "",Operator = "",Temp="",Temp1 = "",Temp2 = "";
	String Str;

	Calculations calc = new Calculations();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// JFXDepthManager.setDepth(rootPane, 3);
		try {
			VBox box = FXMLLoader.load(getClass().getResource("/application/resources/Functions.fxml"));
			drawer.setSidePane(box);

			for (Node node : box.getChildren()) {
				if (node.getAccessibleText() != null) {
					node.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
						AnchorPane pane;
						switch (node.getAccessibleText()) {
						case "Standard":

							try {
								pane = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
								rootPane1.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("CALCULATOR");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Temp":

							try {
								pane = FXMLLoader
										.load(getClass().getResource("/application/Temperature/Temperature.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("TEMPERATURE");

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Volume":

							try {
								pane = FXMLLoader.load(getClass().getResource("/application/Volume/Volume.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("VOLUME");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Angle":

							try {
								pane = FXMLLoader.load(getClass().getResource("/application/Angle/Angle.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("ANGLE");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Length":

							try {
								pane = FXMLLoader.load(getClass().getResource("/application/Length/Length.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("LENGTH");

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Area":

							try {
								pane = FXMLLoader.load(getClass().getResource("/application/Area/Area.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("AREA");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Data":

							try {
								pane = FXMLLoader.load(getClass().getResource("/application/Data/Data.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("DATA");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Speed":

							try {
								pane = FXMLLoader.load(getClass().getResource("/application/Speed/Speed.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("SPEED");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "Weight":

							try {
								pane = FXMLLoader.load(getClass().getResource("/application/Weight/Weight.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("WEIGHT");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;

						case "Programmer":
							try {
								pane = FXMLLoader.load(
										getClass().getResource("/application/programmerCalculator/Programmer.fxml"));
								rootPane.getChildren().setAll(pane);
								drawer.close();
								drawer.setDisable(true);
								heading.setText("PROGRAMMER");
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							break;
						}
					});
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
		burgerTask.setRate(-1);
		hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			burgerTask.setRate(burgerTask.getRate() * -1);
			burgerTask.play();
			if (drawer.isShown()) {
				drawer.close();
				drawer.setDisable(true);
			} else {
				drawer.open();
				drawer.setDisable(false);
			}
		});
		KeyHandler keyhandler  = new KeyHandler();
		gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				keyhandler.setResultInVar(result.getText());
				Str = keyhandler.handleDigitEvent(event);
				if(event.getCode().getName().equals("Backspace")) {
					System.out.println("key code is "+event.getCode().getName());
//					if(result.getText().length()<=1) {
//						result.setText("0");
//						Str = "";
//					}else {
//						result.setText(result.getText().substring(0, result.getText().length()-1));
//					}
					processDelOperation();
				}
				if(event.getCode().getName().equals("Enter")) {
					System.out.println("key code is "+event.getCode().getName());
					Temp2 = result.getText();
					processSecondNo(Temp2);
					//n2 = Double.parseDouble(Temp2);
					performCalculation(n1 , n2 , Temp1);
					
				}else {
		//		String Str = keyhandler.handleDigitEvent(event);
					if(Str == ".") {
						if (operateDot == true) {
							result.setText("0.");
							operateDot = false;
						}
					}
				if(Str == "+"||Str == "-"||Str == "×"||Str == "÷") {
					Temp = result.getText();
					result.setText("");
					processOperator(Temp , Str);

				}
			
				else if(Str != null && Str.equals(".")){
				//	result.setText(Str);
					if (!isInString(result.getText(), '.')) {
						result.setText(result.getText() + Str);
					}
				 else {
					result.setText(result.getText() + Str);
					operateDot = false;
				}
					}else {
						if(Str!=null)
							result.setText(Str);
					}
				}
			}

		});

	}
	public void performCalculation(double number1,double number2,String operator) {
		double output = calc.calculate(n1, n2, operator);
		result.setText(String.valueOf(output));
		operator = "";
	}

	@FXML
	void processNumbers(ActionEvent event) {

		if (start) {
			result.setText("");
			start = false;
		}
		String value = ((Button) event.getSource()).getText();

		if (value.equals(".")) {
			if (operateDot == true) {
				result.setText("0.");
				operateDot = false;
			}

		}
		if (value.equals(".")) {
			if (!isInString(result.getText(), '.')) {
				result.setText(result.getText() + value);
			}
		} else {
			result.setText(result.getText() + value);
			operateDot = false;
		}
	}

	private boolean isInString(String text, char c) {
		if (text.contains(".")) {
			return true;
		}
		return false;
	}

	@FXML
	void processsOperators(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		value1 = "";
		if (!value.equals("=")) {
			if (!operator.isEmpty())
				return;
		operator = value;
//			n1 = Double.parseDouble(result.getText());
			processOperator(result.getText(),operator);
			result.setText("");
		} else {
			if (operator.isEmpty())
				return;
		//	n2 = Double.parseDouble(result.getText());
			processSecondNo(result.getText());
			performCalculation(n1,n2,operator);
//			double output = calc.calculate(n1, n2, operator);
//			result.setText(String.valueOf(output));
//			operator = "";
			start = true;
		}
	}
	public void processOperator(String t ,  String o) {
		n1 = Double.parseDouble(t);
		Temp1 = o;
	}
	public void processSecondNo(String t) {
		n2 = Double.parseDouble(t);
		
	}

	@FXML
	void processSpecialOperation(ActionEvent ae) {
		String value = ((Button) ae.getSource()).getText();
		// if (!value.equals("=")) {
		// if (!operator.isEmpty())
		// return;
		// operator = value;
		if (result.getText().contains("-") && value == "\u221A") {
			result.setText("Invalid Input");
			return;
		}
		try {
			n1 = Double.parseDouble(result.getText());
			// n1 = Long.parseLong(result.getText()); ==>Number format exception in this
			// case
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		result.setText(String.valueOf(calc.calculate1(n1, value)));
		operator = "";
		start = true;
	}

	@FXML
	void processDelKey(ActionEvent ae) {
//		if (result.getText().length() <= 1) {
//			result.setText("0");
//			// result.setText(result.getText(0,result.getText().length()-1));
//			// result.setText(result.getText().substring(0, result.getText().length() - 1));
//		} else {
//			result.setText(result.getText().substring(0, result.getText().length() - 1));
//		}
		processDelOperation();
	}
public void processDelOperation() {
	if (result.getText().length() <= 1) {
		result.setText("0");
		// result.setText(result.getText(0,result.getText().length()-1));
		// result.setText(result.getText().substring(0, result.getText().length() - 1));
		Str = "";
	} else {
		result.setText(result.getText().substring(0, result.getText().length() - 1));
	}
}
	@FXML
	void processCKey(ActionEvent ae) {
		result.setText("0");
		start = true;
		operator = "";
		Str = "";
	}

	@FXML
	void processSignOperator(ActionEvent ae) {
		plusminus = Double.parseDouble(result.getText());
		plusminus = plusminus * (-1);
		result.setText(plusminus + "");
	}

//	protected void handleDigitEvent(KeyEvent e) {
//		
//		String event = e.getEventType().getName();
//		KeyCode keycode = e.getCode();
//		System.out.println(event + ": Key Code=" + keycode.getName() + ", Text=" + e.getText() + "\n");
//		if (start) {
//			switch (e.getText()) {
//			case "0":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "1":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "2":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "3":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "4":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "5":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "6":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "7":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "8":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "9":
//				value1 = value1 + e.getText();
//				result.setText(value1);
//				break;
//			case "+":
//				n1 = Double.parseDouble(result.getText());
//				result.setText("");
//				value1 = "";
//				Operator = "+";
//				break;
//			case "-":
//				n1 = Double.parseDouble(result.getText());
//				result.setText("");
//				value1 = "";
//				Operator = "-";
//				break;
//			case "*":
//				n1 = Double.parseDouble(result.getText());
//				result.setText("");
//				value1 = "";
//				Operator = "×";
//				break;
//			case "/":
//				n1 = Double.parseDouble(result.getText());
//				result.setText("");
//				value1 = "";
//				Operator = "÷";
//				break;
//			case "13":
//				n2 = Double.parseDouble(result.getText());
//				double output = calc.calculate(n1, n2, Operator);
//				result.setText(String.valueOf(output));
//				break;
				
//				default:
//					n2 = Double.parseDouble(result.getText());
//					double output = calc.calculate(n1, n2, Operator);
//					result.setText(String.valueOf(output));
//					break;
//					

//			}
//			if ( e.getCharacter() ) {
//				n2 = Double.parseDouble(result.getText());
//				double output = calc.calculate(n1, n2, Operator);
//				result.setText(String.valueOf(output));
//			}
//			
//		}
		// value1 = value1 + e.getText();
		// result.setText(value1);
	//}


	}



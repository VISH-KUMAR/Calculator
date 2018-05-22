package application.Length;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import application.resources.KeyHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class LengthController implements Initializable {
	@FXML
	private GridPane gridpane;
	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private JFXComboBox<String> combo1;
	private boolean start = true,operateDot = true;
	boolean lbl = true;
	String str = "";

	@FXML
	private JFXComboBox<String> combo2;
	ObservableList<String> list = FXCollections.observableArrayList("Kilometer", "Meter", "Centimeter", "Millimeter");
	Conversions calc = new Conversions();
	KeyHandler keyhandler = new KeyHandler();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combo1.setItems(list);
		combo2.setItems(list);
		combo1.setValue("Meter");
		combo2.setValue("Meter");
		
		gridpane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(lbl == true)
					keyhandler.handleLabel1Value(label1.getText());
				else
					keyhandler.handleLabel2Value(label2.getText());
				
				str = keyhandler.handleDigitEvent(event);
				if (event.getCode().getName().equals("Backspace")) {
					handleDelOperation();
					
				}
				if (lbl == true) {
					if (start == true) {
						label1.setText("");
						start = false;
					}
					if (str != null) {
						label1.setText(str);
						handlelabel2(label1.getText());
					}
				} else {
					if (start == true) {
						label2.setText("");
						start = false;
					}
					if (str != null) {
						label2.setText(str);
						handlelabel1(label2.getText());
					}

				}
			}
		});
	}

	public void handlelabel2(String s) {
		double n = Double.parseDouble(label1.getText());
		label2.setText(String.valueOf(calc.calculate(n, combo1.getValue(), combo2.getValue())));
	}

	public void handlelabel1(String s) {
		double n1 = Double.parseDouble(label2.getText());
		label1.setText(String.valueOf(calc.calculate(n1, combo2.getValue(), combo1.getValue())));
	}

	@FXML
	public void processNumbers(ActionEvent ae) {
		label1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = true;
		});
		label2.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = false;
		});

		if (lbl == true) {
			if (start) {
				label1.setText("");
				start = false;
			}
			String value = ((Button) ae.getSource()).getText();
			if(value.equals(".")) {
				if(operateDot == true) {
					label1.setText("0.");
					operateDot = false;
				}
				if (!isInString(label1.getText())) {
					label1.setText(label1.getText() + value);
				}
			}
			else {
			label1.setText(label1.getText() + value);
			// double n = Double.parseDouble(label1.getText());
			// label2.setText(String.valueOf(calc.calculate(n, combo1.getValue(),
			// combo2.getValue())));
			handlelabel2(label1.getText());
			}
		} else {
			if (start) {
				label2.setText("");
				start = false;
			}
			String value = ((Button) ae.getSource()).getText();
			if(value.equals(".")) {
				if(operateDot == true) {
					label2.setText("0.");
					operateDot = false;
				}
				if (!isInString(label1.getText())) {
					label2.setText(label2.getText() + value);
				}
			}
			else {
			label2.setText(label1.getText() + value);
			// double n1 = Double.parseDouble(label1.getText());
			// label1.setText(String.valueOf(calc.calculate(n1, combo1.getValue(),
			// combo2.getValue())));
			handlelabel1(label2.getText());
			}
		}

	}
	public boolean isInString(String a) {
		if(a.contains(".")) {
			return true;
		}
		return false;
	}

	@FXML
	void comboChanged1(ActionEvent event) {
		if (lbl == true) {
			// double n = Double.parseDouble(label1.getText());
			// label2.setText(String.valueOf(calc.calculate(n, combo1.getValue(),
			// combo2.getValue())));
			handlelabel2(label1.getText());
		} else {
			// double n1 = Double.parseDouble(label1.getText());
			// label1.setText(String.valueOf(calc.calculate(n1, combo2.getValue(),
			// combo1.getValue())));
			handlelabel1(label2.getText());
			
		}
	}

	@FXML
	public void handleCEKey(ActionEvent ae) {
		label1.setText("0");
		label2.setText("0");
		str = "";
		start = true;
	}

	@FXML
	void processDelKey(ActionEvent ae) {
		handleDelOperation();
	}

	public void handleDelOperation() {
		if (lbl) {
			if (label1.getText().length() <= 1) {
				label1.setText("0");
				label2.setText("0");
				start = true;
				str = "0";

			} else {
				label1.setText(label1.getText().substring(0, label1.getText().length() - 1));
				label2.setText(String.valueOf(
						calc.calculate(Double.parseDouble(label1.getText()), combo1.getValue(), combo2.getValue())));

			}
		} else {
			if (label2.getText().length() <= 1) {
				label2.setText("0");
				label1.setText("0");
				start = true;
				str = "0";

			} else {
				label2.setText(label2.getText().substring(0, label2.getText().length() - 1));
				label1.setText(String.valueOf(
						calc.calculate(Double.parseDouble(label2.getText()), combo2.getValue(), combo1.getValue())));

			}
		}
	}
}

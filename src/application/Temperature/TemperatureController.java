package application.Temperature;

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

public class TemperatureController implements Initializable {
	@FXML
	private Label label1;

	@FXML
	private Label label2;
	@FXML
	private GridPane gridPane;

	@FXML
	private JFXComboBox<String> combo1;

	@FXML
	private JFXComboBox<String> combo2;
	public boolean start = true;
	public boolean lbl = true,operateDot = true;
	public double n1, n2, n3,n;
	public String Str = "",str = "";
	Calculations calc = new Calculations();
	ObservableList<String> list = FXCollections.observableArrayList("°C", "°F", "Kelvin");
	KeyHandler keyhandler = new KeyHandler();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combo1.setItems(list);
		combo2.setItems(list);
		combo1.setValue("°C");
		combo2.setValue("°C");
		gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (lbl == true)
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

	@FXML
	void changedCombo(ActionEvent event) {
		if (lbl == true) {
//			n1 = Double.parseDouble(label1.getText());
//			label2.setText(String.valueOf(calc.temperatureConversion(n1, combo1.getValue(), combo2.getValue())));
			handlelabel2(label1.getText());
		} else {
//			n2 = Double.parseDouble(label2.getText());
//			label1.setText(String.valueOf(calc.temperatureConversion(n2, combo2.getValue(), combo1.getValue())));
			handlelabel1(label2.getText());
		}
	}

	@FXML
	void processCEKey(ActionEvent event) {
		label1.setText("0");
		label2.setText("0");
		start = true;
	}

	@FXML
	void processDigitKeys(ActionEvent event) {
		label1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = true;
		});
		label2.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = false;
		});
		if (lbl) {
			if (start) {
				label1.setText("");
				start = false;
			}
			String value = ((Button) event.getSource()).getText();
			if (value.equals(".")) {
				if (operateDot == true) {
					label1.setText("0.");
					operateDot = false;
				}
				if (!isInString(label1.getText())) {
					label1.setText(label1.getText() + value);
				}
			} else {
				label1.setText(label1.getText() + value);
//				n1 = Double.parseDouble(label1.getText());
//				label2.setText(String.valueOf(calc.tempetatureConversion(n1, combo1.getValue(), combo2.getValue())));
				handlelabel2(label1.getText());
			}
		} else {
			if (start) {
				label2.setText("");
				start = false;
			}
			String value = ((Button) event.getSource()).getText();
			if (value.equals(".")) {
				if (operateDot == true) {
					label1.setText("0.");
					operateDot = false;
				}
				if (!isInString(label1.getText())) {
					label1.setText(label1.getText() + value);
				}
			} else {
				label2.setText(label2.getText() + value);
//				n2 = Double.parseDouble(label1.getText());
//				label1.setText(String.valueOf(calc.tempetatureConversion(n2, combo2.getValue(), combo1.getValue())));
				handlelabel1(label2.getText());
			}
		}
	}

	@FXML
	void processDelKey(ActionEvent ae) {
		// if (lbl) {
		// if (label1.getText().length() > 1) {
		// label1.setText(label1.getText().substring(0, label1.getText().length() - 1));
		// label2.setText(String.valueOf(calc.tempetatureConversion(Double.parseDouble(label1.getText()),
		// combo1.getValue(), combo2.getValue())));
		//
		// } else {
		// label1.setText("0");
		// if (label1.getText().contains("-") && label1.getText().length() == 1)
		// label2.setText(String.valueOf(calc.tempetatureConversion(0,
		// combo1.getValue(), combo2.getValue())));
		// label2.setText(String.valueOf(calc.tempetatureConversion(Double.parseDouble(label1.getText()),
		// combo1.getValue(), combo2.getValue())));
		//
		// }
		// } else {
		// if (label2.getText().length() > 1) {
		// label2.setText(label2.getText().substring(0, label2.getText().length() - 1));
		// label1.setText(String.valueOf(calc.tempetatureConversion(Double.parseDouble(label2.getText()),
		// combo1.getValue(), combo2.getValue())));
		//
		// } else {
		// label2.setText("0");
		// if (!label2.getText().contains("-"))
		// label1.setText(String.valueOf(calc.tempetatureConversion(Double.parseDouble(label2.getText()),
		// combo1.getValue(), combo2.getValue())));
		//
		// }
		// }
		handleDelOperation();
	}

	@FXML
	void processSignOperator(ActionEvent ae) {
		if (lbl) {
			n3 = Double.parseDouble(label1.getText());
			n3 = n3 * (-1);
			label1.setText(n3 + "");
			label2.setText(String.valueOf(calc.temperatureConversion(n3, combo1.getValue(), combo2.getValue())));

		} else {
			n3 = Double.parseDouble(label1.getText());
			n3 = n3 * (-1);
			label2.setText(n3 + "");
			label1.setText(String.valueOf(calc.temperatureConversion(n3, combo1.getValue(), combo2.getValue())));

		}
	}

	public boolean isInString(String a) {
		if (a.contains(".")) {
			return true;
		}
		return false;
	}

	protected void handleDelOperation() {
		if (lbl) {
			if (label1.getText().length() > 1) {
				label1.setText(label1.getText().substring(0, label1.getText().length() - 1));
				label2.setText(String.valueOf(calc.temperatureConversion(Double.parseDouble(label1.getText()),
						combo1.getValue(), combo2.getValue())));

			} else {
				System.out.println("this is in else case of backspace");
				label1.setText("0");
				label2.setText("0");
				Str = "0";
				start = true;

			}
		} else {
			if (label2.getText().length() > 1) {
				label2.setText(label2.getText().substring(0, label2.getText().length() - 1));
				label1.setText(String.valueOf(calc.temperatureConversion(Double.parseDouble(label2.getText()),
						combo1.getValue(), combo2.getValue())));

			} else {
				label2.setText("0");
				label1.setText("0");
				Str = "0";
				start = true;
			}
		}
	}

	protected void handlelabel1(String text) {
		n = Double.parseDouble(label2.getText());
		label1.setText(String.valueOf(calc.temperatureConversion(n, combo2.getValue(), combo1.getValue())));
	}

	protected void handlelabel2(String text) {
		n = Double.parseDouble(label1.getText());
		label2.setText(String.valueOf(calc.temperatureConversion(n, combo1.getValue(), combo2.getValue())));

	}

}

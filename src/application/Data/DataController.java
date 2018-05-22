package application.Data;

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

public class DataController implements Initializable {
	@FXML
	private GridPane gridPane;
	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private JFXComboBox<String> combo1;

	@FXML
	private JFXComboBox<String> combo2;
	public boolean start = true;
	public boolean lbl = true, operateDot = true;
	public double n;
	ObservableList<String> list = FXCollections.observableArrayList("Kilobyte", "Megabyte", "Gigabyte", "Terabyte");
	Calculations calc = new Calculations();
	KeyHandler handler = new KeyHandler();
	public String Str = "";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combo1.setItems(list);
		combo2.setItems(list);
		combo1.setValue("Kilobyte");
		combo2.setValue("Kilobyte");

		gridPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (lbl == true)
					handler.handleLabel2Value(label1.getText());
				else
					handler.handleLabel2Value(label2.getText());
				Str = handler.handleDigitEvent(event);
				if (event.getCode().getName().equals("Backspace")) {
					handleDelOperation();
				}
				if (lbl == true) {
					if (start == true) {
						label1.setText("");
						start = false;
					}
					if (Str != null) {
						label1.setText(Str);
						handlelabel2(label1.getText());
					}
				} else {
					if (start == true) {
						label2.setText("");
						start = false;
					}
					if (Str != null) {
						label2.setText(Str);
						handlelabel1(label2.getText());
					}

				}
			}

		});
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

			}
			if (value.equals(".")) {
				if (!isInString(label1.getText(), '.')) {
					label1.setText(label1.getText() + value);
				}
			} else {
				label1.setText(label1.getText() + value);
				// n = Double.parseDouble(label1.getText());
				// label2.setText(String.valueOf(calc.dataConversion((long) n,
				// combo1.getValue(), combo2.getValue())));
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
					label2.setText("0.");
					operateDot = false;
				}

			}
			if (value.equals(".")) {
				if (!isInString(label2.getText(), '.')) {
					label2.setText(label2.getText() + value);
				}
			} else {
				label2.setText(label2.getText() + value);
				// n = Double.parseDouble(label1.getText());
				// label1.setText(String.valueOf(calc.dataConversion((long) n,
				// combo2.getValue(), combo1.getValue())));
				handlelabel1(label2.getText());
			}
		}
	}

	@FXML
	void changedCombo(ActionEvent event) {
		if (lbl == true) {
			// n = Double.parseDouble(label1.getText());
			// label2.setText(String.valueOf(calc.dataConversion((long) n,
			// combo1.getValue(), combo2.getValue())));
			handlelabel2(label1.getText());
		} else {
			// n = Double.parseDouble(label1.getText());
			// label1.setText(String.valueOf(calc.dataConversion((long) n,
			// combo2.getValue(), combo1.getValue())));
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
	void processDelKey(ActionEvent ae) {
		handleDelOperation();
	}

	protected void handleDelOperation() {
		if (lbl) {
			if (label1.getText().length() > 1) {
				label1.setText(label1.getText().substring(0, label1.getText().length() - 1));
				label2.setText(String.valueOf(calc.dataConversion(Double.parseDouble(label1.getText()),
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
				label1.setText(String.valueOf(calc.dataConversion(Double.parseDouble(label2.getText()),
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
		label1.setText(String.valueOf(calc.dataConversion((long) n, combo2.getValue(), combo1.getValue())));
	}

	protected void handlelabel2(String text) {
		n = Double.parseDouble(label1.getText());
		label2.setText(String.valueOf(calc.dataConversion((long) n, combo1.getValue(), combo2.getValue())));

	}

	private boolean isInString(String text, char c) {
		if (text.contains(".")) {
			return true;
		}
		return false;
	}

}

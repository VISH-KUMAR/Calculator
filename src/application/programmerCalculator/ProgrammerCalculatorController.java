package application.programmerCalculator;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ProgrammerCalculatorController implements Initializable {

	@FXML
	private Label lblbin;

	@FXML
	private Label lbloct;

	@FXML
	private Label lbldec;

	@FXML
	private Label lblhex;

	@FXML
	private Label inputStr;
	public boolean start = true;
	public Label lbl;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbl = lbldec;
		lblbin.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = lblbin;
			start = true;
		});
		lbloct.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = lbloct;
			start = true;
		});
		lbldec.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = lbldec;
			start = true;
		});
		lblhex.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			lbl = lblhex;
			start = true;
		});
	}

	@FXML
	void processCKey(ActionEvent event) {
		inputStr.setText("0");
		lblbin.setText("0");
		lblhex.setText("0");
		lbloct.setText("0");
		lbldec.setText("0");
		start = true;
	}

	@FXML
	void processDelKey(ActionEvent event) {
		if (inputStr.getText().length() == 1) {
			inputStr.setText("0");
			lblbin.setText("0");
			lbloct.setText("0");
			lbldec.setText("0");
			lblhex.setText("0");
			return;
		}
		inputStr.setText(inputStr.getText().substring(0, inputStr.getText().length() - 1));
		if (lbl == lblbin) {

			lblbin.setText(lblbin.getText().substring(0, lblbin.getText().length() - 1));
			binaryToOther(inputStr.getText());
		}
		if (lbl == lbloct) {

			lbloct.setText(lbloct.getText().substring(0, lbloct.getText().length() - 1));
			octalToOther(inputStr.getText());
		}
		if (lbl == lbldec) {
			lbldec.setText(lbldec.getText().substring(0, lbldec.getText().length() - 1));
			decimalToOther(inputStr.getText());
		}
		if (lbl == lblhex) {
			lblhex.setText(lblhex.getText().substring(0, lblhex.getText().length() - 1));
			hexToOther(inputStr.getText());
		}
	}

	@FXML
	void processString(ActionEvent event) {

		if (start) {
			lbl.setText("");
			start = false;
		}
		String value = ((Button) event.getSource()).getText();
		inputStr.setText(lbl.getText() + value);
		/// n = Double.parseDouble(label1.getText());
		lbl.setText(inputStr.getText());
		if (lbl == lblbin) {
			binaryToOther(inputStr.getText());
		}
		if (lbl == lbloct) {
			octalToOther(inputStr.getText());
		}
		if (lbl == lbldec) {
			decimalToOther(inputStr.getText());
		}
		if (lbl == lblhex) {
			hexToOther(inputStr.getText());
		}

	}

	private void hexToOther(String hex) {
		lbldec.setText(String.valueOf(Integer.parseInt(hex, 16)));
		lbloct.setText(new BigInteger(hex, 16).toString(8));
		lblbin.setText(new BigInteger(hex, 16).toString(2));
	}

	private void decimalToOther(String decimal) {
		lblbin.setText(Integer.toBinaryString(Integer.parseInt(decimal)));
		lbloct.setText(Integer.toOctalString(Integer.parseInt(decimal)));
		lblhex.setText(Integer.toHexString(Integer.parseInt(decimal)));
	}

	private void octalToOther(String oct) {
		lbldec.setText(String.valueOf(Integer.parseInt(oct, 8)));
		lblbin.setText(Integer.toBinaryString(Integer.parseInt(oct)));
		lblhex.setText(Integer.toHexString(Integer.parseInt(oct, 8)));
	}

	private void binaryToOther(String binarynum) {
		lbldec.setText(String.valueOf(Integer.parseInt(binarynum, 2)));
		lbloct.setText(Integer.toOctalString(Integer.parseInt(binarynum, 2)));
		lblhex.setText(String.valueOf(Integer.toHexString(Integer.parseInt(binarynum, 2))));
	}

}

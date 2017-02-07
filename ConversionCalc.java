/**
 * 
 */
package edu.miamioh.bergmahb;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * @author bergmahb
 *
 */
public class ConversionCalc extends JFrame {

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	private static JButton convertButton;
	private static JTextField inputAmount;
	private static JLabel outputAmount;
	private static JComboBox<String> inputCurrency;
	private static JComboBox<String> outputCurrency;
	private double doubleInputAmount, doubleOutputAmount;
	private String currencyStart, currencyEnd;

	// Creates a Conversion calculator object
	public ConversionCalc() {
		createComponent();
		setSize(FRAME_HEIGHT, FRAME_WIDTH);
	}

	private void createComponent() {
		ButtonListen list1 = new ButtonListen();

		convertButton = new JButton();
		convertButton.setText("Convert");
		convertButton.addActionListener(list1);

		inputAmount = new JTextField(10);

		outputAmount = new JLabel("Converted Amount...");

		inputCurrency = new JComboBox<String>();
		outputCurrency = new JComboBox<String>();
		inputCurrency.addItem("USD");
		inputCurrency.addItem("GBP");
		inputCurrency.addItem("EUR");
		outputCurrency.addItem("USD");
		outputCurrency.addItem("GBP");
		outputCurrency.addItem("EUR");
	}

	// Listens for the convert button to be pressed
	class ButtonListen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// TextField for the starting amount
			doubleInputAmount = Double.parseDouble(inputAmount.getText());

			// Running through the possibilities of different Currencies being
			// chosen in the Combo Boxes
			// Changes the JLabel(outputAmount) once the conversion is made in
			// each if statement

			currencyStart = (String) inputCurrency.getSelectedItem();
			currencyEnd = (String) outputCurrency.getSelectedItem();

			outputAmount.setText(Double.toString(conversion(doubleInputAmount, currencyStart, currencyEnd)));

		}

	}

	// Converts the amount of money based on the starting currency and the
	// ending currency
	// @param input Is the starting amount added by the user
	// @param currencyStart is the currency that the starting amount is based on
	// @param currencyEnd is the currency that the starting amount is converted
	// to
	private double conversion(double input, String currencyStart, String currencyEnd) {
		double endAmount = input;

		if (((currencyStart.equals("USD"))) && ((currencyEnd.equals("EUR")))) {
			endAmount = endAmount / 1.42;
		} else if (((currencyStart.equals("EUR"))) && ((currencyEnd.equals("USD")))) {
			endAmount = endAmount * 1.42;
		} else if (((currencyStart.equals("GBP"))) && ((currencyEnd.equals("EUR")))) {
			endAmount = endAmount * 1.13;
		} else if (((currencyStart.equals("EUR"))) && ((currencyEnd.equals("GBP")))) {
			endAmount = endAmount / 1.13;
		} else if (((currencyStart.equals("USD"))) && ((currencyEnd.equals("GBP")))) {
			endAmount = endAmount / 1.64;
		} else if (((currencyStart.equals("GBP"))) && ((currencyEnd.equals("USD")))) {
			endAmount = endAmount * 1.64;
		}

		return endAmount;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new ConversionCalc();
		frame.setLayout(new FlowLayout(10, 100, 15));
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		panel1.add(inputAmount);
		panel1.add(inputCurrency);
		panel2.add(convertButton);
		panel3.add(outputAmount);
		panel3.add(outputCurrency);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);

		frame.setTitle("Currency Conversion Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

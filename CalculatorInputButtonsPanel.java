package calc;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class CalculatorInputButtonsPanel extends JPanel implements ActionListener {
	
//OBJECTS
	private static String buttonText[] = {
		"Quot", "Mod", "A", "", "", "", "", "",
		"", "", "B", "<-", "CE", "Clr", "±", "√",
		"", "", "C", "7", "8", "9", "/", "%",
		"", "", "D", "4", "5", "6", "*", "1/x",
		"", "", "E", "1", "2", "3", "-", "=",
		"", "", "F", "0", ".", "+"	
	};
	private static JButton button[] = new JButton[buttonText.length];
	private int counter = 0;
	private Font font = new Font("", Font.PLAIN, 12);
	
	private int firstNum = 0;
	private int secondNum = 0;
	private String operation = "";
	private int result = 0;
	private String output = "";
	
//CONSTRUCTOR	
	public CalculatorInputButtonsPanel() {
		
		//Instantiate preset buttons 
		for(int i = 0; i < button.length; i++) {
			
			button[i] = new JButton(buttonText[i]);
			button[i].setFont(font);
			
			if(buttonText[i] == "Quot"||
			   buttonText[i] == "" ||
			   buttonText[i] == "."||
			   buttonText[i] == "√"||
			   buttonText[i] == "%"||
			   buttonText[i] == "1/x"||
			   buttonText[i].matches("[A-F]")) {
				
				button[i].setEnabled(false);
			}
		}
		
		//Adding Buttons with GridBagLayout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = .25;
		c.weighty = .25;
		c.insets = new Insets(1,1,1,2);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				c.gridx = j;
				c.gridy = i;
				add(button[counter++], c);
			}
		}
		
		c.gridx = 0;
		c.gridy = 4;
		add(button[counter++], c);
		c.gridx = 1;
		c.gridy = 4;
		add(button[counter++], c);
		c.gridx = 2;
		c.gridy = 4;
		add(button[counter++], c);
		c.gridx = 3;
		c.gridy = 4;
		add(button[counter++], c);
		c.gridx = 4;
		c.gridy = 4;
		add(button[counter++], c);
		c.gridx = 5;
		c.gridy = 4;
		add(button[counter++], c);
		c.gridx = 6;
		c.gridy = 4;
		add(button[counter++], c);
		c.gridx = 7;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 2;
		add(button[counter++], c);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		add(button[counter++], c);
		c.gridx = 1;
		c.gridy = 5;
		add(button[counter++], c);
		c.gridx = 2;
		c.gridy = 5;
		add(button[counter++], c);
		c.gridx = 3;
		c.gridy = 5;
		c.gridwidth = 2;
		c.gridheight = 1;
		add(button[counter++], c);
		c.gridx = 5;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		add(button[counter++], c);
		c.gridx = 6;
		c.gridy = 5;
		add(button[counter++], c);
		
		//Add ActionListener to buttons
		for(int i = 0; i < button.length; i++) {
			
			button[i].addActionListener(this);
		}
			
	}
	
//METHODS
	protected static JButton getButton(int i) { return button[i]; }

	protected static int convertNumberFrom(String number) {
		if(CalculatorNumberBasePanel.getHexRadButton().isSelected()) {
			return Integer.valueOf(number, 16).intValue();
		}
		else if((CalculatorNumberBasePanel.getDecRadButton().isSelected())) {
			return Integer.valueOf(number, 10).intValue();
		}
		else if((CalculatorNumberBasePanel.getOctRadButton().isSelected())) {
			return Integer.valueOf(number, 8).intValue();
		}
		else if((CalculatorNumberBasePanel.getBinRadButton().isSelected())) {
			return Integer.valueOf(number, 2).intValue();
		}
		return 0;
	}
	
	protected static String convertNumberTo(int number) {
		if(CalculatorNumberBasePanel.getHexRadButton().isSelected()) {
			return Integer.toHexString(number);
		}
		else if(CalculatorNumberBasePanel.getDecRadButton().isSelected()) {
			return Integer.toString(number);
		}
		else if(CalculatorNumberBasePanel.getOctRadButton().isSelected()) {
			return Integer.toOctalString(number);
		}
		else if(CalculatorNumberBasePanel.getBinRadButton().isSelected()) {
			return Integer.toBinaryString(number);
		}
		return "";
	}
	
//ACTIONLISTENER
	public void actionPerformed(ActionEvent e) {
		
		//Row 1
		if(e.getSource() == button[1]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			CalculatorTextFieldPanel.getTextField().setText("");
			operation = "mod";
		}
		if(e.getSource() == button[2]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "A");
		}
		
		//Row 2
		if(e.getSource() == button[10]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "B");
		}
		if(e.getSource() == button[11]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			if (input != null && input.length() > 0) {
		        CalculatorTextFieldPanel.getTextField().setText(input.substring(0, input.length() - 1));
		    }
		}
		if(e.getSource() == button[12]) {
			CalculatorTextFieldPanel.getTextField().setText("");
			firstNum = 0;
			secondNum = 0;
			operation = "";
		}
		if(e.getSource() == button[13]) {
			CalculatorTextFieldPanel.getTextField().setText("");
		}
		if(e.getSource() == button[14]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			if(input.startsWith("-")) {
				CalculatorTextFieldPanel.getTextField().setText(input.substring(1));
			}
			else {
				CalculatorTextFieldPanel.getTextField().setText("-" + input);
			}
		}
		
		//Row 3
		if(e.getSource() == button[18]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "C");
		}
		if(e.getSource() == button[19]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "7");
		}
		if(e.getSource() == button[20]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "8");
		}
		if(e.getSource() == button[21]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "9");
		}
		if(e.getSource() == button[22]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			CalculatorTextFieldPanel.getTextField().setText("");
			operation = "/";
		}
		
		//Row 4
		if(e.getSource() == button[26]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "D");
		}
		if(e.getSource() == button[27]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "4");
		}
		if(e.getSource() == button[28]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "5");
		}
		if(e.getSource() == button[29]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "6");
		}
		if(e.getSource() == button[30]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			CalculatorTextFieldPanel.getTextField().setText("");
			operation = "*";
		}
		
		//Row 5
		if(e.getSource() == button[34]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "E");
		}
		if(e.getSource() == button[35]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "1");
		}
		if(e.getSource() == button[36]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "2");
		}
		if(e.getSource() == button[37]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "3");
		}
		if(e.getSource() == button[38]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			CalculatorTextFieldPanel.getTextField().setText("");
			operation = "-";
		}
		
		//Row 6
		if(e.getSource() == button[42]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			CalculatorTextFieldPanel.getTextField().setText(input + "F");
		}
		if(e.getSource() == button[43]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			if(input != "")
				CalculatorTextFieldPanel.getTextField().setText(input + "0");
		}
		if(e.getSource() == button[44]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			if(!input.contains("."))
				CalculatorTextFieldPanel.getTextField().setText(input + ".");
		}
		if(e.getSource() == button[45]) {
			String input = CalculatorTextFieldPanel.getTextField().getText();
			firstNum = convertNumberFrom(input);
			CalculatorTextFieldPanel.getTextField().setText("");
			operation = "+";
		}
		
		//Equals sign
		if(e.getSource() == button[39]) {
			if(operation == "mod") {
				String input = CalculatorTextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum % secondNum;
				output = convertNumberTo(result);
				CalculatorTextFieldPanel.getTextField().setText(output);
			}
			else if(operation == "/") {
				String input = CalculatorTextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum / secondNum;
				output = convertNumberTo(result);
				CalculatorTextFieldPanel.getTextField().setText(output);
			}
			else if(operation == "*") {
				String input = CalculatorTextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum * secondNum;
				output = convertNumberTo(result);
				CalculatorTextFieldPanel.getTextField().setText(output);
			}
			else if(operation == "-") {
				String input = CalculatorTextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum - secondNum;
				output = convertNumberTo(result);
				CalculatorTextFieldPanel.getTextField().setText(output);
			}
			else if(operation == "+") {
				String input = CalculatorTextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum + secondNum;
				output = convertNumberTo(result);
				CalculatorTextFieldPanel.getTextField().setText(output);
			}
		}
	}
}

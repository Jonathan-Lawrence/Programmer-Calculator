package calc;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CalculatorTextFieldPanel extends JPanel implements KeyListener, DocumentListener{
	
//OBJECTS	
	private static JTextField inputTextField;
	private Font font = new Font("Segoe UI", Font.BOLD, 30);
	private static int currentNumberInDecimal = 0;
	
//CONSTRUCTOR
	public CalculatorTextFieldPanel() {
		
		inputTextField = new JTextField(20);
		inputTextField.setHorizontalAlignment(JTextField.RIGHT);
		inputTextField.setFont(font);
		setBorder(BorderFactory.createTitledBorder(""));

		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 650;
		c.insets = new Insets(1,1,1,1);
		add(inputTextField, c);
		
		inputTextField.addKeyListener(this);
		inputTextField.getDocument().addDocumentListener(this);
	}
	
//METHODS
	public static JTextField getTextField() { return inputTextField; }
	
	public static int getCurrentNumberInDecimal() { return currentNumberInDecimal; }
	
	//DocumentListener
	public void insertUpdate(DocumentEvent e) {
		String input = getTextField().getText();
		if(!input.isEmpty()) {
			currentNumberInDecimal = CalculatorInputButtonsPanel.convertNumberFrom(input);
		
			String currentNumberInBin = Integer.toBinaryString(currentNumberInDecimal);
			while (currentNumberInBin.length() < 64)
				currentNumberInBin = "0" + currentNumberInBin;
		
			int count = 0;
			for (int x = 0, y = 1, z = 2, w = 3; x < 64 && y < 65 && z < 66 && w < 67; x+=4, y+=4, z+=4, w+=4) {
				String bitX = Character.toString(currentNumberInBin.charAt(x));
				String bitY = Character.toString(currentNumberInBin.charAt(y));
				String bitZ = Character.toString(currentNumberInBin.charAt(z));
				String bitW = Character.toString(currentNumberInBin.charAt(w));
			
				String halfByte = bitX + bitY + bitZ + bitW;
			
				CalculatorBitsDisplayPanel.getByteLabel(count).setText(halfByte);
				count++;
			}
		}
	}
	public void removeUpdate(DocumentEvent e) {
		String input = getTextField().getText();
		if(!input.isEmpty()) {
			currentNumberInDecimal = CalculatorInputButtonsPanel.convertNumberFrom(input);
		
			String currentNumberInBin = Integer.toBinaryString(currentNumberInDecimal);
			while (currentNumberInBin.length() < 64)
				currentNumberInBin = "0" + currentNumberInBin;
		
			int count = 0;
			for (int x = 0, y = 1, z = 2, w = 3; x < 64; x+=4, y+=4, z+=4, w+=4) {
				String bitX = Character.toString(currentNumberInBin.charAt(x));
				String bitY = Character.toString(currentNumberInBin.charAt(y));
				String bitZ = Character.toString(currentNumberInBin.charAt(z));
				String bitW = Character.toString(currentNumberInBin.charAt(w));
			
				String halfByte = bitX + bitY + bitZ + bitW;
			
				CalculatorBitsDisplayPanel.getByteLabel(count).setText(halfByte);
				count++;
			}
		}
	}
	public void changedUpdate(DocumentEvent e) {}
	
	//KeyListener
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(CalculatorNumberBasePanel.getHexRadButton().isSelected() &&
		 ((c < '0') || (c > '9')) && ((c < 'A') || (c > 'F')) &&
		 (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		}
		else if(CalculatorNumberBasePanel.getDecRadButton().isSelected() &&
		 ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		}
		else if(CalculatorNumberBasePanel.getOctRadButton().isSelected() &&
		 ((c < '0') || (c > '7')) && (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		}
		else if(CalculatorNumberBasePanel.getBinRadButton().isSelected() &&
		 ((c < '0') || (c > '1')) && (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		}
	}
	//Other key methods
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}

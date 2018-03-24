package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CalculatorNumberBasePanel extends JPanel implements ActionListener {

	private static JRadioButton hex;
	private static JRadioButton dec;
	private static JRadioButton oct;
	private static JRadioButton bin;
	private ButtonGroup baseButtonGroup;

//CONSTRUCTOR	
	public CalculatorNumberBasePanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder(""));
		
		hex = new JRadioButton("Hex");
		dec = new JRadioButton("Dec");
		oct = new JRadioButton("Oct");
		bin = new JRadioButton("Bin");
		
		baseButtonGroup = new ButtonGroup();
	
		//Adding radio buttons to group
		baseButtonGroup.add(hex);
		baseButtonGroup.add(dec);
		dec.setSelected(true);
		baseButtonGroup.add(oct);
		baseButtonGroup.add(bin);
		
		//Adding to panel
		add(hex);
		add(dec);
		add(oct);
		add(bin);
		
		//Adding ActionListener
		hex.addActionListener(this);
		dec.addActionListener(this);
		oct.addActionListener(this);
		bin.addActionListener(this);
	}
	
//METHODS
	public static JRadioButton getHexRadButton() { return hex; }
	public static JRadioButton getDecRadButton() { return dec; }
	public static JRadioButton getOctRadButton() { return oct; }
	public static JRadioButton getBinRadButton() { return bin; }
	
	//ActionListener
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == hex) {
			
			int number = CalculatorTextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				CalculatorTextFieldPanel.getTextField().setText(CalculatorInputButtonsPanel.convertNumberTo(number));
			}
			
			for(int i = 2; i <= 42; i+=8) {
				CalculatorInputButtonsPanel.getButton(i).setEnabled(true);
			}
			CalculatorInputButtonsPanel.getButton(19).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(20).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(21).setEnabled(true);
			
			CalculatorInputButtonsPanel.getButton(27).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(28).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(29).setEnabled(true);
			
			CalculatorInputButtonsPanel.getButton(36).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(37).setEnabled(true);
			
		}
		if(e.getSource() == dec) {
			
			int number = CalculatorTextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				CalculatorTextFieldPanel.getTextField().setText(CalculatorInputButtonsPanel.convertNumberTo(number));
			}
			
			for(int i = 2; i <= 42; i+=8) {
				CalculatorInputButtonsPanel.getButton(i).setEnabled(false);
			}
			CalculatorInputButtonsPanel.getButton(19).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(20).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(21).setEnabled(true);
			
			CalculatorInputButtonsPanel.getButton(27).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(28).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(29).setEnabled(true);
			
			CalculatorInputButtonsPanel.getButton(36).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(37).setEnabled(true);
			
		}
		if(e.getSource() == oct) {
			
			int number = CalculatorTextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				CalculatorTextFieldPanel.getTextField().setText(CalculatorInputButtonsPanel.convertNumberTo(number));
			}
			
			for(int i = 2; i <= 42; i+=8) {
				CalculatorInputButtonsPanel.getButton(i).setEnabled(false);
			}
			CalculatorInputButtonsPanel.getButton(19).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(20).setEnabled(false);
			CalculatorInputButtonsPanel.getButton(21).setEnabled(false);
			
			CalculatorInputButtonsPanel.getButton(27).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(28).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(29).setEnabled(true);
			
			CalculatorInputButtonsPanel.getButton(36).setEnabled(true);
			CalculatorInputButtonsPanel.getButton(37).setEnabled(true);
		
		}
		if(e.getSource() == bin) {
			
			int number = CalculatorTextFieldPanel.getCurrentNumberInDecimal();
			
			if(number != 0) {
				CalculatorTextFieldPanel.getTextField().setText(CalculatorInputButtonsPanel.convertNumberTo(number));
			}
			
			for(int i = 2; i <= 42; i+=8) {
				CalculatorInputButtonsPanel.getButton(i).setEnabled(false);
			}
			CalculatorInputButtonsPanel.getButton(19).setEnabled(false);
			CalculatorInputButtonsPanel.getButton(20).setEnabled(false);
			CalculatorInputButtonsPanel.getButton(21).setEnabled(false);
			
			CalculatorInputButtonsPanel.getButton(27).setEnabled(false);
			CalculatorInputButtonsPanel.getButton(28).setEnabled(false);
			CalculatorInputButtonsPanel.getButton(29).setEnabled(false);
			
			CalculatorInputButtonsPanel.getButton(36).setEnabled(false);
			CalculatorInputButtonsPanel.getButton(37).setEnabled(false);
		}
	}
}

package calc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class CalculatorFrame extends JFrame {
	
	private CalculatorMenuBar menuBar;
	private CalculatorTextFieldPanel inputPanel;
	private CalculatorBitsDisplayPanel bitsPanel;
	private CalculatorNumberBasePanel basePanel;
	private CalculatorWordPanel wordPanel;
	private CalculatorInputButtonsPanel buttonPanel;
		
	public CalculatorFrame () {
		
		menuBar = new CalculatorMenuBar();
		setJMenuBar(menuBar);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		
		inputPanel = new CalculatorTextFieldPanel();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		add(inputPanel, c);
		
		bitsPanel = new CalculatorBitsDisplayPanel();
		c.gridy = 1;
		c.gridwidth = 3;
		add(bitsPanel, c);
		
		basePanel = new CalculatorNumberBasePanel();
		c.gridy = 2;
		c.gridwidth = 1;
		add(basePanel, c);
		
		wordPanel = new CalculatorWordPanel();
		c.gridy = 3;
		add(wordPanel, c);
		
		buttonPanel = new CalculatorInputButtonsPanel();
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 2;
		add(buttonPanel, c);
		
	}
}

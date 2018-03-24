package calc;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorBitsDisplayPanel extends JPanel{
	private static JLabel byteLabel[];
	private JLabel bit63;
	private JLabel bit47;
	private JLabel bit32;
	private JLabel bit31;
	private JLabel bit15;
	private JLabel bit0;
	
//CONSTRUCTOR								
	public CalculatorBitsDisplayPanel() {
		byteLabel = new JLabel[16];
		String empty = "0000";
		Font font = new Font("Monaco", Font.BOLD, 11);
			
		for(int i = 0; i < 16; i++) {
			byteLabel[i] = new JLabel("", JLabel.CENTER);
			byteLabel[i].setText(empty);
			byteLabel[i].setFont(font);
		}
		
		bit63 = new JLabel("", JLabel.CENTER);	bit32 = new JLabel("", JLabel.CENTER);	bit15 = new JLabel("", JLabel.CENTER);	
		bit47 = new JLabel("", JLabel.CENTER);	bit31 = new JLabel("", JLabel.CENTER);	bit0 = new JLabel("", JLabel.CENTER);
			
		bit63.setFont(font);		bit32.setFont(font);		bit15.setFont(font);
		bit47.setFont(font);		bit31.setFont(font);		bit0.setFont (font);
			
		bit63.setEnabled(false);		bit32.setEnabled(false);		bit15.setEnabled(false);
		bit47.setEnabled(false);		bit31.setEnabled(false);		bit0.setEnabled (false);
			
		bit63.setText("63  ");	bit32.setText("  32");	bit15.setText("15  ");
		bit47.setText("47  ");	bit31.setText("31  ");	bit0.setText ("   0");
			
		GridLayout layout = new GridLayout(0,8);
		layout.setHgap(0);
		setLayout(layout);
			
		for(int i = 0; i < 8; i++) {
			add(byteLabel[i]);	
		}

		add(bit63);			add(new JLabel());		add(new JLabel());		add(new JLabel());
		add(bit47);			add(new JLabel());		add(new JLabel());		add(bit32);
			
		for(int i = 8; i < 16; i++) {
			add(byteLabel[i]);
		}
			
		add(bit31);			add(new JLabel());		add(new JLabel());		add(new JLabel());
		add(bit15);			add(new JLabel());		add(new JLabel());		add(bit0);
			
		setBorder(BorderFactory.createTitledBorder(""));
	}
	
//METHODS
	protected static JLabel getByteLabel(int i) {return byteLabel[i];}
}

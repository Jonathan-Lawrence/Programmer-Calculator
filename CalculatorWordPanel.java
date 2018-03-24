package calc;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CalculatorWordPanel extends JPanel {
	
	private JRadioButton qword, dword, word, byteWord;
	private ButtonGroup wordButtonGroup;
	
	public CalculatorWordPanel() {
		//Set panel to BoxLayout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createTitledBorder(""));
		
		//Create word buttons
		qword = new JRadioButton("Qword   ");
		dword = new JRadioButton("Dword   ");
		word = new JRadioButton("Word   ");
		byteWord = new JRadioButton("Byte   ");
		
		wordButtonGroup = new ButtonGroup();
	
		//Adding radio buttons to group
		wordButtonGroup.add(qword);
		qword.setSelected(true);
		wordButtonGroup.add(dword);
		wordButtonGroup.add(word);
		wordButtonGroup.add(byteWord);
		
		//Adding to panel
		add(qword);
		add(dword);
		add(word);
		add(byteWord);
	}
}

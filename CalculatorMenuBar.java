package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class CalculatorMenuBar extends JMenuBar implements ActionListener, ItemListener {
	
	private JMenu view, edit, help;
	private JMenuItem hide, copy;
	
	public CalculatorMenuBar() {
		
		//View menu
		view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		
		hide = new JCheckBoxMenuItem("Hide");
		hide.setMnemonic(KeyEvent.VK_H);
		hide.addActionListener(this);
		hide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
		
		view.add(hide);
		
		//Edit menu
		edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		copy = new JMenuItem("Copy Text", KeyEvent.VK_T);
		copy.addActionListener(this);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
		
		edit.add(copy);
		
		//Help menu
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		add(view);
		add(edit);
		add(help);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		
	}
}

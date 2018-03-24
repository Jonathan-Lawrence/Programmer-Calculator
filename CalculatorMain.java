package calc;

import javax.swing.JFrame;

public class CalculatorMain {

	public static void main(String[] args) {
			CalculatorFrame myCalc = new CalculatorFrame();
			myCalc.setTitle("Calculator");
			myCalc.setSize(725, 375);
			myCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myCalc.setVisible(true);
	}
	
}



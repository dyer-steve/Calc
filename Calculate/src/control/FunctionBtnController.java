package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class FunctionBtnController implements ActionListener {

	private Function function;
	
	public FunctionBtnController(Function function) {
		this.function = function;
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		String functionSymbol = arg.getActionCommand();
		
		if(functionSymbol.equals("C")) {
			function.clearAll();
		} else if(functionSymbol.equals("<-")) {
			function.backSpace();
		} else if(functionSymbol.equals("=")) {
			function.solve();
		} else if(functionSymbol.equals("+/-")) {
			function.negative();
		}
	}

}

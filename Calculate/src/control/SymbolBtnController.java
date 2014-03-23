package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class SymbolBtnController implements ActionListener {
	
	private Function function;
	
	public SymbolBtnController(Function function) {
		this.function = function;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getActionCommand().equals("( )")) {
			function.parentheses();
		} else {
			function.append(arg.getActionCommand());
		}
	}

}

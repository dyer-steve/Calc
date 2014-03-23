package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class DigitKey implements KeyListener {

	private Function function;
	
	public DigitKey(Function function) {
		this.function = function;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg) {
		String s = arg.getKeyChar() + "";
		if(s.equals("(") || s.equals(")")) {
			function.append(s);
		}
		if(s.matches("[0-9]|\\-|\\+|\\*|\\.|/")) {
			function.append(s);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

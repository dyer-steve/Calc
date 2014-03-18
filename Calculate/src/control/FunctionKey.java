package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class FunctionKey implements KeyListener {

	private Function function;
	
	public FunctionKey(Function function) {
		this.function = function;
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg) {
		String key = arg.getKeyChar() + "";
		if(key.equals("\b")) {
			function.backSpace();
		} else if(arg.getKeyChar() == 10) {
			function.solve();
		} else if(key.equals("c")) {
			function.clearAll();
		} else if(key.equals("z")) {
			function.regret();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

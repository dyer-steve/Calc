package control;

import java.util.Stack;

import javax.swing.JTextField;

import model.Parser;

public class Function {
	private Parser parser = new Parser();
	private RegretStack<String> zRegret = new RegretStack<String>();
	private JTextField input;
	
	public Function(JTextField input) {
		this.input = input;
	}

	public void solve() {
		stack();
		input.setText(parser.value(input.getText()));
	}

	public void clearAll() {
		stack();
		input.setText("");		
	}

	public void backSpace() {
		stack();
		String text = input.getText();
		if(text.length() > 0) {
			input.setText(text.substring(0, text.length()-1));
		}
	}

	public void append(String s) {
		stack();
		input.setText(input.getText() + s);
	}

	public void negative() {
		stack();
		String text = input.getText();
		if (text.length() > 0) {
			String first = text.charAt(0) + "";
			System.out.println(first);
			if (first.equals("-")) {
				input.setText(text.substring(1));
			} else {
				input.setText("-" + text);
			}
		}
	}
	
	public void regret() {
		if(!zRegret.isEmpty()) {
			input.setText(zRegret.pop());
		}
	}
	
	private void stack() {
		String oldValue = input.getText();
		if(zRegret.isEmpty()) {
			zRegret.push(oldValue);
		} else if(!zRegret.peek().equals(oldValue)) {
			zRegret.push(oldValue);
		}
	}
}

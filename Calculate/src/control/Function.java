package control;

import java.util.Stack;

import javax.swing.JTextField;

import model.Parser2;

public class Function {
	private Parser2 parser = new Parser2();
	private RegretStack<String> zRegret = new RegretStack<String>();
	private JTextField input;
	
	public Function(JTextField input) {
		this.input = input;
	}

	public void solve() {
		stack();
		parser.build(input.getText());
		input.setText(parser.build(input.getText()).toString());
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

	public void parentheses() {
		String text = input.getText();
		int left = 0;
		int right = 0;
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i) == '(') {
				left++;
			} else if(text.charAt(i) == ')') {
				right++;
			}
		}
		if(left==right) {
			append("(");
		} else if(left>right){
			append(")");
		} else {
			append(")");
		}
		
	}
}

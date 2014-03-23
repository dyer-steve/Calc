package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.DigitKey;
import control.Function;
import control.FunctionKey;
import control.SymbolBtnController;
import control.FunctionBtnController;

public class GUI extends JFrame {
	
	private JTextField input;
	private SymbolBtnController symbolBtnController;
	private FunctionBtnController functionBtnController;
	private DigitKey digitKey;
	private FunctionKey functionKey;
	private Function function;
	
	public GUI() {
		super("Calc");
		setSize(300,400);
		setLayout(new BorderLayout());
		
		input = new JTextField();
		input.setHorizontalAlignment(JTextField.RIGHT);
		function = new Function(input);
		input.setFocusable(false);
		input.setEditable(false);
		symbolBtnController = new SymbolBtnController(function);
		functionBtnController = new FunctionBtnController(function);
		digitKey = new DigitKey(function);
		functionKey = new FunctionKey(function);
		addKeyListener(digitKey);
		addKeyListener(functionKey);
		setFocusable(true);
		addContent();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void addContent() {
		String[] btnIndex = {"C","/","*","<-","7","8","9","-","4","5","6","+","1","2","3","( )","0",".","+/-","="};
		
		add(BorderLayout.NORTH,input);
		
		JPanel btnGrid = new JPanel(new GridLayout(5,4,-1,-1));
		JButton btn;
		for(int x=0; x<20; x++) {
			btn = new JButton(btnIndex[x]+"");
				if(btnIndex[x].matches("C|=|<-|./.")) {
					btn.addActionListener(functionBtnController);
					btn.setFocusable(false);
				} else {
					btn.addActionListener(symbolBtnController);
					btn.setFocusable(false);
				}
				btnGrid.add(btn);
		}
		add(BorderLayout.CENTER,btnGrid);
		pack();
	}

	public static void main(String[] args) {
		new GUI();
	}
	
}

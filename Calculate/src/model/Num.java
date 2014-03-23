package model;

public class Num extends Expr {

	public Num(String number) {
		super(number);	
	}
	
	@Override
	protected double value() {
		return Double.parseDouble(number);
	}
}

package model;

public class Expr {
	
	protected String number;
	protected Expr exp1, exp2;
	
	public Expr(String number) {
		this.number = number;
	}
	
	public Expr(Expr exp1, Expr exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	public String toString() {
		return value() + "";
	}
	
	protected double value() {
		return 0;
	}
}

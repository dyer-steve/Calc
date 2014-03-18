package model;

public class Add implements Expr {

	private Expr exp1, exp2;
	
	public Add(Expr exp1, Expr exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public Double value() {
		return exp1.value() + exp2.value();
	}

}

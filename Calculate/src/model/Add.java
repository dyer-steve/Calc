package model;

public class Add extends Expr{
	
	public Add(Expr exp1, Expr exp2) {
		super(exp1,exp2);
	}
	
	@Override
	protected double value() {
		return exp1.value() + exp2.value();
	}

}

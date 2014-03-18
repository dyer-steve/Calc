package model;

public class Number implements Expr {
	
	private String number;

	public Number(String number) {
		this.number = number;
	}

	public Double value() {
		//TryCatch
		System.out.println(number);
		return Double.parseDouble(number);
	}

}

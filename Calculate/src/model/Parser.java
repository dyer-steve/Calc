package model;

public class Parser {
	public String value(String exp) {
		String[] add = exp.split("\\+");
		return new Add(new Number(add[0]),new Number(add[1])).value() + "";
	}
}

package control;

import java.util.Stack;

public class RegretStack<String> extends Stack<String> {
	@Override
	public String push(String value) {
		if(size() > 100) {
			remove(0);
			super.push(value);
		} else {
			super.push(value);
		}
		return value;
	}
}

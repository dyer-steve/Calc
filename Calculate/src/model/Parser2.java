package model;

import java.io.Reader;
import java.io.StringReader;
import java.text.ParseException;

public class Parser2 {
	private Scanner scanner;
	private int token;

	public Expr build(String input) {
		if(input.startsWith("-")) {
			input = 0 + input;
		}
		return build(new StringReader(input));
	}

	private Expr build(StringReader reader) {
		scanner = new Scanner(reader);
		token = scanner.nextToken();
		Expr expr = expr();
		if (token == Scanner.EOF) {
			return expr;
		} else {
			throw new ParserException("Trailing garbage after "
					+ scanner.token());
		}
	}

	private Expr expr() { // term (addop term)*
		Expr result, term;
		result = term();
		if (token == scanner.EOF) {
			return result;
		}
		while (token == scanner.ADD || token == scanner.SUB) {
			if (token == scanner.ADD) {
				token = scanner.nextToken();
				term = term();
				result = new Add(result, term);
			} else {
				token = scanner.nextToken();
				term = term();
				result = new Sub(result, term);
			}
		}
		return result;
	}

	private Expr term() { // factor (mulop factor)*
		Expr result, factor;
		result = factor();
		if (token == scanner.EOF) {
			return result;
		}
		while(token == scanner.MUL || token == scanner.DIV) {
			if(token == scanner.MUL) {
				token = scanner.nextToken();
				factor = factor();
				result = new Mul(result,factor);
			} else {
				token = scanner.nextToken();
				factor = factor();
				result = new Div(result,factor);
			}
		}
		return result;
	}

	private Expr factor() { // NUMBER | (Expr)
		Expr result;
		switch (token) {
		case -2:
			result = new Num(scanner.token());
			token = scanner.nextToken();
			return result;
		case '(':
			token = scanner.nextToken();
			result = expr();
			if (token != ')') {
				throw new ParserException("Expecting \")\", found: "
						+ scanner.token());
			}
			token = scanner.nextToken();
			return result;
		default:
			throw new ParserException("Unexpected " + scanner.token());
		}
	}
}

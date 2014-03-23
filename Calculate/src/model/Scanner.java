package model;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import java.text.ParseException;

public class Scanner {
	public static final int EOF = -1, NUMBER = -2, ADD = -3, SUB = -4,
			MUL = -5, DIV = -6;
	private PushbackReader reader;
	private String token = "";

	public Scanner(StringReader reader) {
		this.reader = new PushbackReader(reader, 2);
	}

	public int nextToken() {
		try {
			return next();
		} catch (IOException e) {
			throw new ParserException(e.getMessage());
		}
	}

	private int next() throws IOException {
		token = null;
		int ch = reader.read();
		if (Character.isDigit(ch) || ch == '.') {
			StringBuilder sb = new StringBuilder();
			while (Character.isDigit(ch) || ch == '.') {
				sb.append((char) ch);
				ch = reader.read();
			}
			if (ch != EOF) {
				reader.unread(ch);
			}
			token = sb.toString();
			return NUMBER;
		}
		if (ch == '+') {
			token = "+";
			return ADD;
		}
		if (ch == '-') {
			token = "-";
			return SUB;
		}
		if (ch == '*') {
			token = "*";
			return MUL;
		}
		if (ch == '/') {
			token = "/";
			return DIV;
		}
		if (ch == EOF) {
			token = "EOF";
			return EOF;
		}
		token = String.valueOf((char) ch);
		return ch;
	}

	public boolean hasNext() {
		return !token.equals("EOF");
	}

	public String token() {
		return token;
	}

}

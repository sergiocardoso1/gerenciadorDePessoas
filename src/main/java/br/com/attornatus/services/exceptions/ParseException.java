package br.com.attornatus.services.exceptions;

public class ParseException extends java.text.ParseException{

	private static final long serialVersionUID = 1L;

	public ParseException(String msg, int errorOffset) {
		super(msg, errorOffset);
		// TODO Auto-generated constructor stub
	}

}

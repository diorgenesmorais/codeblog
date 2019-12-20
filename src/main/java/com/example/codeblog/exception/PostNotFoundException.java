package com.example.codeblog.exception;

public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3799700473392893052L;

	public PostNotFoundException() {
		super();
	}

	public PostNotFoundException(String message) {
		super(message);
	}

}

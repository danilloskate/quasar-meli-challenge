package com.meli.quasar.exception;

public class QuasarException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public QuasarException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuasarException(String message) {
        super(message);
    }
}

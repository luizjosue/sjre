/*
 * Created on 20/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.exception;

/**
 * @author mfp
 * 
 *         
 *         
 */
public class MissingElementException extends Exception {

	public MissingElementException(String message) {
		super("MissingElementException::Message: " + message);
	}

}

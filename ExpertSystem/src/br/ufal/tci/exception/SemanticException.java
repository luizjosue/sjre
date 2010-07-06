/*
 * Created on Sep 8, 2004
 *
 * 
 */
package br.ufal.tci.exception;

/**
 * @author desenvolvimento
 * 
 * 
 */
public class SemanticException extends Exception {
	public SemanticException(String message) {
		super("SemanticException::Message: " + message);
	}
}

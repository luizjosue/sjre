/*
 * Created on 13/10/2004
 *
 * 
 * 
 */
package br.ufal.tci.exception;

/**
 * @author ljsf
 * 
 *         Classe que representa as excecoes de sintaxe
 */
public class SyntaticException extends Exception {

	/**
	 * Construtor que recebe um string de descricao da excecao como parametro
	 * */
	public SyntaticException(String message) {
		super("SyntaticException::Message: " + message);
	}

	/**
	 * Construtor que recebe como parametro uma outra excecao
	 * */
	public SyntaticException(Exception e) {
		super(e);
	}

}

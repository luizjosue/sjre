/*
 * Created on 24/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.ui;

import br.ufal.tci.parser.Variable;

/**
 * @author mfp
 *
 *	Interface que representa uma interface básica com o usuário
 *
 */
public interface UserInterface {
	
	
	public Object getObject();
	
	public void setObject(Object obj);
	/**
	 * 	Método que solicita uma pergunta ao usuário
	 * 	e retorna o objeto com o valor respondido pelo usuário
	 * */
	public Object getAsk(Variable var);
	
	
	/**
	 * 	Método que irá mostrar uma mensagem
	 * 	de erro na tela final do usuário
	 * */
	public void showErrorMessage(String message);

	/**
	 * 	Metodo que retorna a string(todo o código das regras)
	 *  digitada pelo usuário em um Editor de Texto,
	 * 	caso a interface que implemente UserInterfaceIF
	 * 	nao utilize um editor desta finalidade entao um
	 * 	valor <i>null</i> deverá ser retornado
	 * */
	public String getSource();

}

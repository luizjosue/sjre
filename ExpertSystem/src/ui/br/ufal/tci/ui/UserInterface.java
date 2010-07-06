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
 *	Interface que representa uma interface b�sica com o usu�rio
 *
 */
public interface UserInterface {
	
	
	public Object getObject();
	
	public void setObject(Object obj);
	/**
	 * 	M�todo que solicita uma pergunta ao usu�rio
	 * 	e retorna o objeto com o valor respondido pelo usu�rio
	 * */
	public Object getAsk(Variable var);
	
	
	/**
	 * 	M�todo que ir� mostrar uma mensagem
	 * 	de erro na tela final do usu�rio
	 * */
	public void showErrorMessage(String message);

	/**
	 * 	Metodo que retorna a string(todo o c�digo das regras)
	 *  digitada pelo usu�rio em um Editor de Texto,
	 * 	caso a interface que implemente UserInterfaceIF
	 * 	nao utilize um editor desta finalidade entao um
	 * 	valor <i>null</i> dever� ser retornado
	 * */
	public String getSource();

}

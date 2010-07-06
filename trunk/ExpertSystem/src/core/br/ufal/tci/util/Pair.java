/*
 * Created on 12/10/2004
 *
 * 
 * 
 */
package br.ufal.tci.util;

import br.ufal.tci.value.Value;

/**
 * @author preto
 * 
 *         Classe que representa um par de objetos
 */
public class Pair<T> extends Value<T> {

	private T object1;
	private T object2;

	/**
	 * COnstrutor que recebe como parâmetros dois objetos
	 * */
	public Pair(T object1, T object2) {
		super(null);
		this.object1 = object1;
		this.object2 = object2;
	}

	/**
	 * @return Returns the object1.
	 */
	public Object getObject1() {
		return object1;
	}

	/**
	 * @return Returns the object2.
	 */
	public Object getObject2() {
		return object2;
	}
}

/*
 * Created on 20/10/2004
 *
 * 
 * 
 */
package br.ufal.tci.parser;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 */
public class Argument extends Unit {

	/**
	 * List of identifiers
	 */
	private List<Identifier> identifiers;

	public Argument() {
		this.identifiers = new LinkedList<Identifier>();
	}

	public boolean addIdentifier(Identifier arg0) {
		return identifiers.add(arg0);
	}

	public boolean isMethodCall() {
		return this.identifiers.size() > 1;
	}

	public List<Identifier> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}

}

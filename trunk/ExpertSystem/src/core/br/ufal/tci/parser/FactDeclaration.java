/*
 * Created on 01/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.parser;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ljsf
 * 
 *         
 *         
 */
public class FactDeclaration {

	/**
	 * Collection de Facts
	 * */
	private List<Fact> listOfFacts;

	public FactDeclaration() {
		this.listOfFacts = new LinkedList<Fact>();
	}

	public List<Fact> getListOfFacts() {
		return listOfFacts;
	}

	public void setListOfFacts(List<Fact> listOfFacts) {
		this.listOfFacts = listOfFacts;
	}

	/**
	 * Adiciona um Fact
	 * */
	public void addFact(Fact fact) {
		if (fact != null) {
			this.listOfFacts.add(fact);
		}
	}

}

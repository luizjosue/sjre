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
public class RuleDeclaration {

	/**
	 * Collection de Rule
	 * */
	private List<Rule> listOfRules;

	public RuleDeclaration() {
		this.listOfRules = new LinkedList<Rule>();
	}

	public List<Rule> getListOfRules() {
		return listOfRules;
	}

	public void setListOfRules(List<Rule> listOfRules) {
		this.listOfRules = listOfRules;
	}

}

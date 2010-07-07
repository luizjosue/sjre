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
 */
public class VariableDeclaration {

	/**
	 * list of VariableList
	 * */
	private List<VariableList> variableList;

	public VariableDeclaration() {
		this.variableList = new LinkedList<VariableList>();
	}

	/**
	 * @return
	 */
	public List<VariableList> getListOfVariables() {
		return variableList;
	}

	/**
	 * @param collection
	 */
	public void setListOfVariables(List<VariableList> list) {
		variableList = list;
	}

	public void addVariableList(VariableList anyVariableList) {
		if (anyVariableList != null) {
			this.variableList.add(anyVariableList);
		}
	}

}

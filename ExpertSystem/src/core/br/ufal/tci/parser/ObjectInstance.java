/*
 * Created on 15/09/2004
 *
 */
package br.ufal.tci.parser;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ljsf
 * 
 *         15/09/2004
 * 
 */
public class ObjectInstance {

	private List<Unit> packageAndName;
	private List<Unit> argumentList;

	public ObjectInstance() {
		this.packageAndName = new LinkedList<Unit>();
		this.argumentList = new LinkedList<Unit>();
	}

	public List<Unit> getPackageAndName() {
		return packageAndName;
	}

	public List<Unit> getArgumentList() {
		return argumentList;
	}

	public void setArgumentList(List<Unit> argumentList) {
		this.argumentList = argumentList;
	}

	public void addPackageAndName(Unit unit) {
		this.packageAndName.add(unit);
	}
}

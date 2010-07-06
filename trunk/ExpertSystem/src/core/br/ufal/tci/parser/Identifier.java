/*
 * Created on 01/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.parser;

/**
 * @author ljsf
 * 
 */
public class Identifier extends Unit {

	protected String name;

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Identifier() {
		this.name = new String();
	}

	public Identifier(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.name;
	}

}

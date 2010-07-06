/*
 * Created on Sep 8, 2004
 *
 * 
 */
package br.ufal.tci.type;

/**
 * @author desenvolvimento
 *
 */
public class ObjectType extends Type {
	
	private String className;
	
	public ObjectType(){
		this.className = new String();
	}
	
	public ObjectType(String className){
		this.className = className;
	}
	/**
	 * @return
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param string
	 */
	public void setClassName(String string) {
		className = string;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ObjectType";
	}
	
}

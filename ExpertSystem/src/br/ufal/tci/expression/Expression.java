/*
 * Created on 01/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.expression;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public abstract class Expression {

	protected Type type;

	/**
	 * 
	 */
	public Expression() {
		this.type = null;
	}

	public abstract Value<?> evaluate(InferenceEngineIF engine)
			throws SemanticException;

	/**
	 * @return Returns the type.
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            The type to set.
	 */
	public void setType(Type type) {
		this.type = type;
	}
}

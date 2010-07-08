/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.factor;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.parser.Constant;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public abstract class Factor {

	protected Type type;

	protected Constant constant;

	protected Variable variable;

	public Factor() {
		this.type = null;
		this.constant = null;
		this.variable = null;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.expression.Expression#evaluate(br.ufal.tci.InferenceEngine
	 * .InferenceEngineIF)
	 */
	public abstract Value<?> evaluate(InferenceEngine engine)
			throws SemanticException;

	/**
	 * @return Returns the constant.
	 */
	public Constant getConstant() {
		return constant;
	}

	/**
	 * @param constant
	 *            The constant to set.
	 */
	public void setConstant(Constant constant) {
		this.constant = constant;
	}

	/**
	 * @return Returns the variable.
	 */
	public Variable getVariable() {
		return variable;
	}

	/**
	 * @param variable
	 *            The variable to set.
	 */
	public void setVariable(Variable variable) {
		this.variable = variable;
	}
}

/*
 * Created on 13/09/2004
 *
 */
package br.ufal.tci.expression;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.operator.additive.AdditiveOperator;
import br.ufal.tci.operator.additive.Or;
import br.ufal.tci.term.IfTerm;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 *         13/09/2004
 * 
 */
public class IfMoreSimpleExpression extends Expression {

	private AdditiveOperator operator;

	private IfTerm term;

	public IfMoreSimpleExpression() {
		this.operator = null;
		this.term = null;
	}

	/**
	 * @return
	 */
	public AdditiveOperator getOperator() {
		return operator;
	}

	/**
	 * @return
	 */
	public IfTerm getTerm() {
		return term;
	}

	/**
	 * @param operator
	 */
	public void setOperator(AdditiveOperator operator) {
		this.operator = operator;
	}

	/**
	 * @param term
	 */
	public void setTerm(IfTerm term) {
		this.term = term;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.expression.Expression#getType()
	 */
	public Type getType() {
		if (this.operator != null) {
			if (this.operator instanceof Or) {
				return new BooleanType();
			}
			return this.term.getType();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.expression.Expression#evaluate(br.ufal.tci.InferenceEngine
	 * .InferenceEngineIF)
	 */
	public Value<?> evaluate(InferenceEngine engine) throws SemanticException {
		return this.term.evaluate(engine);
	}
}

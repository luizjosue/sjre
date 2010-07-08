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
public class IfSimpleExpression extends Expression {

	private IfTerm term;

	private IfMoreSimpleExpression moreSimpleExpression;

	private AdditiveOperator operator;

	public IfSimpleExpression() {
		this.term = null;
		this.moreSimpleExpression = null;
		this.operator = null;
	}

	/**
	 * @return
	 */
	public IfMoreSimpleExpression getMoreSimpleExpression() {
		return moreSimpleExpression;
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
	 * @param expression
	 */
	public void setMoreSimpleExpression(IfMoreSimpleExpression expression) {
		moreSimpleExpression = expression;
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
			return this.moreSimpleExpression.getType();
		}
		return Type.cast(this.term.getType(), this.moreSimpleExpression
				.getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.expression.Expression#evaluate(br.ufal.tci.InferenceEngine
	 * .InferenceEngineIF)
	 */
	public Value<?> evaluate(InferenceEngine engine) throws SemanticException {
		if (this.moreSimpleExpression != null) {
			if (this.moreSimpleExpression.getOperator() != null) {
				return this.moreSimpleExpression.getOperator().evaluate(
						this.term.evaluate(engine),
						this.moreSimpleExpression.evaluate(engine));
			}
		}
		return this.term.evaluate(engine);
	}
}

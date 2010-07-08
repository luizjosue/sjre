/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.expression;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.operator.additive.AdditiveOperator;
import br.ufal.tci.operator.additive.Or;
import br.ufal.tci.term.ThenTerm;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class ThenSimpleExpression extends Expression {

	private ThenTerm term;
	private ThenMoreSimpleExpression moreSimpleExpression;
	private AdditiveOperator operator;

	public ThenSimpleExpression() {
		this.term = null;
		this.moreSimpleExpression = null;
		this.operator = null;
	}

	/**
	 * @return
	 */
	public ThenMoreSimpleExpression getMoreSimpleExpression() {
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
	public ThenTerm getTerm() {
		return term;
	}

	/**
	 * @param expression
	 */
	public void setMoreSimpleExpression(ThenMoreSimpleExpression expression) {
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
	public void setTerm(ThenTerm term) {
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
			return Type.cast(this.term.getType(), this.moreSimpleExpression
					.getType());
		}
		return this.term.getType();
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

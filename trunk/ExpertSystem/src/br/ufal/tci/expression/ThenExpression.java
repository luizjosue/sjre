/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.expression;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.operator.relational.RelationalOperator;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 */
public class ThenExpression extends Expression {

	private ThenSimpleExpression simpleExpression;

	private RelationalOperator operator;

	private Expression thenExpression;

	public ThenExpression() {
		this.simpleExpression = null;
		this.operator = null;
		this.thenExpression = null;
	}

	/**
	 * @return
	 */
	public RelationalOperator getOperator() {
		return operator;
	}

	/**
	 * @return
	 */
	public ThenSimpleExpression getSimpleExpression() {
		return simpleExpression;
	}

	/**
	 * @return
	 */
	public Expression getThenExpression() {
		return thenExpression;
	}

	/**
	 * @param operator
	 */
	public void setOperator(RelationalOperator operator) {
		this.operator = operator;
	}

	/**
	 * @param expression
	 */
	public void setSimpleExpression(ThenSimpleExpression expression) {
		simpleExpression = expression;
	}

	/**
	 * @param expression
	 */
	public void setThenExpression(Expression expression) {
		thenExpression = expression;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.expression.Expression#getType()
	 */
	public Type getType() {
		if (this.operator != null) {
			return new BooleanType();
		}
		return this.simpleExpression.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.expression.Expression#evaluate(br.ufal.tci.InferenceEngine
	 * .InferensIF)
	 */
	public Value<?> evaluate(InferenceEngineIF engine) throws SemanticException {
		if (this.operator != null) {
			return this.operator.evaluate(this.simpleExpression
					.evaluate(engine), this.thenExpression.evaluate(engine));
		}
		return this.simpleExpression.evaluate(engine);
	}
}

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
public class IfExpression extends Expression {

	private IfSimpleExpression simpleExpression;

	private RelationalOperator operator;

	private Expression expression;

	public IfExpression() {
		simpleExpression = null;
		operator = null;
		expression = null;
	}

	/**
	 * @return
	 */
	public IfSimpleExpression getSimpleExpression() {
		return simpleExpression;
	}

	/**
	 * @param expression
	 */
	public void setSimpleExpression(IfSimpleExpression expression) {
		simpleExpression = expression;
	}

	/**
	 * @return
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * @return
	 */
	public RelationalOperator getOperator() {
		return operator;
	}

	/**
	 * @param expression
	 */
	public void setExpression(Expression expression) throws SemanticException {
		this.expression = expression;
	}

	/**
	 * @param operator
	 */
	public void setOperator(RelationalOperator operator) {
		this.operator = operator;
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
	 * .InferenceEngine)
	 */
	public Value<?> evaluate(InferenceEngineIF engine) throws SemanticException {
		if (this.operator == null) {
			/* nao ha operador */
			return this.simpleExpression.evaluate(engine);
		}

		/* há operador */
		return this.operator.evaluate(this.simpleExpression.evaluate(engine),
				this.expression.evaluate(engine));
	}
}
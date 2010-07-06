/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.factor;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.ThenExpression;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class ThenFactor extends Factor {

	/* pode ser um ThenExpression */
	private ThenExpression thenExpression;

	/* pode ser outro thenFactor */
	private Factor thenFactor;

	public ThenFactor() {
		super();
		this.thenExpression = null;
		this.thenFactor = null;
	}

	/**
	 * @return
	 */
	public ThenExpression getThenExpression() {
		return thenExpression;
	}

	/**
	 * @param expression
	 */
	public void setThenExpression(ThenExpression expression) {
		thenExpression = expression;
	}

	public void setThenFacor(ThenFactor factor) {
		this.thenFactor = factor;
	}

	public Factor getThenFactor() {
		return this.thenFactor;
	}

	public Type getType() {
		if (this.constant != null) {
			return this.constant.getType();
		}
		if (this.thenExpression != null) {
			return this.thenExpression.getType();
		}
		if (this.thenFactor != null) {
			return this.thenFactor.getType();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seebr.ufal.tci.factor.Factor#evaluate(br.ufal.tci.InferenceEngine.
	 * InferenceEngineIF)
	 */
	public Value<?> evaluate(InferenceEngineIF engine) throws SemanticException {
		if (this.constant != null) {
			return this.constant.getValue();
		}
		if (this.variable != null) {
			return this.variable.evaluate();
		}
		if (this.thenFactor != null) {
			Value<?> value = this.thenFactor.evaluate(engine);
			if (!value.isBoolean()) {
				throw new SemanticException(MessageUtil.INCOMPATIBLE_TYPES);
			}
			return ValueUtils.getBooleanValue(value);
		}
		if (this.thenExpression != null) {
			return this.thenExpression.evaluate(engine);
		}
		return null;
	}

}

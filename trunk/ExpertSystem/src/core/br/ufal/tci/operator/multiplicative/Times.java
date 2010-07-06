/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.operator.multiplicative;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.operator.NumericOperator;
import br.ufal.tci.operator.relational.Operators;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 */
public class Times extends NumericOperator implements MultiplicativeOperator {

	public Times() {
		super();
	}

	@Override
	public String toString() {
		return Operators.MULTIPLICATION;
	}

	@Override
	protected boolean customizedCheck(Value<?> left, Value<?> right)
			throws SemanticException {
		if (left.isBoolean() || left.isString()) {
			throw new SemanticException(MessageUtil.OPERATOR_NOT_DEFINED);
		}

		if (right.isBoolean() || right.isString()) {
			throw new SemanticException(MessageUtil.OPERATOR_NOT_DEFINED);
		}

		return true;
	}

	@Override
	protected Float performOperation(Float a, Float b) {
		return a * b;
	}

}

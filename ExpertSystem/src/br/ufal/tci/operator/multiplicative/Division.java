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
import br.ufal.tci.value.ValueUtils;

/**
 * @author ljsf
 */
public class Division extends NumericOperator implements MultiplicativeOperator {

	public Division() {
		super();
	}

	@Override
	public String toString() {
		return Operators.DIVISION;
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

		Value<Integer> iValue2 = ValueUtils.getIntegerValue(right);
		Value<Float> rValue2 = ValueUtils.getRealValue(right);

		if ((iValue2 != null && iValue2.getValue() == 0)
				|| (rValue2 != null && rValue2.getValue() == 0)) {
			throw new SemanticException(MessageUtil.DIVISION_BY_ZERO);
		}

		return true;
	}

	@Override
	protected Float performOperation(Float a, Float b) {
		return a / b;
	}

}

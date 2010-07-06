package br.ufal.tci.operator;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

public abstract class NumericOperator extends Operator {

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
	protected Value<?> execute(Value<?> left, Value<?> right)
			throws SemanticException {
		Value<?> value = null;
		Value<Integer> iValue1 = ValueUtils.getIntegerValue(left);
		Value<Integer> iValue2 = ValueUtils.getIntegerValue(right);
		Value<Float> rValue1 = ValueUtils.getRealValue(left);
		Value<Float> rValue2 = ValueUtils.getRealValue(right);

		if (iValue1 != null && iValue2 != null) {
			return new Value<Integer>(performOperation(
					iValue1.getValue().floatValue(),
					iValue2.getValue().floatValue()).intValue());
		} else if (iValue1 != null && rValue2 != null) {
			return new Value<Float>(performOperation(iValue1.getValue()
					.floatValue(), rValue2.getValue()));
		} else if (rValue1 != null && iValue2 != null) {
			return new Value<Float>(performOperation(rValue1.getValue(),
					iValue2.getValue().floatValue()));
		} else if (rValue1 != null && rValue2 != null) {
			return new Value<Float>(performOperation(rValue1.getValue(),
					rValue2.getValue()));
		}
		return value;
	}

	protected abstract Float performOperation(Float a, Float b);
}

package br.ufal.tci.operator;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

public abstract class LogicOperator extends Operator {
	@Override
	protected boolean customizedCheck(Value<?> left, Value<?> right)
			throws SemanticException {
		if (left.isInteger() || left.isReal() || left.isString()) {
			throw new SemanticException(MessageUtil.OPERATOR_NOT_DEFINED);
		}
		if (right.isInteger() || right.isReal() || right.isString()) {
			throw new SemanticException(MessageUtil.OPERATOR_NOT_DEFINED);
		}

		return true;
	}

	@Override
	protected Value<?> execute(Value<?> left, Value<?> right)
			throws SemanticException {
		Value<?> value = null;
		Value<Boolean> bValue1 = ValueUtils.getBooleanValue(left);
		Value<Boolean> bValue2 = ValueUtils.getBooleanValue(right);

		if (bValue1 != null && bValue2 != null) {
			value = applyOperation(left, right);
		}
		return value;
	}

	protected abstract Value<Boolean> applyOperation(Value<?> left,
			Value<?> right) throws SemanticException;
}

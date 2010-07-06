package br.ufal.tci.operator;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.value.Value;

public abstract class Operator {

	public final Value<?> evaluate(Value<?> left, Value<?> right)
			throws SemanticException {
		Value<?> result = null;
		if (defaultCheck(left, right)) {
			if (customizedCheck(left, right)) {
				result = execute(left, right);
			}
		} else {
			throw new SemanticException(MessageUtil.INCOMPATIBLE_TYPES);
		}
		return result;
	}

	protected abstract Value<?> execute(Value<?> left, Value<?> right)
			throws SemanticException;

	protected abstract boolean customizedCheck(Value<?> left, Value<?> right)
			throws SemanticException;

	/**
	 * Confere tipos de acordo com os valores passados como parâmetros e cast
	 * entre tipos
	 */
	protected boolean defaultCheck(Value<?> value1, Value<?> value2)
			throws SemanticException {
		if ((value1 == null) || (value2 == null)) {
			throw new SemanticException(MessageUtil.NOT_INITIALIZED);
		}

		boolean result = false;

		if (value1.isInteger() && (value2.isInteger() || value2.isReal())) {
			result = true;
		}
		if (value1.isReal() && (value2.isInteger() || value2.isReal())) {
			result = true;
		}
		if (value1.isBoolean() && value2.isBoolean()) {
			result = true;
		}
		if (value1.isString() && value2.isString()) {
			result = true;
		}
		if (value1.isObject() && value2.isObject()) {
			result = true;
		}
		return result;
	}

}

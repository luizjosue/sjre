/*
 * Created on 08/09/2004
 */
package br.ufal.tci.operator.relational;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.operator.Operator;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

/**
 * @author ljsf
 */
public abstract class RelationalOperator extends Operator {

	public RelationalOperator() {
	}

	/**
	 * Confere tipos de acordo com os valores passados como parâmetros e cast
	 * entre tipos
	 */
	@Override
	protected boolean defaultCheck(Value<?> value1, Value<?> value2)
			throws SemanticException {
		boolean result = super.defaultCheck(value1, value2);

		if (value1.isInterval() || value2.isInterval()) {
			result = true;
		}

		return result;
	}

	protected abstract Boolean performOperation(Float a, Float b);

	protected abstract Boolean performOperation(String a, String b);

	protected abstract Boolean performOperation(Boolean a, Boolean b);

	@Override
	protected Value<?> execute(Value<?> left, Value<?> right)
			throws SemanticException {
		Value<?> value = null;
		Value<Integer> iValue1 = ValueUtils.getIntegerValue(left);
		Value<Integer> iValue2 = ValueUtils.getIntegerValue(right);
		Value<Float> rValue1 = ValueUtils.getRealValue(left);
		Value<Float> rValue2 = ValueUtils.getRealValue(right);
		Value<Boolean> bValue1 = ValueUtils.getBooleanValue(left);
		Value<Boolean> bValue2 = ValueUtils.getBooleanValue(right);
		Value<String> sValue1 = ValueUtils.getStringValue(left);
		Value<String> sValue2 = ValueUtils.getStringValue(right);

		if (iValue1 != null && iValue2 != null) {
			return new Value<Boolean>(performOperation(iValue1.getValue()
					.floatValue(), iValue2.getValue().floatValue()));
		} else if (iValue1 != null && rValue2 != null) {
			return new Value<Boolean>(performOperation(iValue1.getValue()
					.floatValue(), rValue2.getValue()));
		} else if (rValue1 != null && iValue2 != null) {
			return new Value<Boolean>(performOperation(rValue1.getValue(),
					iValue2.getValue().floatValue()));
		} else if (rValue1 != null && rValue2 != null) {
			return new Value<Boolean>(performOperation(rValue1.getValue(),
					rValue2.getValue()));
		} else if (sValue1 != null && sValue2 != null) {
			return new Value<Boolean>(performOperation(sValue1.getValue(),
					sValue2.getValue()));
		} else if (bValue1 != null && bValue2 != null) {
			return new Value<Boolean>(performOperation(bValue1.getValue(),
					bValue2.getValue()));
		}
		return value;
	}

}

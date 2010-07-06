/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.operator.additive;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.operator.LogicOperator;
import br.ufal.tci.operator.relational.Operators;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 */
public class Or extends LogicOperator implements AdditiveOperator {

	public Or() {
		super();
	}

	@Override
	public String toString() {
		return Operators.OR;
	}

	@Override
	protected Value<Boolean> applyOperation(Value<?> left, Value<?> right)
			throws SemanticException {
		return new Value<Boolean>((Boolean) left.getValue()
				|| (Boolean) right.getValue());
	}
}

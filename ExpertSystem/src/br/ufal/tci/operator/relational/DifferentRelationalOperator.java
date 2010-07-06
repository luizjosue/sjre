/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.operator.relational;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class DifferentRelationalOperator extends RelationalOperator {

	public DifferentRelationalOperator() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Operators.DIFFERENCE;
	}

	@Override
	protected boolean customizedCheck(Value<?> left, Value<?> right)
			throws SemanticException {
		return true;
	}

	@Override
	protected Boolean performOperation(Boolean a, Boolean b) {
		return a != null && b != null && !a.equals(b);
	}

	@Override
	protected Boolean performOperation(Float a, Float b) {
		return a != null && b != null && !a.equals(b);
	}

	@Override
	protected Boolean performOperation(String a, String b) {
		return a != null && b != null && !a.equals(b);
	}
}

/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.operator.additive;

import br.ufal.tci.operator.NumericOperator;
import br.ufal.tci.operator.relational.Operators;

/**
 * @author ljsf
 */
public class Plus extends NumericOperator implements AdditiveOperator {

	public Plus() {
		super();
	}

	@Override
	public String toString() {
		return Operators.PLUS;
	}

	@Override
	protected Float performOperation(Float a, Float b) {
		return a + b;
	}
}

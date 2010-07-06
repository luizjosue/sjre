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
public class Minus extends NumericOperator implements AdditiveOperator {

	public Minus() {
		super();
	}

	@Override
	public String toString() {
		return Operators.MINUS;
	}

	@Override
	protected Float performOperation(Float a, Float b) {
		return a - b;
	}

}

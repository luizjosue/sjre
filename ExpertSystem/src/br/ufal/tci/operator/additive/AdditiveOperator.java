/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.operator.additive;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 */
public interface AdditiveOperator {
	public Value<?> evaluate(Value<?> left, Value<?> right)
			throws SemanticException;
}

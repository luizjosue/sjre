/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.operator.multiplicative;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 */
public interface MultiplicativeOperator {
	public Value<?> evaluate(Value<?> left, Value<?> right)
			throws SemanticException;
}

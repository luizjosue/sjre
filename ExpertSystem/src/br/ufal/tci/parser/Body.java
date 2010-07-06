/*
 * Created on 15/09/2004
 *
 */
package br.ufal.tci.parser;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.IfExpression;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 *
 * 15/09/2004
 *
 */
public class Body {
	
	private IfExpression expression;
	
	public Body(){
		this.expression = null;
	}

	/**
	 * @return
	 */
	public IfExpression getExpression() {
		return expression;
	}

	/**
	 * @param expression
	 */
	public void setExpression(IfExpression expression) {
		this.expression = expression;
	}
	
	/**
	 * Método que avalia o body de acordo com o motor 
	 * de inferência passado como parãmetro
	 * */
	public Value<?> evaluate(InferenceEngineIF engine) throws SemanticException{
		return this.expression.evaluate(engine);
	}

}

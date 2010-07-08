/*
 * Created on 01/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.parser;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class Rule {

	private DecisionStatement statement;

	public Rule() {
		this.statement = null;
	}

	/**
	 * @return
	 */
	public DecisionStatement getStatement() {
		return statement;
	}

	/**
	 * @param statement
	 */
	public void setStatement(DecisionStatement statement) {
		this.statement = statement;
	}

	/**
	 * Método que dispara a regra de acordo com o motor de inferência passado
	 * como parâmetro
	 * 
	 * @throws MissingElementException
	 * */
	public void fire(InferenceEngine engine) throws SemanticException,
			MissingElementException {

		/* Limpa a lista de variáveis temporárias */
		SymbolTable.getInstance().clearTemporaryVariables();

		if (engine.isBackwardChaining()) {
			Value<?> v = this.statement.getBody().evaluate(engine);
			if (v.isBoolean()) {
				boolean value = ValueUtils.getBooleanValue(v).getValue();
				if (value) {
					// caso o body seja verdadeiro avalia(dispara) o head
					this.statement.getHead().evaluate(engine);
					LoggerGenerator.debug("É verdadeiro");
				} else {
					LoggerGenerator.debug("É Falso");
				}
			} else {
				throw new SemanticException(MessageUtil.INCOMPATIBLE_TYPES);
			}
		} else {
			this.statement.getBody().evaluate(engine);
			this.statement.getHead().evaluate(engine);
		}
	}

}

/*
 * Created on 20/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.InferenceEngine;

import java.util.List;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.parser.Fact;
import br.ufal.tci.parser.Rule;
import br.ufal.tci.parser.Variable;

/**
 * @author mfp
 * 
 *         
 *         
 */
public interface Interpreter {

	/**
	 * Retorna uma lista de regras que contenham <b>variable</b> no head da
	 * regra
	 * */
	List<Rule> getRulesWithVariableInHead(Variable variable);

	/**
	 * Dispara a regra passada como parâmetro de acordo com a máquina de
	 * inferência passada como parâmetro
	 * */
	// public boolean fireRule(InferenceEngineIF engine, Rule rule) throws
	// SemanticException;
	/**
	 * Dispara o body da regra passada como parâmetro de acordo com a máquina de
	 * inferência passada como parâmetro
	 * */
	public boolean fireBody(InferenceEngine engine, Rule rule)
			throws SemanticException;

	/**
	 * Dispara o head da regra passada como parâmetro de acordo com a máquina de
	 * inferência passada como parâmetro
	 * */
	public void fireHead(InferenceEngine engine, Rule rule)
			throws SemanticException;

	/**
	 * Método que retorna os fatos
	 * */
	public List<Fact> getFacts();
}

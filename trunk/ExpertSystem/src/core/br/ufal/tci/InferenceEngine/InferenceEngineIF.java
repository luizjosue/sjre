/*
 * Created on 19/09/2004
 *
 * 
 */
package br.ufal.tci.InferenceEngine;

import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.trace.Tracer;
import br.ufal.tci.value.Value;

/**
 * @author knoppix
 * 
 */
public interface InferenceEngineIF {

	/* Constantes */
	public static final int BASE_ASK = 1;
	public static final int ASK_BASE = 2;
	public static final int BASE = 3;

	public static final int BACKWARD_CHAINING = 1;
	public static final int FORWARD_CHAINING = 2;

	/*
	 * buscar regras com variable na cabe�a da regra para cada uma delas tentar
	 * provar (firerule) if provou return true fim -para return false;
	 */

	/*
	 * Method inference referencia-se ao metodo utilizado (Backward chaining ou
	 * Forward chaining) verificar constantes
	 */
	public void setMethodInference(int method);

	public int getMethodInference();

	/*
	 * Option inference referencia-se a opcao de ordem definida perguntar -
	 * provar ASK_BASE provar - perguntar BASE_ASK provar BASE verificar
	 * constantes
	 */
	public void setOptionInference(int option);

	public int getOptionInference();

	/**
	 * M�todo que retorna a interface KnowledgeBaseIF que est� sendo utilizada
	 * */
	public KnowledgeBase getKnowledgeBase();

	/**
	 * Procura uma vari�vel de acordo com o encadeamento implementado
	 * */
	public Value<?> findValue(Variable variable)
			throws MissingElementException, SemanticException;

	public Variable findVariable(String variableName, InferenceEngineIF engine)
			throws MissingElementException, SemanticException;

	// ATENCAO: pergunta ao usu�rio ou prova via encadeamento pra tr�s
	// (proveVariable)

	/**
	 * Indica se o encadeamento � o encadeamento para tr�s
	 * */
	public boolean isBackwardChaining();

	/**
	 * Indica se o encadeamento � o encadeamento para frente
	 * */
	public boolean isFowardChaining();

	/**
	 * M�todo que carrega os fatos
	 * */
	public void loadFacts() throws SemanticException;

	public Tracer getTracer();

	public void setTracer(Tracer trace);
}

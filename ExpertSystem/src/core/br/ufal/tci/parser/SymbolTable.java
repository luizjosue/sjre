/*
 * Created on Sep 8, 2004
 *
 * 
 */
package br.ufal.tci.parser;

import java.util.Collection;
import java.util.LinkedList;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;

/**
 * @author desenvolvimento
 * 
 * 
 */
public class SymbolTable {

	private Collection<Variable> tmpVariables;

	private static SymbolTable symbolTable = null;

	public static SymbolTable getInstance() {
		if (symbolTable == null) {
			symbolTable = new SymbolTable();
		}
		return symbolTable;
	}

	/**
	 * Construtor default de SymbolTable
	 * */
	protected SymbolTable() {
		this.tmpVariables = new LinkedList<Variable>();
	}

	/**
	 * Adiciona uma variavel a tabela de simbolos
	 * */
	public void addVariable(Variable variable, InferenceEngine engine) {
		engine.getKnowledgeBase().addVariable(variable);
	}

	/**
	 * Adiciona uma variável temporária
	 * */
	public void addTmpVariable(Variable variable) {
		this.tmpVariables.add(variable);
	}

	/**
	 * Retorna a variável referenciada por variableName ou levanta uma execessão
	 * caso nao ache inclusive na base de conhecimento
	 */
	public Variable lookup(String variableName, InferenceEngine engine)
			throws MissingElementException, SemanticException {
		/* Procura nas variáveis temporárias */
		for (Variable aux : tmpVariables) {
			if (aux.getIdentifier().getName().equalsIgnoreCase(variableName)) {
				return aux;
			}
		}

		try {
			// return engine.findVariable(variableName,engine);
			return engine.getKnowledgeBase().lookup(variableName);
		} catch (MissingElementException e) {
			throw new MissingElementException(variableName + ": "
					+ MessageUtil.VARIABLE_NOT_DECLARED);
		}
	}

	/**
	 * Retorna a variável referenciada por variableName ou levanta uma excecao
	 * caso nao ache
	 */
	public void update(Variable variable, InferenceEngine engine)
			throws MissingElementException, SemanticException {

		/* Atualiza se estiver nas variáveis temporárias */
		boolean achou = false;
		for (Variable aux : tmpVariables) {
			if (aux.getIdentifier().getName().equalsIgnoreCase(
					variable.getIdentifier().getName())) {
				Variable backup = new Variable();
				backup.setIdentifier(aux.getIdentifier());
				backup.setType(aux.getType());
				try {
					backup.setValue(aux.evaluate());
				} catch (SemanticException e) {
					// TODO
				}
				achou = true;
				this.tmpVariables.remove(aux);
				return;
			}
		}

		if (achou) {
			this.tmpVariables.add(variable);
		}

		try {
			engine.getKnowledgeBase().updateVariable(variable);
		} catch (MissingElementException e) {
			throw new MissingElementException(variable.getIdentifier()
					.getName()
					+ ": " + MessageUtil.VARIABLE_NOT_DECLARED);
		}
	}

	/**
	 * @return Returns the variableList.
	 */
	public Collection<Variable> getListOfVariables(InferenceEngine engine) {
		Collection<Variable> result = new LinkedList<Variable>();
		result.addAll(this.tmpVariables);
		result.addAll(engine.getKnowledgeBase().getAllVariables());
		return result;
	}

	/**
	 * Insere uma variável
	 * */
	public void insertVariable(Variable variable, InferenceEngine engine)
			throws SemanticException {
		try {
			if (engine.getKnowledgeBase().lookup(variable) != null) {
				throw new SemanticException(MessageUtil.VARIABLE_ALREADY_DECLARED);
			}
		} catch (MissingElementException e) {
			engine.getKnowledgeBase().addVariable(variable);
		}
	}

	/**
	 * Limpa a lista de variáveis temporárias
	 * */
	public void clearTemporaryVariables() {
		this.tmpVariables.clear();
	}
}

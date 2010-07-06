/*
 * Created on 19/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.InferenceEngine;

import java.util.List;

import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.value.Value;

/**
 * @author knoppix
 * 
 */
public interface KnowledgeBase {

	public Value<?> lookup(Variable variable) throws MissingElementException;

	public Variable lookup(String variableName) throws MissingElementException;

	public void addVariable(Variable variable);

	public void updateVariable(Variable variable)
			throws MissingElementException, SemanticException;

	public void removeVariable(Variable variable)
			throws MissingElementException;

	public List<Variable> getAllVariables();

	public Value<?> getAssignedVariable(Variable variable)
			throws MissingElementException;

}

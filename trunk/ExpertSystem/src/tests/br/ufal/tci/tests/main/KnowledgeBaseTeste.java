/*
 * Created on 23/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.tests.main;

import java.util.List;

import br.ufal.tci.InferenceEngine.KnowledgeBase;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class KnowledgeBaseTeste implements KnowledgeBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.KnowledgeBaseIF#addVariable(br.ufal.tci.parser
	 * .Variable)
	 */
	public void addVariable(Variable variable) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.KnowledgeBaseIF#getAllVariables()
	 */
	public List<Variable> getAllVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.KnowledgeBaseIF#lookup(java.lang.String)
	 */
	public Variable lookup(String variableName) throws MissingElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.KnowledgeBaseIF#lookup(br.ufal.tci.parser
	 * .Variable)
	 */
	public Value<?> lookup(Variable variable) throws MissingElementException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.KnowledgeBaseIF#removeVariable(br.ufal.tci
	 * .parser.Variable)
	 */
	public void removeVariable(Variable variable)
			throws MissingElementException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.KnowledgeBaseIF#updateVariable(br.ufal.tci
	 * .parser.Variable)
	 */
	public void updateVariable(Variable variable)
			throws MissingElementException, SemanticException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.KnowledgeBaseIF#getAssignedVariable(br.ufal
	 * .tci.parser.Variable)
	 */
	public Value<?> getAssignedVariable(Variable variable)
			throws MissingElementException {
		// TODO Auto-generated method stub
		return null;
	}
}

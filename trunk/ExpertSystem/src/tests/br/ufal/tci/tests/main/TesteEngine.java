/*
 * Created on 23/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.tests.main;

import br.ufal.tci.HandlerObject.HandlerObject;
import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.InferenceEngine.KnowledgeBase;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.trace.Tracer;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class TesteEngine implements InferenceEngineIF {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF#findValue(br.ufal.tci.parser
	 * .Variable)
	 */
	public Value<?> findValue(Variable variable)
			throws MissingElementException, SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF#findVariable(java.lang.
	 * String)
	 */
	public Variable findVariable(String variableName)
			throws MissingElementException, SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#getMethodInference()
	 */
	public int getMethodInference() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#getOptionInference()
	 */
	public int getOptionInference() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#isBackwardChaining()
	 */
	public boolean isBackwardChaining() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#isFowardChaining()
	 */
	public boolean isFowardChaining() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF#setMethodInference(int)
	 */
	public void setMethodInference(int method) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF#setOptionInference(int)
	 */
	public void setOptionInference(int option) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#getKnowledgeBase()
	 */
	public KnowledgeBase getKnowledgeBase() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#loadFacts()
	 */
	public void loadFacts() throws SemanticException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF#findVariable(java.lang.
	 * String, br.ufal.tci.InferenceEngine.InferenceEngineIF)
	 */
	public Variable findVariable(String variableName, InferenceEngineIF engine)
			throws MissingElementException, SemanticException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#getTrace()
	 */
	public Tracer getTracer() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF#setTrace(br.ufal.tci.trace
	 * .TraceIF)
	 */
	public void setTracer(Tracer trace) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#getObjectHandler()
	 */
	public HandlerObject getObjectHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF#setObjectHandler(br.ufal
	 * .tci.HandlerObject.HandlerObjectIF)
	 */
	public void setObjectHandler(HandlerObject objectIF) {
		// TODO Auto-generated method stub

	}

}

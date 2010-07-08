/*
 * Created on 13/09/2004
 *
 */
package br.ufal.tci.tmp;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 *         13/09/2004
 * 
 */
public class IfLocalDeclaration {

	private IfLocalAttribution attribution;

	public IfLocalDeclaration() {
		this.attribution = null;
	}

	/**
	 * @return
	 */
	public IfLocalAttribution getAttribution() {
		return attribution;
	}

	/**
	 * @param attribution
	 */
	public void setAttribution(IfLocalAttribution attribution) {
		this.attribution = attribution;
	}

	public Type getType() {
		return this.attribution.getType();
	}

	public Value<?> evaluate(InferenceEngine engine) throws SemanticException {
		return this.attribution.evaluate(engine);
	}
}

/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.term;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.factor.ThenFactor;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class ThenTerm extends Term {

	private ThenFactor thenFactor;

	private ThenMoreTerms thenMoreTerms;

	public ThenTerm() {
		this.thenFactor = null;
		this.thenMoreTerms = null;
	}

	/**
	 * @return
	 */
	public ThenFactor getThenFactor() {
		return thenFactor;
	}

	/**
	 * @return
	 */
	public ThenMoreTerms getThenMoreTerms() {
		return thenMoreTerms;
	}

	/**
	 * @param factor
	 */
	public void setThenFactor(ThenFactor factor) {
		thenFactor = factor;
	}

	/**
	 * @param terms
	 */
	public void setThenMoreTerms(ThenMoreTerms terms) {
		thenMoreTerms = terms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.term.Term#evaluate(br.ufal.tci.InferenceEngine.InferenceEngineIF
	 * )
	 */
	public Value<?> evaluate(InferenceEngineIF engine) throws SemanticException {
		if (this.thenMoreTerms != null) {
			if (this.thenMoreTerms.getOperator() != null) {
				return this.thenMoreTerms.getOperator().evaluate(
						this.thenFactor.evaluate(engine),
						this.thenMoreTerms.evaluate(engine));
			}
		}
		return this.thenFactor.evaluate(engine);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.term.Term#getType()
	 */
	public Type getType() {
		return Type.cast(this.thenFactor.getType(), this.thenMoreTerms
				.getType());
	}
}

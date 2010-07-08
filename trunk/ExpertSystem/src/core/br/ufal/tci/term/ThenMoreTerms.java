/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.term;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.factor.ThenFactor;
import br.ufal.tci.operator.multiplicative.And;
import br.ufal.tci.operator.multiplicative.MultiplicativeOperator;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class ThenMoreTerms extends Term {

	private MultiplicativeOperator operator;

	private ThenFactor factor;

	private ThenMoreTerms thenMoreTerms;

	public ThenMoreTerms() {
		this.operator = null;
		this.factor = null;
		this.thenMoreTerms = null;
	}

	/**
	 * @return
	 */
	public MultiplicativeOperator getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 */
	public void setOperator(MultiplicativeOperator operator) {
		this.operator = operator;
	}

	/**
	 * @return
	 */
	public ThenFactor getFactor() {
		return factor;
	}

	/**
	 * @return
	 */
	public Term getThenMoreTerms() {
		return thenMoreTerms;
	}

	/**
	 * @param factor
	 */
	public void setFactor(ThenFactor factor) {
		this.factor = factor;
	}

	/**
	 * @param term
	 */
	public void setThenMoreTerms(ThenMoreTerms term) {
		thenMoreTerms = term;
	}

	public boolean isEmpty() {
		if ((this.factor == null) && (this.operator == null)
				&& this.thenMoreTerms == null) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.term.Term#evaluate(br.ufal.tci.InferenceEngine.InferenceEngineIF
	 * )
	 */
	public Value<?> evaluate(InferenceEngine engine) throws SemanticException {
		if (this.thenMoreTerms != null) {
			if (this.thenMoreTerms.getOperator() != null) {
				return this.thenMoreTerms.getOperator().evaluate(
						this.factor.evaluate(engine),
						this.thenMoreTerms.evaluate(engine));
			}
		} else {
			return this.factor.evaluate(engine);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.term.Term#getType()
	 */
	public Type getType() {
		if (this.operator != null) {
			if (this.operator instanceof And) {
				return new BooleanType();
			}
			return Type.cast(this.factor.getType(), this.thenMoreTerms
					.getType());
		}
		return null;
	}
}

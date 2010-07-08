/*
 * Created on 13/09/2004
 *
 */
package br.ufal.tci.term;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.factor.IfFactor;
import br.ufal.tci.operator.multiplicative.And;
import br.ufal.tci.operator.multiplicative.MultiplicativeOperator;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 *         13/09/2004
 * 
 */
public class IfMoreTerms extends Term {

	private MultiplicativeOperator operator;

	private IfFactor factor;

	private IfMoreTerms terms;

	public IfMoreTerms() {
		this.operator = null;
		this.factor = null;
		this.terms = null;
	}

	/**
	 * @return
	 */
	public IfFactor getFactor() {
		return factor;
	}

	/**
	 * @return
	 */
	public MultiplicativeOperator getOperator() {
		return operator;
	}

	/**
	 * @return
	 */
	public IfMoreTerms getTerms() {
		return terms;
	}

	/**
	 * @param factor
	 */
	public void setFactor(IfFactor factor) {
		this.factor = factor;
	}

	/**
	 * @param operator
	 */
	public void setOperator(MultiplicativeOperator operator) {
		this.operator = operator;
	}

	/**
	 * @param terms
	 */
	public void setTerms(IfMoreTerms terms) {
		this.terms = terms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.term.Term#evaluate(br.ufal.tci.InferenceEngine.InferenceEngineIF
	 * )
	 */
	public Value<?> evaluate(InferenceEngine engine) throws SemanticException {
		if (this.terms != null) {
			if (this.terms.getOperator() != null) {
				return this.terms.getOperator().evaluate(
						this.factor.evaluate(engine),
						this.terms.evaluate(engine));
			}
		}
		return this.factor.evaluate(engine);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.term.Term#getType()
	 */
	public Type getType() {
		if (this.operator instanceof And) {
			return new BooleanType();
		}
		if (this.factor != null && this.terms != null) {
			return Type.cast(this.factor.getType(), this.terms.getType());
		}
		return null;
	}
}

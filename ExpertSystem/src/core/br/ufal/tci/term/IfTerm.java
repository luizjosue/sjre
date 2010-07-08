/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.term;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.factor.IfFactor;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 * 
 * 
 */
public class IfTerm extends Term {

	private IfFactor factor;

	private IfMoreTerms terms;

	public IfTerm() {
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
	public IfMoreTerms getTerms() {
		return terms;
	}

	/**
	 * @param factor
	 */
	public void setFactor(IfFactor factor) {
		/*
		 * if(factor.getVariable()!=null){
		 * LoggerGenerator.debug("Variável: Nome: "
		 * +factor.getVariable().getIdentifier
		 * ()+" Valor: "+factor.getVariable().getValue()); }
		 * if(factor.getConstant()!=null){
		 * LoggerGenerator.debug("Constante: Tipo: "
		 * +factor.getConstant().getType
		 * ()+" Valor: "+factor.getConstant().getValue()); }
		 */
		this.factor = factor;
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
	 * @see br.ufal.tci.expression.Expression#getType()
	 */
	public Type getType() {
		return Type.cast(this.factor.getType(), this.terms.getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.expression.Expression#evaluate(br.ufal.tci.InferenceEngine
	 * .InferenceEngineIF)
	 */
	public Value<?> evaluate(InferenceEngine engine) throws SemanticException {
		if (this.terms != null) {
			if (this.terms.getOperator() != null) {
				return this.terms.getOperator().evaluate(
						this.factor.evaluate(engine),
						this.terms.evaluate(engine));
			}
		}

		if (this.factor != null) {
			return this.factor.evaluate(engine);
		}

		return null;
	}
}

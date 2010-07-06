/*
 * Created on 13/09/2004
 *
 */
package br.ufal.tci.factor;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.IfExpression;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.parser.SymbolTable;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.tmp.IfLocalDeclaration;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

/**
 * @author ljsf
 * 
 *         13/09/2004
 * 
 */
public class IfFactor extends Factor {

	private IfLocalDeclaration declaration;

	private IfFactor factor;

	private IfExpression expression;

	public IfFactor() {
		super();
		this.declaration = null;
		this.factor = null;
		this.expression = null;
	}

	/**
	 * @return
	 */
	public IfLocalDeclaration getDeclaration() {
		return declaration;
	}

	/**
	 * @return
	 */
	public IfExpression getExpression() {
		return expression;
	}

	/**
	 * @return
	 */
	public IfFactor getFactor() {
		return factor;
	}

	/**
	 * @param declaration
	 */
	public void setDeclaration(IfLocalDeclaration declaration) {
		this.declaration = declaration;
	}

	/**
	 * @param expression
	 */
	public void setExpression(IfExpression expression) {
		this.expression = expression;
	}

	/**
	 * @param factor
	 */
	public void setFactor(IfFactor factor) {
		this.factor = factor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seebr.ufal.tci.factor.Factor#evaluate(br.ufal.tci.InferenceEngine.
	 * InferenceEngineIF)
	 */
	public Value<?> evaluate(InferenceEngineIF engine) throws SemanticException {

		if (this.constant != null) {
			return this.constant.getValue();
		}
		if (this.variable != null) {
			Variable returnVariable = null;
			try {
				returnVariable = SymbolTable.getInstance().lookup(
						variable.getIdentifier().getName(), engine);
			} catch (MissingElementException e) {
				return this.variable.evaluate();
			}
			if (returnVariable != null) {
				if (!returnVariable.isAssigned()) {
					try {
						returnVariable.setValue(engine
								.findValue(returnVariable));
						returnVariable.setAssigned(true);
					} catch (MissingElementException e) {
						/* TODO vai chegar aqui? */
					}
				} else {
					this.variable = returnVariable;
				}
			}
			return this.variable.evaluate();
		}
		if (this.declaration != null) {
			return this.declaration.evaluate(engine);
		}
		if (this.expression != null) {
			return this.expression.evaluate(engine);
		}
		if (this.factor != null) {
			Value<?> value = this.factor.evaluate(engine);
			Value<Boolean> tmp = ValueUtils.getBooleanValue(value);
			if (tmp == null) {
				throw new SemanticException(MessageUtil.INCOMPATIBLE_TYPES);
			}
			return tmp;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.factor.Factor#getType()
	 */
	public Type getType() {
		if (this.constant != null) {
			return this.constant.getType();
		}
		if (this.declaration != null) {
			return this.declaration.getType();
		}
		if (this.factor != null) {
			return this.factor.getType();
		}
		if (this.expression != null) {
			return this.expression.getType();
		}
		return null;
	}
}

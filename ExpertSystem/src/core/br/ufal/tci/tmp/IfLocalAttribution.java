/*
 * Created on 13/09/2004
 *
 */
package br.ufal.tci.tmp;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.IfExpression;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.operator.relational.IfLocalAttributionOperator;
import br.ufal.tci.parser.Identifier;
import br.ufal.tci.parser.SymbolTable;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.IntegerType;
import br.ufal.tci.type.ObjectType;
import br.ufal.tci.type.RealType;
import br.ufal.tci.type.StringType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 *         13/09/2004
 * 
 */
public class IfLocalAttribution {

	private Identifier identifier;

	private IfLocalAttributionOperator operator;

	private IfExpression expression;

	public IfLocalAttribution() {
		this.identifier = null;
		this.operator = null;
		this.expression = null;
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
	public Identifier getIdentifier() {
		return identifier;
	}

	/**
	 * @return
	 */
	public IfLocalAttributionOperator getOperator() {
		return operator;
	}

	/**
	 * @param expression
	 */
	public void setExpression(IfExpression expression, InferenceEngine engine)
			throws SemanticException {
		try {
			Variable variable = SymbolTable.getInstance().lookup(
					this.identifier.getName(), engine);
			if (variable.getType() == null) {
				if (expression.getType() == null) {
					variable.setType(null);
				} else {
					variable.setType(expression.getType());
					SymbolTable.getInstance().update(variable, engine);
				}
				// atualiza a variável na tabela de símbolos
				SymbolTable.getInstance().update(variable, engine);
			} else {
				if (!Type.match(variable.getType(), expression.getType())) {
					throw new SemanticException(
							MessageUtil.INCOMPATIBLE_TYPES
									+ " Variável já declarada com outro tipo nesta mesma regra: "
									+ this.identifier.getName());
				}
			}
		} catch (MissingElementException e) {
			/* NOTHING TO DO */
		}

		this.expression = expression;
	}

	/**
	 * @param identifier
	 */
	public void setIdentifier(Identifier identifier, InferenceEngine engine)
			throws SemanticException {

		Variable variable = null;

		try {
			variable = SymbolTable.getInstance().lookup(identifier.getName(),
					engine);
		} catch (MissingElementException e) {
			variable = new Variable(identifier);
			SymbolTable.getInstance().addTmpVariable(variable);
		}

		this.identifier = identifier;
	}

	/**
	 * @param operator
	 */
	public void setOperator(IfLocalAttributionOperator operator) {
		this.operator = operator;
	}

	public Type getType() {
		return this.expression.getType();
	}

	public Value<?> evaluate(InferenceEngine engine) throws SemanticException {
		Value<?> value = this.expression.evaluate(engine);
		Variable variable = null;
		try {
			variable = SymbolTable.getInstance().lookup(
					this.identifier.getName(), engine);
			/*
			 * Caso o tipo da variável temporária seja nulo, já que a
			 * determinação do tipo da variável temporária só é possível em
			 * tempo de execução, um tipo é atribuído de acordo com o valor
			 * assumido da expressão
			 */
			if (variable.getType() == null) {
				variable.setType(Value.generateType(value));
			}

			/*
			 * Se o valor da variável for nulo inicializa ela com o valor nunlo
			 * para seu tipo
			 */
			if (variable.getValue() == null) {
				Type auxType = variable.getType();
				if (auxType instanceof IntegerType) {
					variable.setValue(new Value<Integer>(0));
				} else if (auxType instanceof RealType) {
					variable.setValue(new Value<Float>(0f));
				} else if (auxType instanceof BooleanType) {
					variable.setValue(new Value<Boolean>(false));
				} else if (auxType instanceof StringType) {
					variable.setValue(new Value<String>(""));
				} else if (auxType instanceof ObjectType) {
					// TODO como inicializar objectValue
				}
				auxType = null;
			}

			/* Atualiza o valor da variável */
			variable.setValue(value);
			SymbolTable.getInstance().update(variable, engine); // atualiza a
			// variável na
			// tabela de
			// símbolos
		} catch (MissingElementException e) {

			/* Variável ainda não declarada */
			variable = new Variable();
			variable.setType(Value.generateType(value));
			variable.setValue(value);
			variable.setIdentifier(this.identifier);
			SymbolTable.getInstance().addTmpVariable(variable); // insere a
			// variável
			// temporária na
			// tabela de
			// símbolos
		}
		return value;
	}

}

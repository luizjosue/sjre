/*
 * Created on Sep 8, 2004
 *
 * 
 */
package br.ufal.tci.parser;

import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.IntegerType;
import br.ufal.tci.type.RealType;
import br.ufal.tci.type.StringType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author desenvolvimento
 * 
 * 
 */
public class VariableList {

	/**
	 * Tipo da lista de variaveis
	 * */
	private Type type;

	/**
	 * List of identifiers
	 * */
	private List<Identifier> identifiers;

	/**
	 * Construtor que recebe como parametro o tipo da lista
	 * */
	public VariableList(Type type) {
		this.type = type;
		this.identifiers = new LinkedList<Identifier>();
	}

	public VariableList() {
		this.type = new Type();
		this.identifiers = new LinkedList<Identifier>();
	}

	public void setIdentifierCollection(List<Identifier> identifiersList) {
		this.identifiers = identifiersList;
	}

	/**
	 * @return Returns the type.
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            The type to set.
	 */
	public void setType(Type type) {
		this.type = type;
	}

	public void addElementSkipValidation(Identifier variable,
			InferenceEngine engine) throws SemanticException {
		if (this.identifiers.contains(variable)) {
			throw new SemanticException(MessageUtil.VARIABLE_ALREADY_DECLARED);
		} else {
			addVariable(variable, engine);
		}
	}

	private void addVariable(Identifier variable, InferenceEngine engine)
			throws SemanticException {
		Variable variable2 = new Variable();
		variable2.setIdentifier(variable);
		variable2.setType(this.type);
		if (variable2.getType() instanceof IntegerType) {
			variable2.setValue(new Value<Integer>(0));
		} else if (variable2.getType() instanceof RealType) {
			variable2.setValue(new Value<Float>(0f));
		} else if (variable2.getType() instanceof StringType) {
			variable2.setValue(new Value<String>(""));
		} else if (variable2.getType() instanceof BooleanType) {
			variable2.setValue(new Value<Boolean>(false));
		}
		/**
		 * TODO ADICIONAR ObjectType e ObjectValue
		 * */
		SymbolTable.getInstance().insertVariable(variable2, engine);
		this.identifiers.add(variable);
	}

	public void addElement(Identifier variable, InferenceEngine engine)
			throws SemanticException, MissingElementException {
		if (this.identifiers.contains(variable)) {
			throw new SemanticException(MessageUtil.VARIABLE_ALREADY_DECLARED);
		} else {
			Variable tmp = SymbolTable.getInstance().lookup(variable.getName(),
					engine);
			if (tmp == null) {
				throw new SemanticException(
						MessageUtil.VARIABLE_ALREADY_DECLARED + ": "
								+ variable.getName());
			} else {
				addVariable(variable, engine);
			}
		}
	}

}

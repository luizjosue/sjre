/*
 * Created on 29/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.InferenceEngine;

import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.value.Value;

/**
 * @author mfp
 * 
 *         Classe que implementa KnowledgeBase e utiliza o padrao singleton para
 *         garantir a existencia de uma única instância
 * 
 */
public class KnowledgeBaseImpl implements KnowledgeBase {

	private List<Variable> variablesList;

	private static KnowledgeBaseImpl base = null;

	protected KnowledgeBaseImpl() {
		this.variablesList = new LinkedList<Variable>();
	}

	public static KnowledgeBaseImpl getInstance() {
		if (base == null) {
			base = new KnowledgeBaseImpl();
		}
		return base;
	}

	/*
	 * @variable Variavel a ser localizada na base
	 * 
	 * @return Valor da variavel localizada
	 */
	public Value<?> lookup(Variable variable) throws MissingElementException {
		Value<?> result = null;
		for (Variable var : this.variablesList) {
			if (var.getIdentifier().getName().equals(
					variable.getIdentifier().getName())) {
				result = ((Value<?>) var.getValue().getKey());
				break;
			}
		}
		if (result != null) {
			return result;
		} else {
			throw new MissingElementException(MessageUtil.VARIABLE_NOT_FOUND);
		}
	}

	public Variable lookup(String variableName) throws MissingElementException {
		Variable result = null;
		for (Variable var : this.variablesList) {
			if (var.getIdentifier().getName().equals(variableName)) {
				try {
					result = (Variable) var.clone();
					break;
				} catch (CloneNotSupportedException ce) {
					ce.printStackTrace();
					// TODO throw any exception
				}
			}
		}
		if (result != null) {
			return result;
		} else {
			throw new MissingElementException(MessageUtil.VARIABLE_NOT_FOUND);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.KnowledgeBaseIF#addVariable(br.ufal.tci.parser
	 * .Variable)
	 */
	public void addVariable(Variable variable) {
		this.variablesList.add(variable);
	}

	/*
	 * @variable Variavel a ser atualizada
	 */
	public void updateVariable(Variable variable)
			throws MissingElementException, SemanticException {
		boolean found = false;
		for (Variable var : this.variablesList) {
			if (var.getIdentifier().getName().equals(
					variable.getIdentifier().getName())) {
				this.variablesList.remove(var);
				// var.setValue(variable.getValue());
				// var = variable;
				found = true;
				break;
			}
		}
		if (!found) {
			throw new MissingElementException(MessageUtil.VARIABLE_NOT_FOUND);
		} else {
			this.variablesList.add(variable);
		}

	}

	/*
	 * @variable Variavel a ser removida
	 */
	public void removeVariable(Variable variable)
			throws MissingElementException {
		boolean found = false;
		for (Variable var : this.variablesList) {
			if (var.getIdentifier().getName().equals(
					variable.getIdentifier().getName())) {
				this.variablesList.remove(var);
				found = true;
				break;
			}
		}

		if (!found) {
			throw new MissingElementException(MessageUtil.VARIABLE_NOT_FOUND);
		}
	}

	public List<Variable> getAllVariables() {
		return this.variablesList;
	}

	/*
	 * Método que procura por uma variável e testa se a ela ja foi atribuido
	 * algum valor, se nao levanta uma excessao NotFoundException
	 */
	public Value<?> getAssignedVariable(Variable variable)
			throws MissingElementException {
		Variable aux = null;
		if ((aux = this.lookup(variable.getIdentifier().getName()))
				.isAssigned()) {
			return aux.evaluate();
		}
		/*
		 * Já que a variável ainda não foi inicializada ela será tratada como
		 * não encontada e portanto cabivel de ser provada
		 */
		throw new MissingElementException(MessageUtil.NOT_INITIALIZED + ": "
				+ variable.getIdentifier().getName());
	}
}

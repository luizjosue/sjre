/*
 * Created on 21/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.InferenceEngine;

import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.parser.Fact;
import br.ufal.tci.parser.Rule;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.trace.Tracer;
import br.ufal.tci.ui.UserInterfaceImpl;
import br.ufal.tci.value.Value;

/**
 * @author mfp
 * 
 *         Classe que implementa InferenceEngineIF
 * 
 */
public class InferenceEngine implements InferenceEngineIF {

	private Interpreter interpreter;
	private KnowledgeBase knowledgebase;
	private Tracer tracer;
	/*
	 * methodInference trata do método usado (backward chaining ou forward
	 * chaining) veja constantes para saber valores
	 */
	private int methodInference;
	/*
	 * optionInference trata do opcao de ordem da resolucao escolhida pelo
	 * usuario perguntar -> provar provar -> perguntar provar veja constantes
	 * para saber valores
	 */
	private int optionInference;
	private List<Variable> listOfVariables;
	private UserInterfaceImpl userInterface;

	public void addVariable(Variable var) {
		this.listOfVariables.add(var);
	}

	public void setMethodInference(int mi) {
		this.methodInference = mi;
	}

	public int getMethodInference() {
		return this.methodInference;
	}

	public void setOptionInference(int oi) {
		this.optionInference = oi;
	}

	public int getOptionInference() {
		return this.optionInference;
	}

	/* TODO */
	/* Mudar parametros dos construtores para as implementacoes desta classes */
	public InferenceEngine(Interpreter ip, KnowledgeBase klb) {
		this.interpreter = ip;
		this.knowledgebase = klb;
		this.listOfVariables = new LinkedList<Variable>();
		this.setMethodInference(InferenceEngine.BACKWARD_CHAINING);
		this.setOptionInference(InferenceEngine.ASK_BASE);
	}

	private boolean proveVariable(Variable variable) throws SemanticException {
		List<Rule> listRules = interpreter.getRulesWithVariableInHead(variable);
		boolean result = false;
		/* Verificacao se ja nao tentou-se provar a variavel em questao */
		if (!listOfVariables.contains(variable)) {
			/* A variavel ainda nao foi verificada e pode continuar */
			/* Inseri a nova variavel na lista */
			listOfVariables.add(variable);
			for (Rule rule : listRules) {
				// TODO trace: tentando provar regra rule
				// this.trace.addMessage("<<tentando provar regra>>");
				if (interpreter.fireBody(this, rule)) {
					interpreter.fireHead(this, rule);
					// TODO trace: conseguiu disparar regra rule
					result = true;
					break;
				} else {
					// TODO trace: Nao conseguiu provar regra rule por causa da
					// variavel x
					// this.trace.addMessage("<<não conseguiu provar regra>>");
				}

				/*
				 * if (interpreter.fireRule(this, (Rule)iterator.next()) ==
				 * true){ return true; }
				 */
			}
		} else {
			/* A variavel ja foi provada */
			/*
			 * inserir metodo da base de conhecimento que compara uma variavel
			 * com a base de conhecimento e verifica se os valores sao iguais e
			 * retorna true ou false
			 */
		}
		return result;
	}

	public Value<?> findValue(Variable variable)
			throws MissingElementException, SemanticException {
		Object value;
		/*
		 * O procedimento para se buscar uma varia¡vel eh o seguinte:
		 */
		try {
			/*
			 * TODO AQUI verificar: criar um flag em Variable indicando se a
			 * variavel foi ou nao já modificada e entao no lookup de
			 * knowledgebase verifica se a variável foi alterada ou nao se nao
			 * retorna falso
			 * 
			 * --->>> criar um lookup especial para isso??????
			 */
			// return this.knowledgebase.lookup(variable);
			return this.knowledgebase.getAssignedVariable(variable);
		} catch (MissingElementException nfe) {

			// apenas para teste -->>> tentar provar
			this.setOptionInference(InferenceEngine.BASE);

			switch (this.getOptionInference()) {

			case InferenceEngine.ASK_BASE:
				/* Pergunta ao usuario */
				value = this.userInterface.getAsk(variable);
				if (value != null) {
					return (Value<?>) value;
				}
				if (!this.proveVariable(variable)) {
					return null;
				}
				break;

			case InferenceEngine.BASE_ASK:
				if (!this.proveVariable(variable)) {
					return null;
				}
				/* Pergunta ao usuario */
				value = this.userInterface.getAsk(variable);
				if (value != null) {
					return (Value<?>) value;
				}
				break;

			case InferenceEngine.BASE:
				if (!this.proveVariable(variable)) {
					return null;
				}
				break;

			}
			return variable.evaluate();
		}
	}

	/**
	 * Procura na base a variável pelo nome
	 * */
	public Variable findVariable(String variableName, InferenceEngineIF engine)
			throws MissingElementException, SemanticException {
		/*
		 * O procedimento para se buscar uma varia¡vel eh o seguinte:
		 */
		return this.knowledgebase.lookup(variableName);

		/*
		 * Object value; / O procedimento para se buscar uma varia¡vel eh o
		 * seguinte:
		 */
		/*
		 * Variable variable = null;
		 * 
		 * variable = this.knowledgebase.lookup(variableName);
		 * 
		 * if (variable==null){ throw new
		 * NotFoundException(Messages.VARIABLE_NOT_FOUND+": "+variableName); }
		 * 
		 * if (!variable.isAssigned()){ if(this.proveVariable(variable)){
		 * variable.setAssigned(true); SymbolTable.Instance().update(variable,
		 * engine); return variable; } } else { return variable; } return
		 * variable;
		 */
	}

	public boolean isBackwardChaining() {
		return true;
	}

	public boolean isFowardChaining() {
		return !this.isBackwardChaining();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#getKnowledgeBase()
	 */
	public KnowledgeBase getKnowledgeBase() {
		return this.knowledgebase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InferenceEngineIF#loadFacts()
	 */
	public void loadFacts() throws SemanticException {
		try {
			for (Fact fact : this.interpreter.getFacts()) {
				fact.evaluate(this);
			}
		} catch (MissingElementException e) {
			e.printStackTrace();
			throw new SemanticException(e.getMessage());
		}
	}

	/**
	 * @return Returns the trace.
	 */
	public Tracer getTracer() {
		return tracer;
	}

	/**
	 * @param trace
	 *            The trace to set.
	 */
	public void setTracer(Tracer trace) {
		this.tracer = trace;
	}

}

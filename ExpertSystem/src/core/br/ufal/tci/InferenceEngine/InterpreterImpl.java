/*
 * Created on 12/10/2004
 *
 * 
 * 
 */
package br.ufal.tci.InferenceEngine;

import java.io.InputStream;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.JJTREE.ASTStart;
import br.ufal.tci.JJTREE.ParseException;
import br.ufal.tci.JJTREE.Parser_1;
import br.ufal.tci.JJTREE.Parser_1DumpVisitor;
import br.ufal.tci.JJTREE.Parser_1Visitor;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.exception.SyntaticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.parser.Fact;
import br.ufal.tci.parser.Program;
import br.ufal.tci.parser.Rule;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.util.StringInputStream;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

/**
 * @author ljsf
 * 
 *         Classe que implementa a interface Iterpreter e que tem as
 *         propriedades básicas do interpretador
 * 
 */
public class InterpreterImpl implements Interpreter {

	/**
	 * Representa o parser
	 * */
	private Parser_1 parser;

	/**
	 * Construtor que recebe o fonte como String, e uma InferenceEngineIF para
	 * ser utilizada durante a inferência
	 * */
	public InterpreterImpl(String source) {
		this.parser = new Parser_1(new StringInputStream(new StringReader(
				source)));
	}

	/**
	 * Construtor que recebe o fonte como um InputStream, e uma
	 * InferenceEngineIF para ser utilizada durante a inferência
	 * */
	public InterpreterImpl(InputStream sourceStream) {
		this.parser = new Parser_1(sourceStream);
	}

	/**
	 * Analisa sintaticamente e cria a representacao intermediaria em forma de
	 * arvore
	 * */
	public void createParserTree(InferenceEngineIF engine)
			throws SyntaticException, SemanticException {
		ASTStart start;
		Parser_1Visitor visitor;

		try {
			start = this.parser.Start();
			visitor = new Parser_1DumpVisitor();
			start.jjtAccept(visitor, null, engine);
			Program program = Program.Instance();
			LoggerGenerator.debug(program);
		} catch (ParseException e) {
			throw new SyntaticException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InterpreterIF#getRulesWithVariableInHead(
	 * br.ufal.tci.parser.Variable)
	 */
	public List<Rule> getRulesWithVariableInHead(Variable variable) {
		List<Rule> list = new LinkedList<Rule>();
		List<Rule> listofRules = Program.Instance().getRuleDeclaration()
				.getListOfRules();
		for (Rule rule : listofRules) {
			/* lista de conclusoes do head da regra */
			List<Fact> conclusionList = rule.getStatement().getHead()
					.getConclusionList();
			for (Fact fact : conclusionList) {
				boolean found = false;
				/* Compara a variavel passada como parametro */
				if (fact.getIdentifier().getName().equalsIgnoreCase(
						variable.getIdentifier().getName().toLowerCase())) {
					/* Adiciona a regra que combinou */
					list.add(rule);
					found = true;
					break;
				}
				if (found) {
					/* A regra já foi incluida na lista */
					break;
				}
			}
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.InferenceEngine.InterpreterIF#fireRule(br.ufal.tci.parser
	 * .Rule)
	 */
	/*
	 * public boolean fireRule(InferenceEngineIF engine, Rule rule) throws
	 * SemanticException {
	 * 
	 * Value value;
	 * 
	 * value = rule.getStatement().getBody().evaluate(engine);
	 * 
	 * / Testa a semantica da expressao
	 */
	/*
	 * if (!(value instanceof BooleanValue)){ / Erro semantico, tipos
	 * incompatíveis
	 */
	/*
	 * throw new SemanticException(Messages.INCOMPATIBLE_TYPES); }
	 * 
	 * return ((BooleanValue)value).getValue();
	 * 
	 * }
	 */

	public void fireHead(InferenceEngineIF engine, Rule rule)
			throws SemanticException {
		try {
			rule.getStatement().getHead().evaluate(engine);
		} catch (MissingElementException e) {
			e.printStackTrace();
			throw new SemanticException(e.getMessage());
		}
	}

	public boolean fireBody(InferenceEngineIF engine, Rule rule)
			throws SemanticException {

		Value<?> value = rule.getStatement().getBody().evaluate(engine);

		/* Testa a semantica da expressao */
		if (!value.isBoolean()) {
			/* Erro semantico, tipos incompatíveis */
			throw new SemanticException(MessageUtil.INCOMPATIBLE_TYPES);
		}

		return ValueUtils.getBooleanValue(value).getValue();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.InferenceEngine.InterpreterIF#getFacts()
	 */
	public List<Fact> getFacts() {
		return Program.Instance().getFactDeclaration().getListOfFacts();
	}

}

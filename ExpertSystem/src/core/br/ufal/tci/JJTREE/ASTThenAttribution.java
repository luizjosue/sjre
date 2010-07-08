/* Generated By:JJTree: Do not edit this line. ASTThenAttribution.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.ThenSimpleExpression;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.operator.additive.AdditiveOperator;
import br.ufal.tci.operator.relational.EqualRelationalOperator;
import br.ufal.tci.parser.Fact;
import br.ufal.tci.parser.Identifier;

public class ASTThenAttribution extends SimpleNode {

	private List<Identifier> identifiers;

	private boolean attribution;

	public ASTThenAttribution(int id) {
		super(id);
		this.identifiers = new LinkedList<Identifier>();
	}

	public ASTThenAttribution(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator
				.debug("Visitando " + this.getClass().getCanonicalName());
		try {
			if (data instanceof ThenSimpleExpression) {
				ThenSimpleExpression simpleExpression = (ThenSimpleExpression) data;
				AdditiveOperator operator = null;
				operator = (AdditiveOperator) visitor.visit(this, operator,
						engine);
				simpleExpression.setOperator(operator);
				return simpleExpression;
			} else if (data instanceof Fact) {
				Fact fact = (Fact) data;
				if (!this.identifiers.isEmpty()) {
					if (this.identifiers.size() < 2) { // vari�vel simples
						Iterator<Identifier> iterator = this.identifiers
								.iterator();
						fact.setIdentifier(new Identifier(iterator.next()
								.toString()), engine);
						fact = (Fact) visitor.visit(this, fact, engine);
						if (this.attribution) {
							fact
									.setRelationalOperator(new EqualRelationalOperator());
						}
						return fact;
					} else {
						// TODO chamada a objetos
					}

				} else {
					// TODO levantar que excecao?
				}
			}
		} catch (MissingElementException e) {
			throw new SemanticException(e.getMessage());
		}

		return visitor.visit(this, data, engine);
	}

	public void addIdentifier(String identifierName) {
		this.identifiers.add(new Identifier(identifierName));
	}

	public void setAttribution(boolean attribution) {
		this.attribution = attribution;
	}

}
/*
 * JavaCC - OriginalChecksum=2d0a28b761ac0d5d859e8caf9219451e (do not edit this
 * line)
 */

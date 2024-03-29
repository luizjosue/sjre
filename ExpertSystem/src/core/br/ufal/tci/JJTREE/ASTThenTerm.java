/* Generated By:JJTree: Do not edit this line. ASTThenTerm.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.ThenMoreSimpleExpression;
import br.ufal.tci.expression.ThenSimpleExpression;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.term.ThenTerm;

public class ASTThenTerm extends SimpleNode {
	public ASTThenTerm(int id) {
		super(id);
	}

	public ASTThenTerm(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof ThenSimpleExpression) { // para ThenSimpleExpression
			ThenSimpleExpression simpleExpression = (ThenSimpleExpression) data;
			ThenTerm term = new ThenTerm();
			term = (ThenTerm) visitor.visit(this, term, engine);
			simpleExpression.setTerm(term);
			return simpleExpression;

		} else if (data instanceof ThenMoreSimpleExpression) { // para
																// ThenMoreSimpleExpression
			ThenMoreSimpleExpression expression = (ThenMoreSimpleExpression) data;
			ThenTerm term = new ThenTerm();
			term = (ThenTerm) visitor.visit(this, term, engine);
			expression.setTerm(term);
			return expression;
		}

		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=342ed7fc772898af669eec68ba177295 (do not edit this
 * line)
 */

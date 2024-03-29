/* Generated By:JJTree: Do not edit this line. ASTThenSimpleExpression.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.ThenExpression;
import br.ufal.tci.expression.ThenSimpleExpression;
import br.ufal.tci.logger.LoggerGenerator;

public class ASTThenSimpleExpression extends SimpleNode {
	public ASTThenSimpleExpression(int id) {
		super(id);
	}

	public ASTThenSimpleExpression(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof ThenExpression) {
			ThenExpression thenExpression = (ThenExpression) data;
			ThenSimpleExpression thenSimpleExpression = new ThenSimpleExpression();
			thenSimpleExpression = (ThenSimpleExpression) visitor.visit(this,
					thenSimpleExpression, engine);
			thenExpression.setSimpleExpression(thenSimpleExpression);
			return thenExpression;
		}

		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=be38516cd34cdf7474420e6dcb9280f9 (do not edit this
 * line)
 */

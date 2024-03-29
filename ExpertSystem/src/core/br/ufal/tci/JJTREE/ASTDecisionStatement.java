/* Generated By:JJTree: Do not edit this line. ASTDecisionStatement.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.DecisionStatement;
import br.ufal.tci.parser.Rule;

public class ASTDecisionStatement extends SimpleNode {
	public ASTDecisionStatement(int id) {
		super(id);
	}

	public ASTDecisionStatement(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof Rule) {
			Rule rule = (Rule) data;
			DecisionStatement statement = new DecisionStatement();
			statement = (DecisionStatement) visitor.visit(this, statement,
					engine);

			rule.setStatement(statement);

			return rule;
		}

		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=c77750fa42265e0d410ff76c93b71e64 (do not edit this
 * line)
 */

/* Generated By:JJTree: Do not edit this line. ASTMethodInvocation.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;

public class ASTMethodInvocation extends SimpleNode {
	public ASTMethodInvocation(int id) {
		super(id);
	}

	public ASTMethodInvocation(Parser_1 p, int id) {
		super(p, id);
	}

	/**
	 * Accept the visitor.
	 * 
	 * @throws SemanticException
	 **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=49d30e0892b501b6ce22156aa6a4c478 (do not edit this
 * line)
 */

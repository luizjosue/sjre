/* Generated By:JJTree: Do not edit this line. ASTProgram.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;

public class ASTProgram extends SimpleNode {
	public ASTProgram(int id) {
		super(id);
	}

	public ASTProgram(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=81489a215b56de8d1e5147350309a2d3 (do not edit this
 * line)
 */

/* Generated By:JJTree: Do not edit this line. ASTInteger.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Argument;
import br.ufal.tci.parser.Constant;

public class ASTInteger extends SimpleNode {

	public ASTInteger(int id) {
		super(id);
	}

	public ASTInteger(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof Argument) {
			Argument argument = (Argument) data;
			argument.addIdentifier(new Constant(Integer
					.parseInt(this.token.image)));
			return argument;
		}
		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=d0be6a7c8f84f94ca57846e8f9886790 (do not edit this
 * line)
 */

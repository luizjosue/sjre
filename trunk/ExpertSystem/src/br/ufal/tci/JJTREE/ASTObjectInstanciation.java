/* Generated By:JJTree: Do not edit this line. ASTObjectInstanciation.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Fact;
import br.ufal.tci.parser.ObjectInstance;

public class ASTObjectInstanciation extends SimpleNode {
	public ASTObjectInstanciation(int id) {
		super(id);
	}

	public ASTObjectInstanciation(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngineIF engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		Object result = null;
		if (data instanceof Fact) {
			Fact fact = (Fact) data;
			ObjectInstance instance = (ObjectInstance) visitor.visit(this,
					new ObjectInstance(), engine);
			fact.setObjectInstantiation(instance);
			result = fact;
		}

		return (result != null) ? result : visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=e67309e5a918a01a1889e6299814711f (do not edit this
 * line)
 */

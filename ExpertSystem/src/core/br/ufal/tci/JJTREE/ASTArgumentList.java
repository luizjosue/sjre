/* Generated By:JJTree: Do not edit this line. ASTArgumentList.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.ObjectInstance;
import br.ufal.tci.parser.Unit;

public class ASTArgumentList extends SimpleNode {
	public ASTArgumentList(int id) {
		super(id);
	}

	public ASTArgumentList(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	@SuppressWarnings("unchecked")
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof ObjectInstance) {
			ObjectInstance instance = (ObjectInstance) data;
			List<Unit> list = new LinkedList<Unit>();
			list = (List<Unit>) visitor.visit(this, list, engine);
			instance.setArgumentList(list);
			return instance;
		}
		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=8b60848f90bf0b8104e597c1f2ba877b (do not edit this
 * line)
 */

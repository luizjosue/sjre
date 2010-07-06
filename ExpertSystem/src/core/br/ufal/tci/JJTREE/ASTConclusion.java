/* Generated By:JJTree: Do not edit this line. ASTConclusion.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import java.util.List;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Fact;

public class ASTConclusion extends SimpleNode {
	public ASTConclusion(int id) {
		super(id);
	}

	public ASTConclusion(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	@SuppressWarnings("unchecked")
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngineIF engine) throws SemanticException {

		LoggerGenerator
				.debug("Visitando " + this.getClass().getCanonicalName());
		Object result = null;

		if (data instanceof List) {
			// List dataList = (List) data;
			// if (!dataList.isEmpty()) {
			List<Fact> factList = (List<Fact>) data;
			Fact fact = (Fact) visitor.visit(this, new Fact(), engine);
			factList.add(fact);
			result = factList;
			// }
		}

		return (result != null) ? result : visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=7dc190c192018f117bf58214dcba6f7c (do not edit this
 * line)
 */
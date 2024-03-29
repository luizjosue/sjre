/* Generated By:JJTree: Do not edit this line. ASTListOfFacts.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Fact;
import br.ufal.tci.parser.FactDeclaration;

public class ASTListOfFacts extends SimpleNode {
	public ASTListOfFacts(int id) {
		super(id);
	}

	public ASTListOfFacts(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	@SuppressWarnings("unchecked")
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		Object result = null;
		if (data instanceof FactDeclaration) {
			FactDeclaration factDeclaration = (FactDeclaration) data;
			List<Fact> factList = (List<Fact>) visitor.visit(this,
					new LinkedList<Fact>(), engine);
			factDeclaration.setListOfFacts(factList);
			result = factDeclaration;
		}

		return (result != null) ? result : visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=abf65c5bb3bd7a21321c4533d3c8a634 (do not edit this
 * line)
 */

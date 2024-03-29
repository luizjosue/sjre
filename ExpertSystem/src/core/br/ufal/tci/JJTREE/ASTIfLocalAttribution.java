/* Generated By:JJTree: Do not edit this line. ASTIfLocalAttribution.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.tmp.IfLocalAttribution;
import br.ufal.tci.tmp.IfLocalDeclaration;

public class ASTIfLocalAttribution extends SimpleNode {
	public ASTIfLocalAttribution(int id) {
		super(id);
	}

	public ASTIfLocalAttribution(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof IfLocalDeclaration) {
			IfLocalDeclaration declaration = (IfLocalDeclaration) data;
			IfLocalAttribution attribution = new IfLocalAttribution();
			attribution = (IfLocalAttribution) visitor.visit(this, attribution,
					engine);
			declaration.setAttribution(attribution);

			return declaration;
		}

		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=034d549a5d4756ef7337f16d6eb4fa19 (do not edit this
 * line)
 */

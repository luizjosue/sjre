/* Generated By:JJTree: Do not edit this line. ASTMultiplicativeOperator.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.operator.multiplicative.And;
import br.ufal.tci.operator.multiplicative.Division;
import br.ufal.tci.operator.multiplicative.MultiplicativeOperator;
import br.ufal.tci.operator.multiplicative.Times;
import br.ufal.tci.term.IfMoreTerms;

public class ASTMultiplicativeOperator extends SimpleNode {
	public ASTMultiplicativeOperator(int id) {
		super(id);
	}

	public ASTMultiplicativeOperator(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof IfMoreTerms) {
			IfMoreTerms terms = (IfMoreTerms) data;
			MultiplicativeOperator operator = null;

			if (this.name.equalsIgnoreCase("and")) {
				operator = new And();
			} else if (this.name.equalsIgnoreCase("/")) {
				operator = new Division();
			} else if (this.name.equalsIgnoreCase("*")) {
				operator = new Times();
			}

			terms.setOperator(operator);

			return terms;

		}

		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=adfbbb130bcbf74668f76082ba5c1acf (do not edit this
 * line)
 */
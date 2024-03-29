/* Generated By:JJTree: Do not edit this line. ASTArgument.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import java.util.List;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Argument;

public class ASTArgument extends SimpleNode {
	public ASTArgument(int id) {
		super(id);
	}

	public ASTArgument(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	@SuppressWarnings("unchecked")
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		Object result = null;
		if (data instanceof List) {
			List dataList = (List) data;
			if (!dataList.isEmpty()) {
				if (dataList.iterator().next() instanceof Argument) {
					List<Argument> argumentList = (List<Argument>) dataList;
					Argument argument = new Argument();
					argument = (Argument) visitor.visit(this, argument, engine);
					argumentList.add(argument);
					return argumentList;
				}
			}
		}
		return (result != null) ? result : visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=f4a5c8a79ad8986f8be4ad7804848aaa (do not edit this
 * line)
 */

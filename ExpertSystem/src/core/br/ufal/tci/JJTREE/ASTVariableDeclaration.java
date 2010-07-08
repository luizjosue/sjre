/* Generated By:JJTree: Do not edit this line. ASTVariableDeclaration.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Program;
import br.ufal.tci.parser.VariableDeclaration;

public class ASTVariableDeclaration extends SimpleNode {
	public ASTVariableDeclaration(int id) {
		super(id);
	}

	public ASTVariableDeclaration(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		Program program = Program.Instance();
		VariableDeclaration variableDeclaration = new VariableDeclaration();
		Object returnObject = visitor.visit(this, variableDeclaration, engine);
		variableDeclaration = (VariableDeclaration) returnObject;
		program.setVariableDeclaration(variableDeclaration);
		return returnObject;
	}
}
/*
 * JavaCC - OriginalChecksum=f33905c28093e972ce8cca1dce2b61d6 (do not edit this
 * line)
 */

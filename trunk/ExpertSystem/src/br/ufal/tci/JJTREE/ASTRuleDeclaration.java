/* Generated By:JJTree: Do not edit this line. ASTRuleDeclaration.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Program;
import br.ufal.tci.parser.RuleDeclaration;

public class ASTRuleDeclaration extends SimpleNode {
	public ASTRuleDeclaration(int id) {
		super(id);
	}

	public ASTRuleDeclaration(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngineIF engine) throws SemanticException {
		LoggerGenerator.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof Program) {
			Program program = Program.Instance();
			RuleDeclaration ruleDeclaration = new RuleDeclaration();
			ruleDeclaration = (RuleDeclaration) visitor.visit(this,
					ruleDeclaration, engine);

			program.setRuleDeclaration(ruleDeclaration);

			return program;
		}

		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=e550de6afbb4264f2c438a75e2a58391 (do not edit this
 * line)
 */
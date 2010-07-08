/* Generated By:JJTree: Do not edit this line. ASTIfRelationalOperator.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.IfExpression;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.operator.relational.DifferentRelationalOperator;
import br.ufal.tci.operator.relational.EqualRelationalOperator;
import br.ufal.tci.operator.relational.GreaterOrEqualRelationalOperator;
import br.ufal.tci.operator.relational.GreaterThanRelationalOperator;
import br.ufal.tci.operator.relational.LessOrEqualRelationalOperator;
import br.ufal.tci.operator.relational.LessThanRelationalOperator;
import br.ufal.tci.operator.relational.RelationalOperator;

public class ASTIfRelationalOperator extends SimpleNode {
	public ASTIfRelationalOperator(int id) {
		super(id);
	}

	public ASTIfRelationalOperator(Parser_1 p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(Parser_1Visitor visitor, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator
				.debug("Visitando " + this.getClass().getCanonicalName());
		if (data instanceof IfExpression) {
			IfExpression expression = (IfExpression) data;
			RelationalOperator operator = null;

			if (this.name.equalsIgnoreCase("=")) {
				operator = new EqualRelationalOperator();
			} else if (this.name.equalsIgnoreCase("<")) {
				operator = new LessThanRelationalOperator();
			} else if (this.name.equalsIgnoreCase(">")) {
				operator = new GreaterThanRelationalOperator();
			} else if (this.name.equalsIgnoreCase("<=")) {
				operator = new LessOrEqualRelationalOperator();
			} else if (this.name.equalsIgnoreCase(">=")) {
				operator = new GreaterOrEqualRelationalOperator();
			} else if (this.name.equalsIgnoreCase("!=")) {
				operator = new DifferentRelationalOperator();
			}

			expression.setOperator(operator);

			return expression;
		}

		return visitor.visit(this, data, engine);
	}
}
/*
 * JavaCC - OriginalChecksum=a7f07f25ac1ff75f975abbbdc95700f5 (do not edit this
 * line)
 */

/* Generated By:JavaCC: Do not edit this line. Parser_1Visitor.java Version 4.2 */
package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;

public interface Parser_1Visitor {
	public Object visit(SimpleNode node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTRoot node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTStart node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTObjectInstanciation node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTID node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTInterval node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTListOfNumbers node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTArgumentList node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTInteger node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTFloatPoint node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTCharacterLiteral node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTStringLiteral node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTArgument node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTVariableDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTVariableList node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTType node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTConstant node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTVariable node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTIfRelationalOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfExpression node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfAdditiveOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfMoreSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfTerm node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTMultiplicativeOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfMoreTerms node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfLocalDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfLocalAttribution node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfLocalAttributionOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTIfFactor node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTThenRelationalOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenExpression node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenAdditiveOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenMoreSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenTerm node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTThenMultiplicativeOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenMoreTerms node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenFactor node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTRuleDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTListOfRules node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTRule node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTDecisionStatement node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTBody node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTHead node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTConclusionList node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTConclusion node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTFactDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTListOfFacts node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTFact node, Object data, InferenceEngine engine)
			throws SemanticException;
			
	public Object visit(ASTMethodInvocation node, Object data, InferenceEngine engine)
			throws SemanticException;

	public Object visit(ASTThenInclusiveOperator node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTThenAttribution node, Object data,
			InferenceEngine engine) throws SemanticException;

	public Object visit(ASTProgram node, Object data, InferenceEngine engine)
			throws SemanticException;
}
/*
 * JavaCC - OriginalChecksum=c6458f10ee672cd8fd4b84e7de830824 (do not edit this
 * line)
 */

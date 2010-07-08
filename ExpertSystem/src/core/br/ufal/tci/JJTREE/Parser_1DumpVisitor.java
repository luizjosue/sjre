package br.ufal.tci.JJTREE;

import br.ufal.tci.InferenceEngine.InferenceEngine;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Program;

/*
 * Copyright © 2002 Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * California 95054, U.S.A. All rights reserved.  Sun Microsystems, Inc. has
 * intellectual property rights relating to technology embodied in the product
 * that is described in this document. In particular, and without limitation,
 * these intellectual property rights may include one or more of the U.S.
 * patents listed at http://www.sun.com/patents and one or more additional
 * patents or pending patent applications in the U.S. and in other countries.
 * U.S. Government Rights - Commercial software. Government users are subject
 * to the Sun Microsystems, Inc. standard license agreement and applicable
 * provisions of the FAR and its supplements.  Use is subject to license terms.
 * Sun,  Sun Microsystems,  the Sun logo and  Java are trademarks or registered
 * trademarks of Sun Microsystems, Inc. in the U.S. and other countries.  This
 * product is covered and controlled by U.S. Export Control laws and may be
 * subject to the export or import laws in other countries.  Nuclear, missile,
 * chemical biological weapons or nuclear maritime end uses or end users,
 * whether direct or indirect, are strictly prohibited.  Export or reexport
 * to countries subject to U.S. embargo or to entities identified on U.S.
 * export exclusion lists, including, but not limited to, the denied persons
 * and specially designated nationals lists is strictly prohibited.
 */

/* This is an example of how the Visitor pattern might be used to
 implement the dumping code that comes with SimpleNode.  It's a bit
 long-winded, but it does illustrate a couple of the main points.

 1) the visitor can maintain state between the nodes that it visits
 (for example the current indentation level).

 2) if you don't implement a jjtAccept() method for a subclass of
 SimpleNode, then SimpleNode's acceptor will get called.

 3) the utility method childrenAccept() can be useful when
 implementing preorder or postorder tree walks.

 */

public class Parser_1DumpVisitor implements Parser_1Visitor {
	private int indent = 0;

	private String indentString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < indent; ++i) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public Object visit(SimpleNode node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node
				+ ": acceptor not unimplemented in subclass?");

		LoggerGenerator.debug("Data que deu pau: " + data);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	public Object visit(ASTStart node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	public Object visit(ASTIfExpression node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTArgument, java.lang.Object)
	 */
	public Object visit(ASTArgument node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTArgumentList,
	 * java.lang.Object)
	 */
	public Object visit(ASTArgumentList node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	public Object visit(ASTVariable node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTConclusion, java.lang.Object)
	 */
	public Object visit(ASTConclusion node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTConclusionList,
	 * java.lang.Object)
	 */
	public Object visit(ASTConclusionList node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTConstant, java.lang.Object)
	 */
	public Object visit(ASTConstant node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTDecisionStatement,
	 * java.lang.Object)
	 */
	public Object visit(ASTDecisionStatement node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTFact, java.lang.Object)
	 */
	public Object visit(ASTFact node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTFactDeclaration,
	 * java.lang.Object)
	 */
	public Object visit(ASTFactDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfFactor, java.lang.Object)
	 */
	public Object visit(ASTIfFactor node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfMoreSimpleExpression,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfMoreSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfMoreTerms,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfMoreTerms node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfScope, java.lang.Object)
	 */
	public Object visit(ASTBody node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfSimpleExpression,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfTerm, java.lang.Object)
	 */
	public Object visit(ASTIfTerm node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTInterval, java.lang.Object)
	 */
	public Object visit(ASTInterval node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTListOfFacts,
	 * java.lang.Object)
	 */
	public Object visit(ASTListOfFacts node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTListOfNumbers,
	 * java.lang.Object)
	 */
	public Object visit(ASTListOfNumbers node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTListOfRules,
	 * java.lang.Object)
	 */
	public Object visit(ASTListOfRules node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTProgram, java.lang.Object)
	 */
	public Object visit(ASTProgram node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, Program.Instance(), engine);
		LoggerGenerator.debug(Program.Instance().getVariableDeclaration());
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTRule, java.lang.Object)
	 */
	public Object visit(ASTRule node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTRuleDeclaration,
	 * java.lang.Object)
	 */
	public Object visit(ASTRuleDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenAttribution,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenAttribution node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenExpression,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenExpression node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenFactor, java.lang.Object)
	 */
	public Object visit(ASTThenFactor node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenMoreSimpleExpression,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenMoreSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenMoreTerms,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenMoreTerms node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenScope, java.lang.Object)
	 */
	public Object visit(ASTHead node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenSimpleExpression,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenSimpleExpression node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenTerm, java.lang.Object)
	 */
	public Object visit(ASTThenTerm node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTType, java.lang.Object)
	 */
	public Object visit(ASTType node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTVariableDeclaration,
	 * java.lang.Object)
	 */
	public Object visit(ASTVariableDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTVariableList,
	 * java.lang.Object)
	 */
	public Object visit(ASTVariableList node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTID, java.lang.Object)
	 */
	public Object visit(ASTID node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfAdditiveOperator,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfAdditiveOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfRelationalExpression,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfRelationalOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTMultiplicativeOperator,
	 * java.lang.Object)
	 */
	public Object visit(ASTMultiplicativeOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenAdditiveOperator,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenAdditiveOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenInclusiveOperator,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenInclusiveOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenMultiplicativeOperator,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenMultiplicativeOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTThenRelationalOperator,
	 * java.lang.Object)
	 */
	public Object visit(ASTThenRelationalOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfLocalAttribution,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfLocalAttribution node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfLocalAttributionOperator,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfLocalAttributionOperator node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTIfLocalDeclaration,
	 * java.lang.Object)
	 */
	public Object visit(ASTIfLocalDeclaration node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTRoot, java.lang.Object)
	 */
	public Object visit(ASTRoot node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see JJTREE.Parser_1Visitor#visit(JJTREE.ASTObjectInstanciation,
	 * java.lang.Object)
	 */
	public Object visit(ASTObjectInstanciation node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.JJTREE.Parser_1Visitor#visit(br.ufal.tci.JJTREE.ASTInteger,
	 * java.lang.Object, br.ufal.tci.InferenceEngine.InferenceEngineIF)
	 */
	public Object visit(ASTInteger node, Object data, InferenceEngine engine)
			throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seebr.ufal.tci.JJTREE.Parser_1Visitor#visit(br.ufal.tci.JJTREE.
	 * ASTCharacterLiteral, java.lang.Object,
	 * br.ufal.tci.InferenceEngine.InferenceEngineIF)
	 */
	public Object visit(ASTCharacterLiteral node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.JJTREE.Parser_1Visitor#visit(br.ufal.tci.JJTREE.ASTFloatPoint
	 * , java.lang.Object, br.ufal.tci.InferenceEngine.InferenceEngineIF)
	 */
	public Object visit(ASTFloatPoint node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.JJTREE.Parser_1Visitor#visit(br.ufal.tci.JJTREE.ASTStringLiteral
	 * , java.lang.Object, br.ufal.tci.InferenceEngine.InferenceEngineIF)
	 */
	public Object visit(ASTStringLiteral node, Object data,
			InferenceEngine engine) throws SemanticException {
		LoggerGenerator.debug(indentString() + node);
		indent += 2;
		data = node.childrenAccept(this, data, engine);
		indent -= 2;
		return data;
	}
}

/* end */

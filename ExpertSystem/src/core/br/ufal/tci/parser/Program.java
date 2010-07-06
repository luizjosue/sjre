/*
 * Created on Sep 8, 2004
 *
 *
 */
package br.ufal.tci.parser;

/**
 * @author desenvolvimento
 *
 *
 */
public class Program {
	private VariableDeclaration variableDeclaration;
	private FactDeclaration factDeclaration;
	private RuleDeclaration ruleDeclaration;
	
	private static Program program = null;
	
	public static Program Instance(){
		if(program==null){
			program = new Program();
		}
		return program;
	}
	
	protected Program(){
		this.variableDeclaration 	= new VariableDeclaration();
		this.factDeclaration 		= new FactDeclaration();
		this.ruleDeclaration		= new RuleDeclaration();
	}
	
	
	
	/**
	 * @return Returns the factDeclaration.
	 */
	public FactDeclaration getFactDeclaration() {
		return factDeclaration;
	}
	/**
	 * @param factDeclaration The factDeclaration to set.
	 */
	public void setFactDeclaration(FactDeclaration factDeclaration) {
		this.factDeclaration = factDeclaration;
	}
	/**
	 * @return Returns the ruleDeclaration.
	 */
	public RuleDeclaration getRuleDeclaration() {
		return ruleDeclaration;
	}
	/**
	 * @param ruleDeclaration The ruleDeclaration to set.
	 */
	public void setRuleDeclaration(RuleDeclaration ruleDeclaration) {
		this.ruleDeclaration = ruleDeclaration;
	}
	/**
	 * @return Returns the variableDeclaration.
	 */
	public VariableDeclaration getVariableDeclaration() {
		return variableDeclaration;
	}
	/**
	 * @param variableDeclaration The variableDeclaration to set.
	 */
	public void setVariableDeclaration(VariableDeclaration variableDeclaration) {
		this.variableDeclaration = variableDeclaration;
	}
}

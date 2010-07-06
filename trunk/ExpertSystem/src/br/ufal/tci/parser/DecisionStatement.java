/*
 * Created on 01/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.parser;

/**
 * @author ljsf
 * 
 *         
 *         
 */
public class DecisionStatement {
	/**
	 * Collection de Conclusion
	 * */
	private Head head;

	/**
	 * Expressao de if <expr> then <conclusion>
	 * */
	private Body body;

	public DecisionStatement() {
		this.head = new Head();
		this.body = new Body();
	}

	/**
	 * @return Returns the body.
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * @param body
	 *            The body to set.
	 */
	public void setBody(Body body) {
		this.body = body;
	}

	/**
	 * @return Returns the head.
	 */
	public Head getHead() {
		return head;
	}

	/**
	 * @param head
	 *            The head to set.
	 */
	public void setHead(Head head) {
		this.head = head;
	}
}

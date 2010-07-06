/*
 * Created on 20/10/2004
 *
 * 
 * 
 */
package br.ufal.tci.trace;

/**
 * @author
 * 
 */
public class TracerImpl implements Tracer {

	private static TracerImpl trace = null;
	// private static int ruleCounter = 0;
	private String message;

	protected TracerImpl() {
		this.message = new String();
	}

	public static TracerImpl getInstance() {
		if (trace == null) {
			trace = new TracerImpl();
		}
		return trace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.trace.TraceIF#addMessage(java.lang.String)
	 */
	public void addMessage(String message) {
		this.message.concat(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.trace.TraceIF#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.trace.TraceIF#addMessage(br.ufal.tci.parser.Variable,
	 * br.ufal.tci.operator.Operator, br.ufal.tci.value.Value)
	 */

}

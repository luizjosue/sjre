/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.parser;

import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.IntegerType;
import br.ufal.tci.type.RealType;
import br.ufal.tci.type.StringType;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 */
public class Constant extends Identifier {

	private Type type;

	private Value<?> value;

	/**
	 * Construtor default de Constant
	 * */
	public Constant() {
		this.type = null;
		this.value = null;
	}

	/**
	 * @param f
	 */
	public Constant(float f) {
		this.value = new Value<Float>(f);
		this.type = new RealType();
	}

	/**
	 * @param f
	 */
	public Constant(int f) {
		this.value = new Value<Integer>(f);
		this.type = new IntegerType();
	}

	/**
	 * @param f
	 */
	public Constant(String f) {
		this.value = new Value<String>(f);
		this.type = new StringType();
	}

	/**
	 * @param f
	 */
	public Constant(boolean f) {
		this.value = new Value<Boolean>(f);
		this.type = new BooleanType();
	}

	/**
	 * @return
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @return
	 */
	public Value<?> getValue() {
		return value;
	}

	/**
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @param value
	 */
	public void setValue(Value<?> value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return value.toString();
	}

}

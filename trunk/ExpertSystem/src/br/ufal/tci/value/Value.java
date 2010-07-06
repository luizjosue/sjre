/*
 * Created on 08/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.value;

import br.ufal.tci.parser.Interval;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.IntegerType;
import br.ufal.tci.type.ObjectType;
import br.ufal.tci.type.RealType;
import br.ufal.tci.type.StringType;
import br.ufal.tci.type.Type;

/**
 * @author ljsf
 * 
 *         Classe base que representa um Valor e suas propriedades
 * 
 */
public class Value<T> {

	protected T value;

	public Value(T t) {
		value = t;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T v) {
		this.value = v;
	}

	/**
	 * Método que retorna o tipo equivalente ao value passado como parâmetro,
	 * caso o value passado seja inválido o valor de retorno será nulo
	 * */
	// public static Type generateType(Value value) {
	// if (value instanceof IntegerValue) {
	// return new IntegerType();
	// } else if (value instanceof RealValue) {
	// return new RealType();
	// } else if (value instanceof StringValue) {
	// return new StringType();
	// } else if (value instanceof BooleanValue) {
	// return new BooleanType();
	// } else if (value instanceof ObjectValue) {
	// return new ObjectType();
	// }
	// return null;
	// }
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = "";
		if (this.value != null) {
			result = this.value.toString();
		}
		return result;
	}

	public boolean isInteger() {
		return value != null && value instanceof Integer;
	}

	public boolean isReal() {
		return value != null && value instanceof Float;
	}

	public boolean isInterval() {
		return value != null && value instanceof Interval;
	}

	public boolean isBoolean() {
		return value != null && value instanceof Boolean;
	}

	public boolean isString() {
		return value != null && value instanceof String;
	}

	public boolean isObject() {
		return value != null && value instanceof Object;
	}

	public static Type generateType(Value<?> v) {
		Type result = null;
		if (v.isBoolean()) {
			result = new BooleanType();
		} else if (v.isString()) {
			result = new StringType();
		} else if (v.isInteger()) {
			result = new IntegerType();
		} else if (v.isReal()) {
			result = new RealType();
		} else if (v.isObject()) {
			result = new ObjectType();
		}
		return result;
	}
}

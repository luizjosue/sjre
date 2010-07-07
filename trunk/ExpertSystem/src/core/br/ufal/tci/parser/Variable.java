/*
 * Created on Sep 8, 2004
 *
 * 
 */
package br.ufal.tci.parser;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.IntegerType;
import br.ufal.tci.type.ObjectType;
import br.ufal.tci.type.RealType;
import br.ufal.tci.type.StringType;
import br.ufal.tci.type.Type;
import br.ufal.tci.util.Pair;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

/**
 * @author desenvolvimento
 */
public class Variable implements Cloneable {

	/**
	 * Representa o identificador da variável
	 * */
	private Identifier identifier;

	/**
	 * Representa o tipo da variável
	 * */
	private Type type;

	/**
	 * Lista que contém pares do tipo (Value, interval)
	 * */
	private Stack<Map.Entry<Value<?>, Interval>> list;

	/**
	 * Pode ser um unico valor ou conjunto de valores
	 * */
	private Value<?> value;

	/**
	 * Indica se à variável já foi ou não atribuído algum valor
	 * */
	private boolean assigned;

	/**
	 * Construtor default de Variable
	 * */
	public Variable() {
		this.identifier = null;
		this.type = null;
		this.list = new Stack<Map.Entry<Value<?>, Interval>>();
		this.value = null;
		this.assigned = false;
	}

	/**
	 * Construtor que recebe como único parâmetro o identificador da variável
	 * */
	public Variable(Identifier identifier) {
		this();
		this.identifier = identifier;
	}

	/**
	 * Construtor que recebe como parâmetro apenas a string do identificador da
	 * variável
	 * */
	public Variable(String identifierName) {
		this(new Identifier(identifierName));
	}

	/**
	 * @return Returns the identifier.
	 */
	public Identifier getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier
	 *            The identifier to set.
	 */
	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return Returns the type.
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            The type to set.
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public Map.Entry<Value<?>, Interval> getValue() {
		return this.list.peek();
	}

	/**
	 * @param value
	 */
	public void setValue(Value<?> value) throws SemanticException {
		if (check(value, this.type)) {
			/* Não seta como intervalo (null) */
			// this.list.setFirst(value, null);
			this.addPair(value, null);
		} else if (value == null) {
			this.addPair(value, null);
		} else {
			throw new SemanticException(MessageUtil.INCOMPATIBLE_TYPES);
		}
	}

	/**
	 * Método que checa se o value e o type passados como parâmetros equeivalem
	 * ao mesmo tipo
	 * */
	public static boolean check(Value<?> value1, Type type) {
		Value<?> value = null;
		if (value1 instanceof Pair) {
			Pair<?> pair = (Pair<?>) value1;
			if (pair.getObject1() != null) {
				value = (Value<?>) pair.getObject1();
			} else if (pair.getObject2() != null) {
				Interval interval = (Interval) pair.getObject2();
				if (Type.match(interval.getType(), type)) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			value = value1;
		}

		Value<Interval> ivvalue = ValueUtils.getIntervalValue(value);
		if (value != null) {
			if (value.isInteger()
					&& ((type instanceof IntegerType) || (type instanceof RealType))) {
				return true;
			}
			if (value.isReal()
					&& ((type instanceof IntegerType) || (type instanceof RealType))) {
				return true;
			}
			if (value.isBoolean() && (type instanceof BooleanType)) {
				return true;
			}
			if (value.isString() && (type instanceof StringType)) {
				return true;
			}
			if (value.isObject() && (type instanceof ObjectType)) {
				return true;
			}
		}
		if (ivvalue != null) {
			return Type.match(ivvalue.getValue().getType(), type);
		}

		/*
		 * TODO pode ocorrer atribuicao e outras operacoes entre interavlos?
		 */

		return false;
	}

	/**
	 * Método que adiciona um Value e um Interval a lista de intervalos
	 * */
	public void addPair(Value<?> value, Interval interval) {
		Map.Entry<Value<?>, Interval> entrada = new AbstractMap.SimpleEntry<Value<?>, Interval>(
				value, interval);
		this.list.push(entrada);
	}

	/**
	 * Cria um clone do objeto
	 * */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Variable variable;
		variable = new Variable();
		variable.identifier = this.identifier;
		variable.type = this.type;
		variable.value = this.value;
		variable.list = this.list;
		variable.assigned = this.assigned;
		return variable;
	}

	/**
	 * @return Returns the signed.
	 */
	public boolean isAssigned() {
		return assigned;
	}

	/**
	 * @param signed
	 *            The signed to set.
	 */
	public void setAssigned(boolean signed) {
		this.assigned = signed;
	}

	/**
	 * Evaluates the current variable.
	 * 
	 * @return The value of the current variable.
	 */
	public Value<?> evaluate() {
		// TODO why intervals??
		return this.getValue().getKey();
	}
}

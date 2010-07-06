/*
 * Created on 29/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.parser;

import br.ufal.tci.exception.InvalidDataException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.type.Type;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 *         Classe que representa um intevalo e suas propriedades
 * 
 */
public class Interval {

	/**
	 * Indica o tipo do intervalo já que um intervalo pode conter apenas valores
	 * de um mesmo tipo
	 * */
	private Type type;

	/**
	 * Indica o limite superior do intervalo
	 * */
	private Float highLimit;

	/**
	 * Indica o limite inferior do intervalo
	 * */
	private Float lowLimit;

	/**
	 * Indica se o limite superior do intervalo é aberto ou nao onde true
	 * significa que é aberto e false que é fechado
	 * */
	private boolean isOpenHigh;

	/**
	 * Indica se o limite inferior do intervalo é aberto ou nao onde true
	 * significa que é aberto e false que é fechado
	 * */
	private boolean isOpenLow;

	/**
	 * Construtor que recebe como parametros dois float que indicam os limites
	 * inferiores e superiores e dois parametros boolean que indicam se estes
	 * limites são fechados ou abertos
	 * */
	public Interval(float inferior, boolean isOpenLow, float superior,
			boolean isOpenHigh, Type type) throws InvalidDataException {
		this.highLimit = new Float(superior);
		this.isOpenHigh = isOpenHigh;
		this.lowLimit = new Float(inferior);
		this.isOpenLow = isOpenLow;
		this.type = type;
	}

	/**
	 * Construtor que recebe como parametros um float e um value que indicam os
	 * limites inferiores e superiores e dois parametros boolean que indicam se
	 * estes limites são fechados ou abertos
	 * */
	public Interval(float inferior, boolean isOpenLow, Value<?> superior,
			boolean isOpenHigh, Type type) throws InvalidDataException {
		this.highLimit = getFloat(superior);
		this.lowLimit = new Float(inferior);
		this.isOpenHigh = isOpenHigh;
		this.isOpenLow = isOpenLow;
		this.type = type;
	}

	/**
	 * Construtor que recebe como parametros um float e um value que indicam os
	 * limites inferiores e superiores e dois parametros boolean que indicam se
	 * estes limites são fechados ou abertos
	 * */
	public Interval(Value<?> inferior, boolean isOpenLow, float superior,
			boolean isOpenHigh, Type type) throws InvalidDataException {
		this.lowLimit = getFloat(inferior);
		this.highLimit = new Float(superior);
		this.isOpenHigh = isOpenHigh;
		this.isOpenLow = isOpenLow;
		this.type = type;
	}

	/**
	 * Construtor que recebe como parametros dois values que indicam os limites
	 * inferiores e superiores e dois parametros boolean que indicam se estes
	 * limites são fechados ou abertos
	 * */
	public Interval(Value<?> inferior, boolean isOpenLow, Value<?> superior,
			boolean isOpenHigh, Type type) throws InvalidDataException {
		this.highLimit = getFloat(superior);
		this.lowLimit = getFloat(inferior);
		this.isOpenHigh = isOpenHigh;
		this.isOpenLow = isOpenLow;
		this.type = type;
	}

	private Float getFloat(Value<?> v) throws InvalidDataException {
		Float result = null;
		if (v == null) {
			result = null;
		} else if (v.getValue() instanceof Integer) {
			result = ((Integer) v.getValue()).floatValue();
		} else if (v.getValue() instanceof Float) {
			result = ((Float) v.getValue());
		} else {
			throw new InvalidDataException(MessageUtil.INVALID_DATA_OPERATION);
		}
		return result;
	}

	/**
	 * @return Returns the highLimit.
	 */
	public Float getHighLimit() {
		return highLimit;
	}

	/**
	 * @param highLimit
	 *            The highLimit to set.
	 */
	public void setHighLimit(float highLimit) {
		this.highLimit = new Float(highLimit);
	}

	/**
	 * @return Returns the lowLimit.
	 */
	public Float getLowLimit() {
		return lowLimit;
	}

	/**
	 * @param lowLimit
	 *            The lowLimit to set.
	 */
	public void setLowLimit(float lowLimit) {
		this.lowLimit = new Float(lowLimit);
	}

	/**
	 * Seta se o intervalo é aberto por cima
	 * */
	public void setIsOpenHigh(boolean val) {
		this.isOpenHigh = val;
	}

	/**
	 * Seta se o intervalo é fechado por baixo
	 * */
	public void setIsOpenLow(boolean val) {
		this.isOpenLow = val;
	}

	/**
	 * @return
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return Returns the isOpenHigh.
	 */
	public boolean isOpenHigh() {
		return isOpenHigh;
	}

	/**
	 * @return Returns the isOpenLow.
	 */
	public boolean isOpenLow() {
		return isOpenLow;
	}

	@Override
	public String toString() {
		String result = "";
		String left = "[";
		String right = "]";
		if (isOpenLow()) {
			left = "]";
		}
		if (isOpenHigh()) {
			right = "[";
		}
		result = left + getLowLimit() + ", " + getHighLimit() + right;
		return result;
	}
}

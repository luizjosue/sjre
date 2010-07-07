package br.ufal.tci.value;

import br.ufal.tci.parser.Interval;

public class ValueUtils {

	public static Value<Boolean> getBooleanValue(Value<?> value) {
		Value<Boolean> result = null;
		if (value.getValue() instanceof Boolean) {
			result = new Value<Boolean>((Boolean) value.getValue());
		}
		return result;
	}

	public static Value<Integer> getIntegerValue(Value<?> value) {
		Value<Integer> result = null;
		if (value.getValue() instanceof Integer) {
			result = new Value<Integer>((Integer) value.getValue());
		}
		return result;
	}

	public static Value<Interval> getIntervalValue(Value<?> value) {
		Value<Interval> result = null;
		if (value != null && value.getValue() instanceof Interval) {
			result = new Value<Interval>((Interval) value.getValue());
		}
		return result;
	}

	public static Value<Object> getObjectValue(Value<?> value) {
		Value<Object> result = null;
		if (value.getValue() instanceof Object) {
			result = new Value<Object>((Object) value.getValue());
		}
		return result;
	}

	public static Value<Float> getRealValue(Value<?> value) {
		Value<Float> result = null;
		if (value.getValue() instanceof Float) {
			result = new Value<Float>((Float) value.getValue());
		}
		return result;
	}

	public static Value<String> getStringValue(Value<?> value) {
		Value<String> result = null;
		if (value.getValue() instanceof String) {
			result = new Value<String>((String) value.getValue());
		}
		return result;
	}
}

/*
 * Created on 08/09/2004
 */
package br.ufal.tci.operator.relational;

import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.parser.Interval;
import br.ufal.tci.util.Pair;
import br.ufal.tci.value.Value;
import br.ufal.tci.value.ValueUtils;

/**
 * @author ljsf
 * 
 */
public class GreaterThanRelationalOperator extends RelationalOperator {

	public GreaterThanRelationalOperator() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Operators.GREATER_THAN;
	}

	private Value<?> simpleEvaluate(Value<?> left, Value<?> right)
			throws SemanticException {
		Value<?> result = super.execute(left, right);
		if (result == null) {

			Value<Integer> iValue1 = ValueUtils.getIntegerValue(left);
			Value<Integer> iValue2 = ValueUtils.getIntegerValue(right);
			Value<Float> rValue1 = ValueUtils.getRealValue(left);
			Value<Float> rValue2 = ValueUtils.getRealValue(right);

			Value<Interval> interval1 = ValueUtils.getIntervalValue(left);
			Value<Interval> interval2 = ValueUtils.getIntervalValue(right);
			if (interval1 != null) {
				return verificarIntervalo(iValue2, rValue2, interval1,
						interval2);
			} else if (interval2 != null) {
				return verificarIntervalo(iValue1, rValue1, interval2,
						interval1);
			}
		}
		return result;
	}

	@Override
	protected Value<?> execute(Value<?> left, Value<?> right)
			throws SemanticException {
		Value<?> value = null;
		if (!(left instanceof Pair) && !(right instanceof Pair)) {
			value = simpleEvaluate(left, right);
		} else if (left instanceof Pair && !(right instanceof Pair)) {
			// TODO
		} else if (!(left instanceof Pair) && right instanceof Pair) {
			// TODO
		} else if (left instanceof Pair && right instanceof Pair) {
			Pair<?> leftPair = (Pair<?>) left;
			Pair<?> rightPair = (Pair<?>) right;
			/* Valor > Valor */
			if (leftPair.getObject1() != null && rightPair.getObject1() != null) {
				Value<?> leftValue = (Value<?>) leftPair.getObject1();
				Value<?> rightValue = (Value<?>) rightPair.getObject1();
				value = simpleEvaluate(leftValue, rightValue);
			} else if (leftPair.getObject1() != null
					&& rightPair.getObject2() != null) { // Valor > Intervalo
				Value<?> leftValue = (Value<?>) leftPair.getObject1();
				Interval rightInterval = (Interval) rightPair.getObject2();
				Float low = rightInterval.getLowLimit();
				Float high = rightInterval.getHighLimit();
				boolean isOpenHigh = rightInterval.isOpenHigh();
				boolean isOpenLow = rightInterval.isOpenLow();

				if (low != null && isOpenLow && high != null && isOpenHigh) {
					/* Diferenca */
					value = new Value<Boolean>(false);
				} else if (low != null && (!isOpenLow) && high != null
						&& (!isOpenHigh)) {
					/* Igualdade */
					value = simpleEvaluate(leftValue, new Value<Float>(low
							.floatValue()));
				} else if (low != null && isOpenLow && high == null
						&& isOpenHigh) {
					/* Maior */
					value = new Value<Boolean>(false);
				} else if (low != null && (!isOpenLow) && high == null
						&& isOpenHigh) {
					/* Maior igual */
					value = new Value<Boolean>(false);
				} else if (low == null && isOpenLow && high != null
						&& isOpenHigh) {
					/* Menor */
					value = simpleEvaluate(leftValue, new Value<Float>(high
							.floatValue()));
				} else if (low == null && isOpenLow && high != null
						&& (!isOpenHigh)) {
					/* Menor igual */
					value = simpleEvaluate(leftValue, new Value<Float>(high
							.floatValue()));
				}
			} else if (leftPair.getObject2() != null) {
				throw new SemanticException(MessageUtil.OPERATION_NOT_PERMITED1);
			}
		}
		return value;
	}

	private Value<?> verificarIntervalo(Value<Integer> otherHandI,
			Value<Float> otherHandR, Value<Interval> current,
			Value<Interval> other) throws SemanticException {
		Value<Boolean> result = null;
		if (other != null) {
			if (other.getValue().isOpenHigh()) {
				throw new SemanticException(MessageUtil.OPERATION_NOT_PERMITED3);
			}

			result = new Value<Boolean>(current.getValue().getLowLimit()
					.floatValue() > other.getValue().getHighLimit()
					.floatValue());
		} else if (otherHandI != null) {
			result = new Value<Boolean>(current.getValue().getLowLimit()
					.floatValue() > otherHandI.getValue());
		} else if (otherHandR != null) {
			result = new Value<Boolean>(current.getValue().getLowLimit()
					.floatValue() > otherHandR.getValue());
		}
		return result;
	}

	@Override
	protected Boolean performOperation(Boolean a, Boolean b) {
		return false;
	}

	@Override
	protected Boolean performOperation(Float a, Float b) {
		return a != null && b != null && a > b;
	}

	@Override
	protected Boolean performOperation(String a, String b) {
		return a != null && b != null && a.compareTo(b) > 1;
	}

	@Override
	protected boolean customizedCheck(Value<?> left, Value<?> right)
			throws SemanticException {
		Value<Interval> interval1 = ValueUtils.getIntervalValue(left);
		Value<Interval> interval2 = ValueUtils.getIntervalValue(right);
		if (interval1 != null) {
			if (interval1.getValue().isOpenLow()) {
				throw new SemanticException(MessageUtil.OPERATION_NOT_PERMITED3);
			}
		} else if (interval2 != null) {
			if (interval2.getValue().isOpenHigh()) {
				throw new SemanticException(MessageUtil.OPERATION_NOT_PERMITED3);
			}
		}
		return true;
	}
}
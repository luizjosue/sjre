/* Generated By:JJTree&JavaCC: Do not edit this line. Parser_1TokenManager.java */
package br.ufal.tci.JJTREE;

/** Token Manager. */
public class Parser_1TokenManager implements Parser_1Constants {

	/** Debug output. */
	public static java.io.PrintStream debugStream = System.out;

	/** Set debug output. */
	public void setDebugStream(java.io.PrintStream ds) {
		debugStream = ds;
	}

	private final int jjStopStringLiteralDfa_0(int pos, long active0) {
		switch (pos) {
		case 0:
			if ((active0 & 0x7fff80L) != 0L) {
				jjmatchedKind = 27;
				return 39;
			}
			if ((active0 & 0x4000000000000L) != 0L)
				return 22;
			if ((active0 & 0x1fbfffe00000006L) != 0L)
				return 3;
			return -1;
		case 1:
			if ((active0 & 0x6bff80L) != 0L) {
				if (jjmatchedPos != 1) {
					jjmatchedKind = 27;
					jjmatchedPos = 1;
				}
				return 20;
			}
			if ((active0 & 0x140000L) != 0L)
				return 20;
			return -1;
		case 2:
			if ((active0 & 0xb7b80L) != 0L) {
				if (jjmatchedPos != 2) {
					jjmatchedKind = 27;
					jjmatchedPos = 2;
				}
				return 20;
			}
			if ((active0 & 0x608400L) != 0L)
				return 20;
			return -1;
		case 3:
			if ((active0 & 0x33080L) != 0L) {
				jjmatchedKind = 27;
				jjmatchedPos = 3;
				return 20;
			}
			if ((active0 & 0x84b00L) != 0L)
				return 20;
			return -1;
		case 4:
			if ((active0 & 0x32080L) != 0L) {
				jjmatchedKind = 27;
				jjmatchedPos = 4;
				return 20;
			}
			if ((active0 & 0x1000L) != 0L)
				return 20;
			return -1;
		case 5:
			if ((active0 & 0x10080L) != 0L) {
				jjmatchedKind = 27;
				jjmatchedPos = 5;
				return 20;
			}
			if ((active0 & 0x22000L) != 0L)
				return 20;
			return -1;
		case 6:
			if ((active0 & 0x80L) != 0L) {
				jjmatchedKind = 27;
				jjmatchedPos = 6;
				return 20;
			}
			if ((active0 & 0x10000L) != 0L)
				return 20;
			return -1;
		default:
			return -1;
		}
	}

	private final int jjStartNfa_0(int pos, long active0) {
		return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
	}

	private int jjStopAtPos(int pos, int kind) {
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		return pos + 1;
	}

	private int jjMoveStringLiteralDfa0_0() {
		switch (curChar) {
		case 9:
			return jjStartNfaWithStates_0(0, 2, 3);
		case 32:
			return jjStartNfaWithStates_0(0, 1, 3);
		case 33:
			return jjMoveStringLiteralDfa1_0(0x20000000000L);
		case 40:
			return jjStartNfaWithStates_0(0, 35, 3);
		case 41:
			return jjStartNfaWithStates_0(0, 36, 3);
		case 42:
			return jjStartNfaWithStates_0(0, 49, 3);
		case 43:
			jjmatchedKind = 47;
			return jjMoveStringLiteralDfa1_0(0x1f0000000000000L);
		case 44:
			return jjStartNfaWithStates_0(0, 45, 3);
		case 45:
			return jjStartNfaWithStates_0(0, 48, 3);
		case 46:
			jjmatchedKind = 34;
			return jjMoveStringLiteralDfa1_0(0x100000000000L);
		case 47:
			return jjStartNfaWithStates_0(0, 50, 22);
		case 58:
			jjmatchedKind = 46;
			return jjMoveStringLiteralDfa1_0(0x8000000000000L);
		case 60:
			jjmatchedKind = 37;
			return jjMoveStringLiteralDfa1_0(0x8000000000L);
		case 61:
			return jjStartNfaWithStates_0(0, 33, 3);
		case 62:
			jjmatchedKind = 38;
			return jjMoveStringLiteralDfa1_0(0x10000000000L);
		case 91:
			return jjStartNfaWithStates_0(0, 42, 3);
		case 93:
			return jjStartNfaWithStates_0(0, 43, 3);
		case 65:
		case 97:
			return jjMoveStringLiteralDfa1_0(0x200000L);
		case 66:
		case 98:
			return jjMoveStringLiteralDfa1_0(0x10000L);
		case 70:
		case 102:
			return jjMoveStringLiteralDfa1_0(0x1100L);
		case 73:
		case 105:
			return jjMoveStringLiteralDfa1_0(0x48000L);
		case 78:
		case 110:
			return jjMoveStringLiteralDfa1_0(0x400400L);
		case 79:
		case 111:
			return jjMoveStringLiteralDfa1_0(0x120000L);
		case 82:
		case 114:
			return jjMoveStringLiteralDfa1_0(0x4200L);
		case 83:
		case 115:
			return jjMoveStringLiteralDfa1_0(0x2000L);
		case 84:
		case 116:
			return jjMoveStringLiteralDfa1_0(0x80800L);
		case 86:
		case 118:
			return jjMoveStringLiteralDfa1_0(0x80L);
		default:
			return jjMoveNfa_0(0, 0);
		}
	}

	private int jjMoveStringLiteralDfa1_0(long active0) {
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(0, active0);
			return 1;
		}
		switch (curChar) {
		case 46:
			if ((active0 & 0x100000000000L) != 0L)
				return jjStopAtPos(1, 44);
			break;
		case 61:
			if ((active0 & 0x8000000000L) != 0L)
				return jjStopAtPos(1, 39);
			else if ((active0 & 0x10000000000L) != 0L)
				return jjStopAtPos(1, 40);
			else if ((active0 & 0x20000000000L) != 0L)
				return jjStopAtPos(1, 41);
			else if ((active0 & 0x8000000000000L) != 0L)
				return jjStopAtPos(1, 51);
			else if ((active0 & 0x10000000000000L) != 0L) {
				jjmatchedKind = 52;
				jjmatchedPos = 1;
			}
			return jjMoveStringLiteralDfa2_0(active0, 0x1e0000000000000L);
		case 65:
		case 97:
			return jjMoveStringLiteralDfa2_0(active0, 0x1180L);
		case 66:
		case 98:
			return jjMoveStringLiteralDfa2_0(active0, 0x20000L);
		case 69:
		case 101:
			return jjMoveStringLiteralDfa2_0(active0, 0x404000L);
		case 70:
		case 102:
			if ((active0 & 0x40000L) != 0L)
				return jjStartNfaWithStates_0(1, 18, 20);
			break;
		case 72:
		case 104:
			return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
		case 78:
		case 110:
			return jjMoveStringLiteralDfa2_0(active0, 0x208000L);
		case 79:
		case 111:
			return jjMoveStringLiteralDfa2_0(active0, 0x10400L);
		case 82:
		case 114:
			if ((active0 & 0x100000L) != 0L)
				return jjStartNfaWithStates_0(1, 20, 20);
			return jjMoveStringLiteralDfa2_0(active0, 0x800L);
		case 84:
		case 116:
			return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
		case 85:
		case 117:
			return jjMoveStringLiteralDfa2_0(active0, 0x200L);
		default:
			break;
		}
		return jjStartNfa_0(0, active0);
	}

	private int jjMoveStringLiteralDfa2_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(0, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(1, active0);
			return 2;
		}
		switch (curChar) {
		case 33:
			return jjMoveStringLiteralDfa3_0(active0, 0x40000000000000L);
		case 60:
			if ((active0 & 0x20000000000000L) != 0L) {
				jjmatchedKind = 53;
				jjmatchedPos = 2;
			}
			return jjMoveStringLiteralDfa3_0(active0, 0x80000000000000L);
		case 62:
			return jjMoveStringLiteralDfa3_0(active0, 0x100000000000000L);
		case 65:
		case 97:
			return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
		case 67:
		case 99:
			return jjMoveStringLiteralDfa3_0(active0, 0x100L);
		case 68:
		case 100:
			if ((active0 & 0x200000L) != 0L)
				return jjStartNfaWithStates_0(2, 21, 20);
			break;
		case 69:
		case 101:
			return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
		case 74:
		case 106:
			return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
		case 76:
		case 108:
			return jjMoveStringLiteralDfa3_0(active0, 0x1200L);
		case 79:
		case 111:
			return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
		case 82:
		case 114:
			return jjMoveStringLiteralDfa3_0(active0, 0x2080L);
		case 84:
		case 116:
			if ((active0 & 0x400L) != 0L)
				return jjStartNfaWithStates_0(2, 10, 20);
			else if ((active0 & 0x8000L) != 0L)
				return jjStartNfaWithStates_0(2, 15, 20);
			break;
		case 85:
		case 117:
			return jjMoveStringLiteralDfa3_0(active0, 0x800L);
		case 87:
		case 119:
			if ((active0 & 0x400000L) != 0L)
				return jjStartNfaWithStates_0(2, 22, 20);
			break;
		default:
			break;
		}
		return jjStartNfa_0(1, active0);
	}

	private int jjMoveStringLiteralDfa3_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(1, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(2, active0);
			return 3;
		}
		switch (curChar) {
		case 61:
			if ((active0 & 0x40000000000000L) != 0L)
				return jjStopAtPos(3, 54);
			else if ((active0 & 0x80000000000000L) != 0L)
				return jjStopAtPos(3, 55);
			else if ((active0 & 0x100000000000000L) != 0L)
				return jjStopAtPos(3, 56);
			break;
		case 69:
		case 101:
			if ((active0 & 0x200L) != 0L)
				return jjStartNfaWithStates_0(3, 9, 20);
			else if ((active0 & 0x800L) != 0L)
				return jjStartNfaWithStates_0(3, 11, 20);
			return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
		case 73:
		case 105:
			return jjMoveStringLiteralDfa4_0(active0, 0x2080L);
		case 76:
		case 108:
			if ((active0 & 0x4000L) != 0L)
				return jjStartNfaWithStates_0(3, 14, 20);
			return jjMoveStringLiteralDfa4_0(active0, 0x10000L);
		case 78:
		case 110:
			if ((active0 & 0x80000L) != 0L)
				return jjStartNfaWithStates_0(3, 19, 20);
			break;
		case 83:
		case 115:
			return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
		case 84:
		case 116:
			if ((active0 & 0x100L) != 0L)
				return jjStartNfaWithStates_0(3, 8, 20);
			break;
		default:
			break;
		}
		return jjStartNfa_0(2, active0);
	}

	private int jjMoveStringLiteralDfa4_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(2, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(3, active0);
			return 4;
		}
		switch (curChar) {
		case 65:
		case 97:
			return jjMoveStringLiteralDfa5_0(active0, 0x80L);
		case 67:
		case 99:
			return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
		case 69:
		case 101:
			if ((active0 & 0x1000L) != 0L)
				return jjStartNfaWithStates_0(4, 12, 20);
			return jjMoveStringLiteralDfa5_0(active0, 0x10000L);
		case 78:
		case 110:
			return jjMoveStringLiteralDfa5_0(active0, 0x2000L);
		default:
			break;
		}
		return jjStartNfa_0(3, active0);
	}

	private int jjMoveStringLiteralDfa5_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(3, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(4, active0);
			return 5;
		}
		switch (curChar) {
		case 65:
		case 97:
			return jjMoveStringLiteralDfa6_0(active0, 0x10000L);
		case 66:
		case 98:
			return jjMoveStringLiteralDfa6_0(active0, 0x80L);
		case 71:
		case 103:
			if ((active0 & 0x2000L) != 0L)
				return jjStartNfaWithStates_0(5, 13, 20);
			break;
		case 84:
		case 116:
			if ((active0 & 0x20000L) != 0L)
				return jjStartNfaWithStates_0(5, 17, 20);
			break;
		default:
			break;
		}
		return jjStartNfa_0(4, active0);
	}

	private int jjMoveStringLiteralDfa6_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(4, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(5, active0);
			return 6;
		}
		switch (curChar) {
		case 76:
		case 108:
			return jjMoveStringLiteralDfa7_0(active0, 0x80L);
		case 78:
		case 110:
			if ((active0 & 0x10000L) != 0L)
				return jjStartNfaWithStates_0(6, 16, 20);
			break;
		default:
			break;
		}
		return jjStartNfa_0(5, active0);
	}

	private int jjMoveStringLiteralDfa7_0(long old0, long active0) {
		if (((active0 &= old0)) == 0L)
			return jjStartNfa_0(5, old0);
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			jjStopStringLiteralDfa_0(6, active0);
			return 7;
		}
		switch (curChar) {
		case 69:
		case 101:
			if ((active0 & 0x80L) != 0L)
				return jjStartNfaWithStates_0(7, 7, 20);
			break;
		default:
			break;
		}
		return jjStartNfa_0(6, active0);
	}

	private int jjStartNfaWithStates_0(int pos, int kind, int state) {
		jjmatchedKind = kind;
		jjmatchedPos = pos;
		try {
			curChar = input_stream.readChar();
		} catch (java.io.IOException e) {
			return pos + 1;
		}
		return jjMoveNfa_0(state, pos + 1);
	}

	static final long[] jjbitVec0 = { 0x0L, 0x0L, 0xffffffffffffffffL,
			0xffffffffffffffffL };

	private int jjMoveNfa_0(int startState, int curPos) {
		int startsAt = 0;
		jjnewStateCnt = 39;
		int i = 1;
		jjstateSet[0] = startState;
		int kind = 0x7fffffff;
		for (;;) {
			if (++jjround == 0x7fffffff)
				ReInitRounds();
			if (curChar < 64) {
				long l = 1L << curChar;
				do {
					switch (jjstateSet[--i]) {
					case 22:
						if (curChar == 39) {
							if (kind > 25)
								kind = 25;
						} else if (curChar == 42)
							jjCheckNAddTwoStates(28, 29);
						else if (curChar == 47)
							jjCheckNAddStates(0, 2);
						break;
					case 39:
						if ((0x3ff000000000000L & l) != 0L) {
							if (kind > 27)
								kind = 27;
							jjCheckNAdd(20);
						} else if (curChar == 39) {
							if (kind > 25)
								kind = 25;
						}
						break;
					case 0:
						if ((0xfffffffbffffdbffL & l) != 0L)
							jjCheckNAdd(3);
						else if (curChar == 34)
							jjCheckNAddStates(3, 5);
						if ((0x3ff000000000000L & l) != 0L) {
							if (kind > 23)
								kind = 23;
							jjCheckNAddStates(6, 9);
						} else if (curChar == 47)
							jjAddStates(10, 11);
						else if (curChar == 39)
							jjstateSet[jjnewStateCnt++] = 1;
						break;
					case 2:
						if ((0xfffffffbffffdbffL & l) != 0L)
							jjCheckNAdd(3);
						break;
					case 3:
						if (curChar == 39 && kind > 25)
							kind = 25;
						break;
					case 5:
						if ((0x8400000000L & l) != 0L)
							jjCheckNAdd(3);
						break;
					case 6:
						if ((0xff000000000000L & l) != 0L)
							jjCheckNAddTwoStates(7, 3);
						break;
					case 7:
						if ((0xff000000000000L & l) != 0L)
							jjCheckNAdd(3);
						break;
					case 8:
						if ((0xf000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 9;
						break;
					case 9:
						if ((0xff000000000000L & l) != 0L)
							jjCheckNAdd(7);
						break;
					case 10:
						if (curChar == 34)
							jjCheckNAddStates(3, 5);
						break;
					case 11:
						if ((0xfffffffbffffdbffL & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					case 13:
						if ((0x8400000000L & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					case 14:
						if (curChar == 34 && kind > 26)
							kind = 26;
						break;
					case 15:
						if ((0xff000000000000L & l) != 0L)
							jjCheckNAddStates(12, 15);
						break;
					case 16:
						if ((0xff000000000000L & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					case 17:
						if ((0xf000000000000L & l) != 0L)
							jjstateSet[jjnewStateCnt++] = 18;
						break;
					case 18:
						if ((0xff000000000000L & l) != 0L)
							jjCheckNAdd(16);
						break;
					case 20:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 27)
							kind = 27;
						jjCheckNAdd(20);
						break;
					case 21:
						if (curChar == 47)
							jjAddStates(10, 11);
						break;
					case 23:
						if ((0xffffffffffffdbffL & l) != 0L)
							jjCheckNAddStates(0, 2);
						break;
					case 24:
						if ((0x2400L & l) != 0L && kind > 5)
							kind = 5;
						break;
					case 25:
						if (curChar == 10 && kind > 5)
							kind = 5;
						break;
					case 26:
						if (curChar == 13)
							jjstateSet[jjnewStateCnt++] = 25;
						break;
					case 27:
						if (curChar == 42)
							jjCheckNAddTwoStates(28, 29);
						break;
					case 28:
						if ((0xfffffbffffffffffL & l) != 0L)
							jjCheckNAddTwoStates(28, 29);
						break;
					case 29:
						if (curChar == 42)
							jjCheckNAddStates(16, 18);
						break;
					case 30:
						if ((0xffff7bffffffffffL & l) != 0L)
							jjCheckNAddTwoStates(31, 29);
						break;
					case 31:
						if ((0xfffffbffffffffffL & l) != 0L)
							jjCheckNAddTwoStates(31, 29);
						break;
					case 32:
						if (curChar == 47 && kind > 6)
							kind = 6;
						break;
					case 33:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 23)
							kind = 23;
						jjCheckNAddStates(6, 9);
						break;
					case 34:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 23)
							kind = 23;
						jjCheckNAdd(34);
						break;
					case 35:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 24)
							kind = 24;
						jjCheckNAdd(35);
						break;
					case 36:
						if (curChar == 46)
							jjCheckNAdd(37);
						break;
					case 37:
						if ((0x3ff000000000000L & l) == 0L)
							break;
						if (kind > 24)
							kind = 24;
						jjCheckNAdd(37);
						break;
					case 38:
						if ((0x3ff000000000000L & l) != 0L)
							jjCheckNAddTwoStates(36, 38);
						break;
					default:
						break;
					}
				} while (i != startsAt);
			} else if (curChar < 128) {
				long l = 1L << (curChar & 077);
				do {
					switch (jjstateSet[--i]) {
					case 39:
					case 20:
						if ((0x7fffffe87fffffeL & l) == 0L)
							break;
						if (kind > 27)
							kind = 27;
						jjCheckNAdd(20);
						break;
					case 0:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAdd(3);
						else if (curChar == 92)
							jjAddStates(19, 21);
						if ((0x7fffffe07fffffeL & l) != 0L) {
							if (kind > 27)
								kind = 27;
							jjCheckNAdd(20);
						}
						break;
					case 1:
						if ((0x7fffffe07fffffeL & l) != 0L && kind > 25)
							kind = 25;
						break;
					case 2:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAdd(3);
						break;
					case 4:
						if (curChar == 92)
							jjAddStates(19, 21);
						break;
					case 5:
						if ((0x14404410144044L & l) != 0L)
							jjCheckNAdd(3);
						break;
					case 11:
						if ((0xffffffffefffffffL & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					case 12:
						if (curChar == 92)
							jjAddStates(22, 24);
						break;
					case 13:
						if ((0x14404410144044L & l) != 0L)
							jjCheckNAddStates(3, 5);
						break;
					case 19:
						if ((0x7fffffe07fffffeL & l) == 0L)
							break;
						if (kind > 27)
							kind = 27;
						jjCheckNAdd(20);
						break;
					case 23:
						jjAddStates(0, 2);
						break;
					case 28:
						jjCheckNAddTwoStates(28, 29);
						break;
					case 30:
					case 31:
						jjCheckNAddTwoStates(31, 29);
						break;
					default:
						break;
					}
				} while (i != startsAt);
			} else {
				int i2 = (curChar & 0xff) >> 6;
				long l2 = 1L << (curChar & 077);
				do {
					switch (jjstateSet[--i]) {
					case 0:
						if ((jjbitVec0[i2] & l2) != 0L)
							jjstateSet[jjnewStateCnt++] = 3;
						break;
					case 11:
						if ((jjbitVec0[i2] & l2) != 0L)
							jjAddStates(3, 5);
						break;
					case 23:
						if ((jjbitVec0[i2] & l2) != 0L)
							jjAddStates(0, 2);
						break;
					case 28:
						if ((jjbitVec0[i2] & l2) != 0L)
							jjCheckNAddTwoStates(28, 29);
						break;
					case 30:
					case 31:
						if ((jjbitVec0[i2] & l2) != 0L)
							jjCheckNAddTwoStates(31, 29);
						break;
					default:
						break;
					}
				} while (i != startsAt);
			}
			if (kind != 0x7fffffff) {
				jjmatchedKind = kind;
				jjmatchedPos = curPos;
				kind = 0x7fffffff;
			}
			++curPos;
			if ((i = jjnewStateCnt) == (startsAt = 39 - (jjnewStateCnt = startsAt)))
				return curPos;
			try {
				curChar = input_stream.readChar();
			} catch (java.io.IOException e) {
				return curPos;
			}
		}
	}

	static final int[] jjnextStates = { 23, 24, 26, 11, 12, 14, 34, 35, 36, 38,
			22, 27, 11, 12, 16, 14, 29, 30, 32, 5, 6, 8, 13, 15, 17, };

	/** Token literal values. */
	public static final String[] jjstrLiteralImages = { "", null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, "\75", "\56", "\50",
			"\51", "\74", "\76", "\74\75", "\76\75", "\41\75", "\133", "\135",
			"\56\56", "\54", "\72", "\53", "\55", "\52", "\57", "\72\75",
			"\53\75", "\53\75\74", "\53\75\41\75", "\53\75\74\75",
			"\53\75\76\75", };

	/** Lexer state names. */
	public static final String[] lexStateNames = { "DEFAULT", };
	static final long[] jjtoToken = { 0x1fffffe0fffff81L, };
	static final long[] jjtoSkip = { 0x7eL, };
	static protected SimpleCharStream input_stream;
	static private final int[] jjrounds = new int[39];
	static private final int[] jjstateSet = new int[78];
	static protected char curChar;

	/** Constructor. */
	public Parser_1TokenManager(SimpleCharStream stream) {
		if (input_stream != null)
			throw new TokenMgrError(
					"ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.",
					TokenMgrError.STATIC_LEXER_ERROR);
		input_stream = stream;
	}

	/** Constructor. */
	public Parser_1TokenManager(SimpleCharStream stream, int lexState) {
		this(stream);
		SwitchTo(lexState);
	}

	/** Reinitialise parser. */
	public void ReInit(SimpleCharStream stream) {
		jjmatchedPos = jjnewStateCnt = 0;
		curLexState = defaultLexState;
		input_stream = stream;
		ReInitRounds();
	}

	private void ReInitRounds() {
		int i;
		jjround = 0x80000001;
		for (i = 39; i-- > 0;)
			jjrounds[i] = 0x80000000;
	}

	/** Reinitialise parser. */
	public void ReInit(SimpleCharStream stream, int lexState) {
		ReInit(stream);
		SwitchTo(lexState);
	}

	/** Switch to specified lex state. */
	public void SwitchTo(int lexState) {
		if (lexState >= 1 || lexState < 0)
			throw new TokenMgrError("Error: Ignoring invalid lexical state : "
					+ lexState + ". State unchanged.",
					TokenMgrError.INVALID_LEXICAL_STATE);
		else
			curLexState = lexState;
	}

	protected Token jjFillToken() {
		final Token t;
		final String curTokenImage;
		final int beginLine;
		final int endLine;
		final int beginColumn;
		final int endColumn;
		String im = jjstrLiteralImages[jjmatchedKind];
		curTokenImage = (im == null) ? input_stream.GetImage() : im;
		beginLine = input_stream.getBeginLine();
		beginColumn = input_stream.getBeginColumn();
		endLine = input_stream.getEndLine();
		endColumn = input_stream.getEndColumn();
		t = Token.newToken(jjmatchedKind, curTokenImage);

		t.beginLine = beginLine;
		t.endLine = endLine;
		t.beginColumn = beginColumn;
		t.endColumn = endColumn;

		return t;
	}

	static int curLexState = 0;
	static int defaultLexState = 0;
	static int jjnewStateCnt;
	static int jjround;
	static int jjmatchedPos;
	static int jjmatchedKind;

	/** Get the next Token. */
	public Token getNextToken() {
		Token matchedToken;
		int curPos = 0;

		EOFLoop: for (;;) {
			try {
				curChar = input_stream.BeginToken();
			} catch (java.io.IOException e) {
				jjmatchedKind = 0;
				matchedToken = jjFillToken();
				return matchedToken;
			}

			try {
				input_stream.backup(0);
				while (curChar <= 13 && (0x2400L & (1L << curChar)) != 0L)
					curChar = input_stream.BeginToken();
			} catch (java.io.IOException e1) {
				continue EOFLoop;
			}
			jjmatchedKind = 0x7fffffff;
			jjmatchedPos = 0;
			curPos = jjMoveStringLiteralDfa0_0();
			if (jjmatchedKind != 0x7fffffff) {
				if (jjmatchedPos + 1 < curPos)
					input_stream.backup(curPos - jjmatchedPos - 1);
				if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
					matchedToken = jjFillToken();
					return matchedToken;
				} else {
					continue EOFLoop;
				}
			}
			int error_line = input_stream.getEndLine();
			int error_column = input_stream.getEndColumn();
			String error_after = null;
			boolean EOFSeen = false;
			try {
				input_stream.readChar();
				input_stream.backup(1);
			} catch (java.io.IOException e1) {
				EOFSeen = true;
				error_after = curPos <= 1 ? "" : input_stream.GetImage();
				if (curChar == '\n' || curChar == '\r') {
					error_line++;
					error_column = 0;
				} else
					error_column++;
			}
			if (!EOFSeen) {
				input_stream.backup(1);
				error_after = curPos <= 1 ? "" : input_stream.GetImage();
			}
			throw new TokenMgrError(EOFSeen, curLexState, error_line,
					error_column, error_after, curChar,
					TokenMgrError.LEXICAL_ERROR);
		}
	}

	private void jjCheckNAdd(int state) {
		if (jjrounds[state] != jjround) {
			jjstateSet[jjnewStateCnt++] = state;
			jjrounds[state] = jjround;
		}
	}

	private void jjAddStates(int start, int end) {
		do {
			jjstateSet[jjnewStateCnt++] = jjnextStates[start];
		} while (start++ != end);
	}

	private void jjCheckNAddTwoStates(int state1, int state2) {
		jjCheckNAdd(state1);
		jjCheckNAdd(state2);
	}

	private void jjCheckNAddStates(int start, int end) {
		do {
			jjCheckNAdd(jjnextStates[start]);
		} while (start++ != end);
	}

}
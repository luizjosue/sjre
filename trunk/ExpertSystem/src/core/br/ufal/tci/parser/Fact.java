/*
 * Created on 01/09/2004
 *
 */
package br.ufal.tci.parser;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.HandlerObject.HandlerObjectImpl;
import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.InvalidDataException;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.expression.Expression;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.messages.MessageUtil;
import br.ufal.tci.operator.relational.DifferentRelationalOperator;
import br.ufal.tci.operator.relational.EqualRelationalOperator;
import br.ufal.tci.operator.relational.GreaterOrEqualRelationalOperator;
import br.ufal.tci.operator.relational.GreaterThanRelationalOperator;
import br.ufal.tci.operator.relational.LessOrEqualRelationalOperator;
import br.ufal.tci.operator.relational.LessThanRelationalOperator;
import br.ufal.tci.operator.relational.RelationalOperator;
import br.ufal.tci.type.BooleanType;
import br.ufal.tci.type.IntegerType;
import br.ufal.tci.type.RealType;
import br.ufal.tci.type.StringType;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 */
public class Fact {

	private Identifier identifier;
	private RelationalOperator relationalOperator;
	private Expression expression;
	private ObjectInstance objectInstantiation;

	// private HandlerObjectIF handler;

	public Fact() {
		this.identifier = null;
		this.relationalOperator = null;
		this.expression = null;
		this.objectInstantiation = null;
		// this.handler = null;
	}

	/**
	 * @return
	 */
	public Identifier getIdentifier() {
		return identifier;
	}

	/**
	 * @return
	 */
	public RelationalOperator getRelationalOperator() {
		return relationalOperator;
	}

	/**
	 * @param identifier
	 */
	public void setIdentifier(Identifier identifier, InferenceEngineIF engine)
			throws SemanticException, MissingElementException {
		if (SymbolTable.getInstance().lookup(identifier.getName(), engine) == null) {
			throw new SemanticException(MessageUtil.VARIABLE_NOT_DECLARED
					+ ": " + identifier.getName());
		} else {
			this.identifier = identifier;
		}
	}

	/**
	 * @param operator
	 */
	public void setRelationalOperator(RelationalOperator operator) {
		relationalOperator = operator;
	}

	/**
	 * @return
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * @param expression
	 */
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	/**
	 * @return
	 */
	public ObjectInstance getObjectInstantiation() {
		return objectInstantiation;
	}

	/**
	 * @param instance
	 */
	public void setObjectInstantiation(ObjectInstance instance) {
		objectInstantiation = instance;
	}

	/**
	 * @throws MissingElementException
	 * 
	 * */
	public Value<?> evaluate(InferenceEngineIF engine)
			throws SemanticException, MissingElementException {
		if (this.objectInstantiation != null) {
			tratarObjetos(engine);
		} else {
			Value<?> value = null;
			Variable variable = SymbolTable.getInstance().lookup(
					this.identifier.getName(), engine);
			if (variable != null) {
				try {
					value = this.expression.evaluate(engine);
					if (this.relationalOperator instanceof DifferentRelationalOperator) {
						/* Diferença (value,false,value,false) */
						try {
							variable.setValue(new Value<Interval>(new Interval(
									value, false, value, false, Value
											.generateType(value))));
						} catch (InvalidDataException e) {
							throw new SemanticException(e.getMessage());
						}

					} else if (this.relationalOperator instanceof EqualRelationalOperator) {
						/* Igualdade */
						variable.setValue(value);

					} else if (this.relationalOperator instanceof GreaterOrEqualRelationalOperator) {
						/* Maior ou igual */
						try {
							variable.setValue(new Value<Interval>(new Interval(
									value, true, null, false, Value
											.generateType(value))));
						} catch (InvalidDataException e) {
							throw new SemanticException(e.getMessage());
						}

					} else if (this.relationalOperator instanceof GreaterThanRelationalOperator) {
						/* Maior */
						try {
							variable.setValue(new Value<Interval>(new Interval(
									value, false, null, false, Value
											.generateType(value))));
						} catch (InvalidDataException e) {
							throw new SemanticException(e.getMessage());
						}

					} else if (this.relationalOperator instanceof LessOrEqualRelationalOperator) {
						/* Menor ou igual */
						try {
							variable.setValue(new Value<Interval>(new Interval(
									null, false, value, true, Value
											.generateType(value))));
						} catch (InvalidDataException e) {
							throw new SemanticException(e.getMessage());
						}

					} else if (this.relationalOperator instanceof LessThanRelationalOperator) {
						/* Menor */
						try {
							variable.setValue(new Value<Interval>(new Interval(
									null, false, value, false, Value
											.generateType(value))));
						} catch (InvalidDataException e) {
							throw new SemanticException(e.getMessage());
						}
					}

					/* A variavel foi atribuida a algum valor */
					variable.setAssigned(true);
					/* Atualiza a variavel na tabela de simbolos */
					SymbolTable.getInstance().update(variable, engine);
				} catch (MissingElementException e) {
					throw new SemanticException(
							MessageUtil.VARIABLE_NOT_DECLARED + " "
									+ e.getMessage());
				}
			} else {
				try {
					value = engine.findValue(new Variable(this.identifier));
					this.relationalOperator.evaluate(value, this.expression
							.evaluate(engine));
				} catch (MissingElementException e) {
					throw new SemanticException(
							MessageUtil.VARIABLE_NOT_DECLARED + " "
									+ e.getMessage());
				}
			}
		}
		return null;
	}

	private void tratarObjetos(InferenceEngineIF engine)
			throws MissingElementException, SemanticException {

		try {
			String packageName = "";
			List<String> parameters = new LinkedList<String>();
			List<Value<?>> parametersValue = new LinkedList<Value<?>>();

			String objectName = "";

			/* Trata o pacote */
			if (this.objectInstantiation.getPackageAndName() != null
					&& !this.objectInstantiation.getPackageAndName().isEmpty()) {

				objectName = this.objectInstantiation.getPackageAndName()
						.iterator().next().toString();

				/* Trata o pacote */
				int cont = 0;
				for (Unit unit : this.objectInstantiation.getPackageAndName()) {
					if (cont == 0) {
						cont++;
						continue;
					}
					packageName += (unit.toString() + ".");
					cont++;
				}
				packageName = packageName
						.substring(0, packageName.length() - 1);

				/* Trata os parametros */
				for (Unit unit : this.objectInstantiation.getArgumentList()) {
					Argument argument = (Argument) unit;
					if (!argument.isMethodCall()) {
						ordinaryCall(argument, parameters, parametersValue,
								engine);
					} else {
						// TODO Tratar chamada de metodo */
					}

					this.identifier = new Identifier(objectName);
					String[] aux = new String[parameters.size()];
					for (int j = 0; j < parameters.size(); j++) {
						aux[j] = (String) parameters.get(j);
					}
					// this.handler =
					new HandlerObjectImpl(packageName, aux, parametersValue
							.toArray());

					/* Chamada a interface que trata instanciacao de objetos */
					LoggerGenerator.debug("Nome do objeto: " + objectName);
					LoggerGenerator.debug("Nome do pacote: " + packageName);
					// Iterator foo1 = parameters.iterator();
					// Iterator foo2 = parametersValue.iterator();
					// Object obj1;
					// Object obj2;
					// while (foo1.hasNext()) {
					// obj1 = foo1.next();
					// obj2 = foo2.next();
					// LoggerGenerator.debug("Tipo: " + obj1 + " Valor: " +
					// unit);
					// }
				}

				/* Chamada a interface que trata instanciacao de objetos */
				LoggerGenerator.debug("Nome do objeto: " + objectName);
				LoggerGenerator.debug("Nome do pacote: " + packageName);

				String[] aux = new String[parameters.size()];
				for (int j = 0; j < parameters.size(); j++) {
					aux[j] = (String) parameters.get(j);
				}
				HandlerObjectImpl handler = new HandlerObjectImpl(packageName, aux,
						parametersValue.toArray());
				LoggerGenerator.debug("Handler instanciado " + handler);
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new SemanticException(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SemanticException(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new SemanticException(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new SemanticException(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new SemanticException(e.getMessage());
		}
	}

	private void ordinaryCall(Argument argument, List<String> parameters,
			List<Value<?>> parametersValue, InferenceEngineIF engine)
			throws MissingElementException, SemanticException {
		LoggerGenerator.debug(argument.getIdentifiers());
		if (argument != null && argument.getIdentifiers() != null
				&& !argument.getIdentifiers().isEmpty()) {
			Object object = argument.getIdentifiers().iterator().next();
			String argumentPackage = "";
			Value<?> argumentValue = null;
			if (object instanceof Identifier) {
				Identifier identifier = (Identifier) object;
				/* Trata variaveis */
				Variable variable = SymbolTable.getInstance().lookup(
						identifier.getName(), engine);
				if (variable != null) {
					// try {
					if (variable.isAssigned()) {
						if (variable.getType() instanceof IntegerType) {
							argumentPackage = "java.lang.Integer";
						} else if (variable.getType() instanceof RealType) {
							argumentPackage = "java.lang.Float";
						} else if (variable.getType() instanceof BooleanType) {
							argumentPackage = "java.lang.Boolean";
						} else if (variable.getType() instanceof StringType) {
							argumentPackage = "java.lang.String";
						}
						argumentValue = variable.evaluate();
						// TODO tratar objetos passados como
						// parametros
					} else {
						throw new SemanticException(
								MessageUtil.VARIABLE_NOT_INITIALIZED);
					}
					// } catch (NotFoundException e) {
					// throw new SemanticException(
					// Messages.VARIABLE_NOT_DECLARED + " "
					// + e.getMessage());
					// }
				} else {
					throw new SemanticException(
							MessageUtil.VARIABLE_NOT_DECLARED);
				}
			} else if (object instanceof Constant) {
				/* Trata constante */
				Constant constant = (Constant) object;
				if (constant.getType() instanceof IntegerType) {
					argumentPackage = "java.lang.Integer";
				} else if (constant.getType() instanceof RealType) {
					argumentPackage = "java.lang.Float";
				} else if (constant.getType() instanceof BooleanType) {
					argumentPackage = "java.lang.Boolean";
				} else if (constant.getType() instanceof StringType) {
					argumentPackage = "java.lang.String";
				}
				argumentValue = constant.getValue();
			}

			parameters.add(argumentPackage);
			parametersValue.add(argumentValue);
		}
	}
}

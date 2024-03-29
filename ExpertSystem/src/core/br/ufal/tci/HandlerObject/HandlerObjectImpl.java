package br.ufal.tci.HandlerObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.logger.LoggerGenerator;

/*
 * Created on 04/09/2004
 */

/**
 * @author mfp
 */

/*
 * A classe HandlerObjectImpl representa realmente um objeto, cada instancia
 * desta classe representa uma instancia de um objeto na Maquina de Inferencia e
 * possui metodos para manipular os metodos do objeto que representa
 */
public class HandlerObjectImpl implements HandlerObject {
	private Object object;
	private String className;

	/*
	 * Construtor da classe HandlerObject Onde sera instanciado o objeto
	 * realmente
	 * 
	 * Parametros:
	 * 
	 * String className : Nome da classe que sera carregada, caminho completo:
	 * "java.lang.Integer" String[] parameterType : Array de Strings contendo os
	 * tipos dos parametros do Construtor, informado tambem o caminho completo :
	 * "java.lang.Integer" Object[] : Arrayy de Objects contendo os valores dos
	 * parametros do Construtor
	 */
	public HandlerObjectImpl(String className, String[] parameterType,
			Object[] parameterConstructor) throws InvocationTargetException,
			ClassNotFoundException, IllegalAccessException,
			InstantiationException, NoSuchMethodException {
		Class<?>[] parameter = new Class[parameterType.length];
		int i;
		try {
			for (i = 0; i < parameterType.length; i++) {
				parameter[i] = Class.forName(parameterType[i]);
			}
			this.className = className;
			this.object = Class.forName(className).getConstructor(parameter)
					.newInstance(parameterConstructor);
		} catch (InvocationTargetException e) {
			LoggerGenerator.debug("InvocationTargetException::"
					+ e.getMessage());
			throw e;
		} catch (ClassNotFoundException e) {
			LoggerGenerator.debug("ClassNotFoundException::" + e.getMessage());
			throw e;
		} catch (IllegalAccessException e) {
			LoggerGenerator.debug("IllegalAccessException::" + e.getMessage());
			throw e;
		} catch (InstantiationException e) {
			LoggerGenerator.debug("InstantiationException::" + e.getMessage());
			throw e;
		} catch (NoSuchMethodException e) {
			LoggerGenerator.debug("NoSuchMethodException::" + e.getMessage());
			throw e;

		}
	}

	/*
	 * Construtor da classe HandlerObject Onde sera instanciado o objeto
	 * realmente
	 * 
	 * Uma sobrecarga do Construtor anterior, mas este instancia Objetos cujo o
	 * construtor nao possua parametros
	 * 
	 * Parametros:
	 * 
	 * String className : Nome da classe que sera carregada, caminho completo:
	 * "java.lang.Integer"
	 */
	public HandlerObjectImpl(String className) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException,
			NoSuchMethodException, InvocationTargetException {
		try {
			this.className = className;
			this.object = Class.forName(className).getConstructor(
					(Class<?>) null).newInstance((Object[]) null);
			this.className = className;
		} catch (ClassNotFoundException e) {
			LoggerGenerator.debug("ClassNotFoundException::" + e.getMessage());
			throw e;
		} catch (IllegalAccessException e) {
			LoggerGenerator.debug("IllegalAccessException::" + e.getMessage());
			throw e;
		} catch (InstantiationException e) {
			LoggerGenerator.debug("InstantiationException::" + e.getMessage());
			throw e;
		} catch (NoSuchMethodException e) {
			LoggerGenerator.debug("NoSuchMethodException::" + e.getMessage());
			throw e;
		} catch (InvocationTargetException e) {
			LoggerGenerator.debug("InvocationTargetException::"
					+ e.getMessage());
			throw e;
		}
	}

	/*
	 * Metodo que retorna a instancia do objeto que este HandlerObject
	 * representa
	 */
	public Object getObject() {
		return this.object;
	}

	public Object methodCall(String fieldName, String fieldType,
			Object fieldValue) throws ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		Method method;
		Class<?>[] parameter = new Class[1];
		Object[] value = new Object[1];
		String methodName = new String("set");
		Character firstChar = new Character(Character.toUpperCase(fieldName
				.charAt(0)));
		methodName = methodName.concat(new String(firstChar.toString()
				+ fieldName.substring(1)));
		try {
			parameter[0] = Class.forName(fieldType);
			value[0] = fieldValue;
			method = Class.forName(this.className).getMethod(methodName,
					parameter);
			return method.invoke(this.object, value);
		} catch (ClassNotFoundException e) {
			LoggerGenerator.debug("ClassNotFoundException::" + e.getMessage());
			throw e;
		} catch (NoSuchMethodException e) {
			LoggerGenerator.debug("NoSuchMethodException::" + e.getMessage());
			throw e;
		} catch (IllegalAccessException e) {
			LoggerGenerator.debug("IllegalAccessException::" + e.getMessage());
			throw e;
		} catch (InvocationTargetException e) {
			LoggerGenerator.debug("InvocationTargetException::"
					+ e.getMessage());
			throw e;
		}
	}

	public Object methodCall(String methodName, String[] parameterType,
			Object[] parameterValue) throws ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		Method method;
		Class<?>[] parameter = new Class[parameterType.length];
		try {
			for (int i = 0; i < parameterType.length; i++) {
				parameter[i] = Class.forName(parameterType[i]);
			}
			method = Class.forName(this.className).getMethod(methodName,
					parameter);
			return method.invoke(this.object, parameterValue);
		} catch (ClassNotFoundException e) {
			LoggerGenerator.debug("ClassNotFoundException::" + e.getMessage());
			throw e;
		} catch (NoSuchMethodException e) {
			LoggerGenerator.debug("NoSuchMethodException::" + e.getMessage());
			throw e;
		} catch (IllegalAccessException e) {
			LoggerGenerator.debug("IllegalAccessException::" + e.getMessage());
			throw e;
		} catch (InvocationTargetException e) {
			LoggerGenerator.debug("InvocationTargetException::"
					+ e.getMessage());
			throw e;
		}
	}

	public Object methodCall(String methodName) throws ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		try {
			return Class.forName(this.className).getMethod(methodName,
					(Class<?>) null).invoke(this.object, (Object) null);
		} catch (ClassNotFoundException e) {
			LoggerGenerator.debug("ClassNotFoundException::" + e.getMessage());
			throw e;
		} catch (NoSuchMethodException e) {
			LoggerGenerator.debug("NoSuchMethodException::" + e.getMessage());
			throw e;
		} catch (IllegalAccessException e) {
			LoggerGenerator.debug("IllegalAccessException::" + e.getMessage());
			throw e;
		} catch (InvocationTargetException e) {
			LoggerGenerator.debug("InvocationTargetException::"
					+ e.getMessage());
			throw e;
		}
	}

	public static void main(String args[]) {
		try {
			/* Um Vector para conter os objetos da classe HandlerObject */
			List<HandlerObjectImpl> hObject = new LinkedList<HandlerObjectImpl>();

			/* Instancia de Marcos F�bio */
			Object[] parametersValue = new Object[3];
			parametersValue[0] = new String("Marcos F�bio");
			parametersValue[1] = new Float(8.5);
			parametersValue[2] = new Float(9);

			String[] parametersType = new String[3];
			parametersType[0] = "java.lang.String";
			parametersType[1] = "java.lang.Float";
			parametersType[2] = "java.lang.Float";

			hObject.add(new HandlerObjectImpl("Classes.Aluno", parametersType,
					parametersValue));

			/*
			 * variable: int : val1 object : umAluno
			 * 
			 * fact: val1 = 8 umAluno = new Classes.Aluno("Marcos",10,val1)
			 */

			/* Instancia de Luiz Josue */

			hObject.add(new HandlerObjectImpl("Classes.Aluno"));

			/* Instancia de Ulisses Silva */

			hObject.add(new HandlerObjectImpl("Classes.Aluno"));

			/* Instancia de Pessoa */

			hObject.add(new HandlerObjectImpl("Classes.Pessoa"));

			/* Um objeto auxiliar de HandlerObjectIF */
			HandlerObject ho = (HandlerObject) hObject.get(3);
			ho.methodCall("nome", "java.lang.String", "Jos�");

			ho = (HandlerObject) hObject.get(1);

			parametersType = new String[2];
			parametersType[0] = "java.lang.Float";
			parametersType[1] = "java.lang.Float";

			parametersValue = new Object[2];
			parametersValue[0] = new Float(10);
			parametersValue[1] = new Float(7);

			ho.methodCall("nome", "java.lang.String", "Luiz Josu�");
			ho.methodCall("setNotas", parametersType, parametersValue);

			ho = (HandlerObject) hObject.get(2);

			parametersValue[0] = new Float(10);
			parametersValue[1] = new Float(9);

			ho.methodCall("nome", "java.lang.String", "Miguel Costa");
			ho.methodCall("setNotas", parametersType, parametersValue);

			for (HandlerObjectImpl handlerObject : hObject) {
				ho = handlerObject;
				LoggerGenerator.debug(ho.methodCall("getNome").toString());
				LoggerGenerator.debug(ho.methodCall("getMedia").toString());
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}

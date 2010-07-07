package br.ufal.tci.HandlerObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.ui.UserInterface;
import br.ufal.tci.ui.UserInterfaceImpl;

/*
 * Created on 04/09/2004
 */

/**
 * @author mfp
 */

/*
 * A classe HandlerObject representa realmente um objeto, cada instancia desta
 * classe representa uma instancia de um objeto na Maquina de Inferencia e
 * possui metodos para manipular os metodos do objeto que representa
 */
public class HandlerObject implements HandlerObjectIF {
	private Object object;
	private String className;
	public UserInterface userInterface;

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
	public HandlerObject(String className, String[] parameterType,
			Object[] parameterConstructor) throws InvocationTargetException,
			ClassNotFoundException, IllegalAccessException,
			InstantiationException, NoSuchMethodException {
		this.userInterface = new UserInterfaceImpl();
		Class<?>[] parameter = new Class[parameterType.length];
		int i;
		try {
			for (i = 0; i < parameterType.length; i++) {
				parameter[i] = Class.forName(parameterType[i]);
			}
			this.className = className;
			this.object = Class.forName(className).getConstructor(parameter)
					.newInstance(parameterConstructor);
		} catch (InvocationTargetException te) {
			te.printStackTrace();
			this.userInterface.showErrorMessage(te.getMessage());
			throw te;
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			this.userInterface.showErrorMessage(ce.getMessage());
			throw ce;
		} catch (IllegalAccessException ae) {
			ae.printStackTrace();
			this.userInterface.showErrorMessage(ae.getMessage());
			throw ae;
		} catch (InstantiationException ie) {
			ie.printStackTrace();
			this.userInterface.showErrorMessage(ie.getMessage());
			throw ie;
		} catch (NoSuchMethodException me) {
			me.printStackTrace();
			this.userInterface.showErrorMessage(me.getMessage());
			throw me;

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
	public HandlerObject(String className) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException,
			NoSuchMethodException, InvocationTargetException {
		this.userInterface = new UserInterfaceImpl();
		try {
			this.className = className;
			this.object = Class.forName(className).getConstructor(
					(Class<?>) null).newInstance((Object[]) null);
			this.className = className;
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			this.userInterface.showErrorMessage(ce.getMessage());
			throw ce;
		} catch (IllegalAccessException ae) {
			ae.printStackTrace();
			this.userInterface.showErrorMessage(ae.getMessage());
			throw ae;
		} catch (InstantiationException ie) {
			ie.printStackTrace();
			this.userInterface.showErrorMessage(ie.getMessage());
			throw ie;
		} catch (NoSuchMethodException me) {
			me.printStackTrace();
			this.userInterface.showErrorMessage(me.getMessage());
			throw me;
		} catch (InvocationTargetException te) {
			te.printStackTrace();
			LoggerGenerator.debug(te.getMessage());
			throw te;
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
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			this.userInterface.showErrorMessage(ce.getMessage());
			throw ce;
		} catch (NoSuchMethodException me) {
			me.printStackTrace();
			this.userInterface.showErrorMessage(me.getMessage());
			throw me;
		} catch (IllegalAccessException ae) {
			ae.printStackTrace();
			this.userInterface.showErrorMessage(ae.getMessage());
			throw ae;
		} catch (InvocationTargetException te) {
			te.printStackTrace();
			this.userInterface.showErrorMessage(te.getMessage());
			throw te;
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
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			this.userInterface.showErrorMessage(ce.getMessage());
			throw ce;
		} catch (NoSuchMethodException me) {
			me.printStackTrace();
			this.userInterface.showErrorMessage(me.getMessage());
			throw me;
		} catch (IllegalAccessException ae) {
			ae.printStackTrace();
			this.userInterface.showErrorMessage(ae.getMessage());
			throw ae;
		} catch (InvocationTargetException te) {
			te.printStackTrace();
			this.userInterface.showErrorMessage(te.getMessage());
			throw te;
		}
	}

	public Object methodCall(String methodName) throws ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		try {
			return Class.forName(this.className).getMethod(methodName,
					(Class<?>) null).invoke(this.object, (Object) null);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			this.userInterface.showErrorMessage(ce.getMessage());
			throw ce;
		} catch (NoSuchMethodException me) {
			me.printStackTrace();
			this.userInterface.showErrorMessage(me.getMessage());
			throw me;
		} catch (IllegalAccessException ae) {
			ae.printStackTrace();
			this.userInterface.showErrorMessage(ae.getMessage());
			throw ae;
		} catch (InvocationTargetException te) {
			te.printStackTrace();
			this.userInterface.showErrorMessage(te.getMessage());
			throw te;
		}
	}

	public static void main(String args[]) {
		try {
			/* Um Vector para conter os objetos da classe HandlerObject */
			List<HandlerObject> hObject = new LinkedList<HandlerObject>();

			/* Instancia de Marcos Fábio */
			Object[] parametersValue = new Object[3];
			parametersValue[0] = new String("Marcos Fábio");
			parametersValue[1] = new Float(8.5);
			parametersValue[2] = new Float(9);

			String[] parametersType = new String[3];
			parametersType[0] = "java.lang.String";
			parametersType[1] = "java.lang.Float";
			parametersType[2] = "java.lang.Float";

			hObject.add(new HandlerObject("Classes.Aluno", parametersType,
					parametersValue));

			/*
			 * variable: int : val1 object : umAluno
			 * 
			 * fact: val1 = 8 umAluno = new Classes.Aluno("Marcos",10,val1)
			 */

			/* Instancia de Luiz Josue */

			hObject.add(new HandlerObject("Classes.Aluno"));

			/* Instancia de Ulisses Silva */

			hObject.add(new HandlerObject("Classes.Aluno"));

			/* Instancia de Pessoa */

			hObject.add(new HandlerObject("Classes.Pessoa"));

			/* Um objeto auxiliar de HandlerObjectIF */
			HandlerObjectIF ho = (HandlerObjectIF) hObject.get(3);
			ho.methodCall("nome", "java.lang.String", "José");

			ho = (HandlerObjectIF) hObject.get(1);

			parametersType = new String[2];
			parametersType[0] = "java.lang.Float";
			parametersType[1] = "java.lang.Float";

			parametersValue = new Object[2];
			parametersValue[0] = new Float(10);
			parametersValue[1] = new Float(7);

			ho.methodCall("nome", "java.lang.String", "Luiz Josué");
			ho.methodCall("setNotas", parametersType, parametersValue);

			ho = (HandlerObjectIF) hObject.get(2);

			parametersValue[0] = new Float(10);
			parametersValue[1] = new Float(9);

			ho.methodCall("nome", "java.lang.String", "Miguel Costa");
			ho.methodCall("setNotas", parametersType, parametersValue);

			for (HandlerObject handlerObject : hObject) {
				ho = handlerObject;
				LoggerGenerator.debug(ho.methodCall("getNome").toString());
				LoggerGenerator.debug(ho.methodCall("getMedia").toString());
			}
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

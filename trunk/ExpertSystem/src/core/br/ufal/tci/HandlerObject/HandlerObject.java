/*
 * Created on 20/10/2004
 */
package br.ufal.tci.HandlerObject;

import java.lang.reflect.InvocationTargetException;

/**
 * @author mfp
 */
public interface HandlerObject {

	/**
	 * Método para chamar algum método pertence a classe que HandlerObject esta
	 * representando chamda padrao de metodos, exemplo:
	 * "aluno.getMedia(Integer n1,Integer n2)" os metodos devem possuir
	 * parametros, para metodos que nao possuam parametros use a chamada
	 * "methodCall(String methodName)"
	 * 
	 * Parametros:
	 * 
	 * String methodName : nome do metodo a ser invocado String[] parameterType
	 * : Array de strings contendo os tipos dos parametros do metodo com caminho
	 * completo, exemplo "java.lang.Integer" Object[] parameterValue : Array de
	 * objects contendo os valores que serao passados como parametros
	 * 
	 * Retorno:
	 * 
	 * Object: o retorno do metodo que foi chamado
	 * */
	public Object methodCall(String methodName, String[] paramType,
			Object[] paramValue) throws InvocationTargetException,
			ClassNotFoundException, IllegalAccessException,
			InstantiationException, NoSuchMethodException;

	/**
	 * Método para chamar algum método pertence a classe que HandlerObject esta
	 * representando, serve para as chamadas do tipo "aluno.idade=10" este
	 * metodo converte "aluno.idade=10" para "aluno.setIdade(10)" e executa em
	 * seguida
	 * 
	 * Parametros:
	 * 
	 * String fieldName : nome do campo, exemplo: "idade" String fieldType :
	 * tipo do campo, exemplo: "java.lang.Integer" Object fieldValue : valor
	 * passado como parametro ao metodo, lado direito da igualdade, exemplo:
	 * "new Integer(10)"
	 * 
	 * Retorno:
	 * 
	 * Object: o retorno do metodo que foi chamado
	 * */
	public Object methodCall(String methodName, String paramType,
			Object paramValue) throws InvocationTargetException,
			ClassNotFoundException, IllegalAccessException,
			InstantiationException, NoSuchMethodException;

	/**
	 * Método para chamar algum método pertence a classe que HandlerObject esta
	 * representando chamda padrao de metodos, exemplo: "aluno.getMedia()" os
	 * metodos NAO devem POSSUIR parametros, para metodos que POSSUAM parametros
	 * use a chamada
	 * "methodCall(String methodName,String[] parameterType,Object[] parameterValue)"
	 * 
	 * Parametros:
	 * 
	 * String methodName : nome do metodo a ser invocado
	 * 
	 * Retorno:
	 * 
	 * Object: o retorno do metodo que foi chamado
	 * */
	public Object methodCall(String methodName)
			throws InvocationTargetException, ClassNotFoundException,
			IllegalAccessException, InstantiationException,
			NoSuchMethodException;

	/**
	 * Método que retorna o objeto que a instância de HandlerObject representa
	 * */
	public Object getObject();

}

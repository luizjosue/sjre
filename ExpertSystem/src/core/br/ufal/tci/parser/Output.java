/*
 * Created on Sep 8, 2004
 *
 * 
 */
package br.ufal.tci.parser;

import br.ufal.tci.logger.LoggerGenerator;

/**
 * @author desenvolvimento
 *
 */
public class Output {

	private static Output output = null;
	
	protected Output(){
	}
	
	public static Output Instance(){
		if(output==null){
			output = new Output();
		}
		return output;
	}
	
	public void sendMessage(String message){
		LoggerGenerator.debug("Erro: "+message);
	}
	
}

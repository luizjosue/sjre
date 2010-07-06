/*
 * Created on 13/10/2004
 *
 * 
 * 
 */
package br.ufal.tci.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * @author ljsf
 *
 *	Classe que estende InputStream e recebe como 
 *	parametro no construtor um StringReader e delega
 *	o método reader ao StringReader passado
 *
 */
public class StringInputStream extends InputStream {
	
	private StringReader reader;
	
	public StringInputStream(StringReader reader){
		this.reader = reader;
	}

	/* (non-Javadoc)
	 * @see java.io.InputStream#read()
	 */
	public int read() throws IOException {
		return this.reader.read();
	}

}

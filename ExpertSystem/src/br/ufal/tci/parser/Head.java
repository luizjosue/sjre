/*
 * Created on 15/09/2004
 *
 */
package br.ufal.tci.parser;

import java.util.LinkedList;
import java.util.List;

import br.ufal.tci.InferenceEngine.InferenceEngineIF;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;

/**
 * @author ljsf
 * 
 *         15/09/2004
 * 
 */
public class Head {

	/**
	 * Representa uma collection de lista de conclusões
	 * */
	private List<Fact> conclusionList;

	public Head() {
		this.conclusionList = new LinkedList<Fact>();
	}

	/**
	 * Método que dispara a regra de acordo com o motor de inferência passado
	 * como parãmetro
	 * 
	 * @throws MissingElementException
	 * */
	public void evaluate(InferenceEngineIF engine) throws SemanticException,
			MissingElementException {
		if (conclusionList != null && !conclusionList.isEmpty()) {
			for (Fact fact : conclusionList) {
				fact.evaluate(engine);
			}
		}
	}

	public void setConclusionList(List<Fact> conclusionList) {
		this.conclusionList = conclusionList;
	}

	public List<Fact> getConclusionList() {
		return conclusionList;
	}

}

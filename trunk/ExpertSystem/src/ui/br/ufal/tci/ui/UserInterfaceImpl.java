/*
 * Created on 24/09/2004
 *
 * 
 * 
 */
package br.ufal.tci.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.parser.Variable;
import br.ufal.tci.ui.forms.BooleanForm;
import br.ufal.tci.ui.forms.IntegerForm;
import br.ufal.tci.ui.forms.StringForm;

/**
 * @author mcp
 * 
 *         
 *         
 */
public class UserInterfaceImpl implements UserInterface {
	private Object obj;

	public Object getObject() {
		return this.obj;
	}

	public void setObject(Object obj) {
		this.obj = obj;
	}

	public Object getAsk(Variable var) {
		String identifier, type;
		identifier = var.getIdentifier().toString();
		type = var.getType().toString();
		if (type.equals("BooleanType")) {
			BooleanForm frm = new BooleanForm(this, identifier);
			frm.setVisible(true);
		}
		if (type.equals("IntegerType")) {
			IntegerForm frm = new IntegerForm(this, identifier);
			frm.setVisible(true);
		}
		if (type.equals("StringType")) {
			StringForm frm = new StringForm(this, identifier);
			frm.setVisible(true);
		}

		return new String("Nao sei");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ufal.tci.UserInterface.UserInterfaceIF#getSource()
	 */
	public String getSource() {
		String all = new String();
		String arq;
		JFileChooser fileChosser = new JFileChooser();
		// int returnfile = fileChosser.showOpenDialog(null);
		fileChosser.showOpenDialog(null);
		arq = fileChosser.getSelectedFile().getAbsolutePath();
		File file = new File(arq);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while (line != null) {
				all += line + "\n";
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			LoggerGenerator.debug("Error: " + e.toString());
		}
		LoggerGenerator.debug(all);
		return all;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.ufal.tci.UserInterface.UserInterfaceIF#showErrorMessage(java.lang.
	 * String)
	 */
	public void showErrorMessage(String message) {
		JOptionPane
				.showMessageDialog(null, "O erro " + message + " foi gerado!",
						"Mensagem de erro", JOptionPane.ERROR_MESSAGE);
	}

}

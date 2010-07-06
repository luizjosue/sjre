package br.ufal.tci.ui.forms;

// This code was partially generated by Visual for Eclipse (v4all)
//
// *******************************************************************************
//
// V4ALL for Swing)
//
// (c) Ramin Assisi, Computer Scientist, Switzerland 2003
//
//
// *******************************************************************************
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JOptionPane;

import br.ufal.tci.ui.UserInterfaceImpl;

public class StringForm extends javax.swing.JFrame {

	private void initConnections() throws java.lang.Exception {

	}

	private javax.swing.JPanel getfrmTypeString() {
		if (frmTypeString == null) {
			try {
				frmTypeString = new javax.swing.JPanel();
				frmTypeString.setName("frmTypeString");
				frmTypeString.setBackground(new java.awt.Color(204, 204, 204));
				frmTypeString.setForeground(new java.awt.Color(0, 0, 0));
				frmTypeString.setFont(new java.awt.Font("Arial", 0, 12));
				frmTypeString.setLayout(null);
				getfrmTypeString().add(getlblQuestion(identifier),
						getlblQuestion(identifier).getName());
				getlblQuestion(identifier).setBackground(
						getfrmTypeString().getBackground());
				getfrmTypeString().add(gettxtValue(), gettxtValue().getName());
				getfrmTypeString().add(getbtnOk(), getbtnOk().getName());
				getfrmTypeString()
						.add(getbtnCancel(), getbtnCancel().getName());
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return frmTypeString;
	}

	/**
	 * V4ALL Entry Level Return the scrollVariables property value.
	 * 
	 * @return javax.swing.JScrollPanel
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */

	private javax.swing.JLabel getlblQuestion(String name) {
		if (lblQuestion == null) {
			try {
				lblQuestion = new javax.swing.JLabel();
				lblQuestion.setBounds(20, 10, 220, 20);
				lblQuestion.setMinimumSize(new java.awt.Dimension(220, 20));
				lblQuestion.setMaximumSize(new java.awt.Dimension(220, 20));
				lblQuestion.setName("lblQuestion");
				lblQuestion.setBackground(new java.awt.Color(204, 204, 204));
				lblQuestion.setForeground(new java.awt.Color(0, 0, 0));
				lblQuestion.setFont(new java.awt.Font("Arial", 0, 12));
				lblQuestion.setOpaque(false);
				lblQuestion.setText("Qual o nome de " + name + "?");
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return lblQuestion;
	}

	private javax.swing.JTextField gettxtValue() {
		if (txtValue == null) {
			try {
				txtValue = new javax.swing.JTextField();
				txtValue.setBounds(20, 40, 210, 20);
				txtValue.setMinimumSize(new java.awt.Dimension(210, 20));
				txtValue.setMaximumSize(new java.awt.Dimension(210, 20));
				txtValue.setName("txtEdit");
				txtValue.setBackground(new java.awt.Color(255, 255, 255));
				txtValue.setForeground(new java.awt.Color(0, 0, 0));
				txtValue.setFont(new java.awt.Font("Arial", 0, 12));
				txtValue.setOpaque(true);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return txtValue;
	}

	private javax.swing.JButton getbtnOk() {
		if (btnOk == null) {
			try {
				btnOk = new javax.swing.JButton();
				btnOk.setBounds(20, 70, 90, 30);
				btnOk.setMinimumSize(new java.awt.Dimension(90, 30));
				btnOk.setMaximumSize(new java.awt.Dimension(90, 30));
				btnOk.setName("btnOk");
				btnOk.setBackground(new java.awt.Color(204, 204, 204));
				btnOk.setForeground(new java.awt.Color(0, 0, 0));
				btnOk.setFont(new java.awt.Font("Arial", 0, 12));
				btnOk.setOpaque(true);
				btnOk.setText("OK");
				btnOk.setActionCommand("");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						actionOk();
					}
				});
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return btnOk;
	}

	private javax.swing.JButton getbtnCancel() {
		if (btnCancel == null) {
			try {
				btnCancel = new javax.swing.JButton();
				btnCancel.setBounds(140, 70, 90, 30);
				btnCancel.setMinimumSize(new java.awt.Dimension(90, 30));
				btnCancel.setMaximumSize(new java.awt.Dimension(90, 30));
				btnCancel.setName("btnCancel");
				btnCancel.setBackground(new java.awt.Color(204, 204, 204));
				btnCancel.setForeground(new java.awt.Color(0, 0, 0));
				btnCancel.setFont(new java.awt.Font("Arial", 0, 12));
				btnCancel.setOpaque(true);
				btnCancel.setText("Cancelar");
				btnCancel.setActionCommand("");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						actionExit();
					}
				});
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return btnCancel;
	}

	public void actionExit() {
		this.setVisible(false);
	}

	public boolean isString(String text) {
		boolean result = true;
		int i = 0;
		for (i = 0; i < text.length(); i++) {
			if (text.charAt(i) < 'a' || text.charAt(i) > 'z') {
				if (text.charAt(i) < 'A' || text.charAt(i) > 'Z') {
					result = false;
				}
			}
		}
		return result;
	}

	public void actionOk() {
		if (isString(txtValue.getText()) && !txtValue.getText().equals("")) {
			inter.setObject(new String(txtValue.getText()));
			actionExit();
		} else {
			JOptionPane
					.showMessageDialog(null,
							"Valor inv�lido, \na entrada deve ser composta por caracteres\n a..z || A..Z");
		}
	}

	public static void showComponentCentered(java.awt.Component component) {
		positionComponentCentered(component);
		if (component instanceof javax.swing.JFrame) {
			// ((javax.swing.JFrame)component).toFront();
			((javax.swing.JFrame) component).setVisible(true);
		} else if (component instanceof javax.swing.JDialog) {
			// ((javax.swing.JDialog)component).toFront();
			((javax.swing.JDialog) component).setVisible(true);
		} else if (component instanceof javax.swing.JWindow) {
			// ((javax.swing.JWindow)component).toFront();
			((javax.swing.JWindow) component).setVisible(true);
		}
	}

	public static void positionComponentCentered(java.awt.Component component) {
		int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int dialogHeight = component.getSize().height;
		int dialogWidth = component.getSize().width;
		component.setLocation(width / 2 - dialogWidth / 2, height / 2
				- dialogHeight / 2);
	}

	/**
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			this
					.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			this.setSize(250, 150);
			this.setContentPane(getfrmTypeString());
			this.setTitle("Coletor de Informa�ao");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					System.exit(0);
				};
			});

			this.setVisible(true);
			showComponentCentered(this);
			this.setVisible(true);

			String plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

			try {
				javax.swing.UIManager.setLookAndFeel(plaf);
				javax.swing.SwingUtilities.updateComponentTreeUI(this);
			} catch (javax.swing.UnsupportedLookAndFeelException ex1) {
				// LoggerGenerator.debug(ex1);
			} catch (ClassNotFoundException ex2) {
				// LoggerGenerator.debug(ex2);
			} catch (InstantiationException ex3) {
				// LoggerGenerator.debug(ex3);
			} catch (IllegalAccessException ex4) {
				// LoggerGenerator.debug(ex4);
			}
			initConnections();
		} catch (Throwable e) {
			handleException(e);
		}
	}

	/**
	 * V4ALL Entry Level Called whenever the part throws an exception.
	 * 
	 * @param exception
	 *            java.lang.Throwable
	 */
	private void handleException(java.lang.Throwable exception) {
		/* Uncomment the following lines to print uncaught exceptions to stdout */
		// LoggerGenerator.debug("--------- UNCAUGHT EXCEPTION ---------");
		// exception.printStackTrace(System.out);
	}

	private javax.swing.JPanel frmTypeString = null;
	private javax.swing.JLabel lblQuestion = null;
	public javax.swing.JTextField txtValue = null;
	public javax.swing.JButton btnOk = null;
	public javax.swing.JButton btnCancel = null;
	public String identifier = null;
	public UserInterfaceImpl inter = null;

	/**
	 * FormEditor constructor comment.
	 */
	public StringForm(UserInterfaceImpl inter, String identifier) {
		this.inter = inter;
		this.identifier = identifier;
		initialize();
	}

	/*
	 * public static void main(java.lang.String[] args) { try { UserInterface
	 * frm; frm = new UserInterface(); frm.getAsk("casa","String"); } catch
	 * (Throwable exception) {
	 * System.err.println("Exception occurred in main() of javax.swing.JFrame");
	 * exception.printStackTrace(System.out); } }
	 */
}

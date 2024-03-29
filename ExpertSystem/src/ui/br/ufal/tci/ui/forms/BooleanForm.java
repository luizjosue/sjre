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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.ufal.tci.ui.UserInterfaceImpl;

public class BooleanForm extends javax.swing.JFrame {

	private void initConnections() throws java.lang.Exception {

	}

	private javax.swing.JPanel getfrmTypeBoolean() {
		if (frmTypeBoolean == null) {
			try {
				frmTypeBoolean = new javax.swing.JPanel();
				frmTypeBoolean.setName("frmTypeBoolean");
				frmTypeBoolean.setBackground(new java.awt.Color(204, 204, 204));
				frmTypeBoolean.setForeground(new java.awt.Color(0, 0, 0));
				frmTypeBoolean.setFont(new java.awt.Font("Arial", 0, 12));
				frmTypeBoolean.setLayout(null);
				getfrmTypeBoolean().add(getlblQuestion(identifier),
						getlblQuestion(identifier).getName());
				getlblQuestion(identifier).setBackground(
						getfrmTypeBoolean().getBackground());
				getfrmTypeBoolean().add(getrdoFalse(), getrdoFalse().getName());
				getfrmTypeBoolean().add(getrdoTrue(), getrdoTrue().getName());
				getfrmTypeBoolean().add(getbtnOk(), getbtnOk().getName());
				getfrmTypeBoolean().add(getbtnCancel(),
						getbtnCancel().getName());
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return frmTypeBoolean;
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
				lblQuestion.setText(name + " � verdadeiro?");
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return lblQuestion;
	}

	// private ButtonGroup getgrpTypeBoolean() {
	// if (grpTypeBoolean == null) {
	// try {
	// grpTypeBoolean = new ButtonGroup();
	//
	// } catch (java.lang.Throwable ivjExc) {
	// handleException(ivjExc);
	// }
	// }
	// return grpTypeBoolean;
	// }

	private javax.swing.JRadioButton getrdoTrue() {
		if (rdoTrue == null) {
			try {
				rdoTrue = new javax.swing.JRadioButton();
				rdoTrue.setBounds(30, 40, 80, 20);
				rdoTrue.setMinimumSize(new java.awt.Dimension(80, 20));
				rdoTrue.setMaximumSize(new java.awt.Dimension(80, 20));
				rdoTrue.setName("rdoTrue");
				rdoTrue.setText("Sim");
				rdoTrue.setSelected(true);
				rdoTrue.setBackground(new java.awt.Color(204, 204, 204));
				rdoTrue.setForeground(new java.awt.Color(0, 0, 0));
				rdoTrue.setFont(new java.awt.Font("Arial", 0, 12));
				rdoTrue.setOpaque(true);
				grpTypeBoolean.add(rdoTrue);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return rdoTrue;
	}

	private JRadioButton getrdoFalse() {
		if (rdoFalse == null) {
			try {
				rdoFalse = new JRadioButton();
				rdoFalse.setBounds(140, 40, 80, 20);
				rdoFalse.setMinimumSize(new java.awt.Dimension(80, 20));
				rdoFalse.setMaximumSize(new java.awt.Dimension(80, 20));
				rdoFalse.setName("rdoFalse");
				rdoFalse.setText("N�o");
				rdoFalse.setBackground(new java.awt.Color(204, 204, 204));
				rdoFalse.setForeground(new java.awt.Color(0, 0, 0));
				rdoFalse.setFont(new java.awt.Font("Arial", 0, 12));
				rdoFalse.setOpaque(true);
				grpTypeBoolean.add(rdoFalse);
			} catch (java.lang.Throwable ivjExc) {
				handleException(ivjExc);
			}
		}
		return rdoFalse;
	}

	private JButton getbtnOk() {
		if (btnOk == null) {
			try {
				btnOk = new JButton();
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

	private JButton getbtnCancel() {
		if (btnCancel == null) {
			try {
				btnCancel = new JButton();
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

	public void actionOk() {
		if (rdoTrue.isSelected())
			inter.setObject(new Boolean(true));
		if (rdoFalse.isSelected())
			inter.setObject(new Boolean(false));
		this.actionExit();
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
			this.setContentPane(getfrmTypeBoolean());
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

	private JPanel frmTypeBoolean = null;
	private JLabel lblQuestion = null;
	public JTextField txtValue = null;
	public JButton btnOk = null;
	public JButton btnCancel = null;
	public ButtonGroup grpTypeBoolean = new ButtonGroup();
	public JRadioButton rdoTrue = null;
	public JRadioButton rdoFalse = null;

	public String identifier = null;
	public UserInterfaceImpl inter = null;

	/**
	 * FormEditor constructor comment.
	 */
	public BooleanForm(UserInterfaceImpl inter, String identifier) {
		this.inter = inter;
		this.identifier = identifier;
		initialize();
	}

}

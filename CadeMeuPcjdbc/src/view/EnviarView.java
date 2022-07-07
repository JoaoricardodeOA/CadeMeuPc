package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EnviarController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnviarView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSerial;
	private JTextField textPatrimonio;
	private JTextField textIdade;
	private JTextField textModelo;
	private JTextField textPrestador;
	private JTextField textData;
	private JTextField textValor;
	private JTextField textNF;
	private JTextField textResponsavel;
	private JTextField textOS;
	private JTextField textProblema;
	private JTextField textTipo;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton;
	public JCheckBox getChckbxNewCheckBox() {
		return chckbxNewCheckBox;
	}

	public void setChckbxNewCheckBox(JCheckBox chckbxNewCheckBox) {
		this.chckbxNewCheckBox = chckbxNewCheckBox;
	}

	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	private EnviarController controller;
	private JTextField textField;
	
	public void exibeMensagem(String msg) {
		JOptionPane.showMessageDialog(null,msg);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarView frame = new EnviarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EnviarView() {
		controller = new EnviarController(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textSerial = new JTextField();
		textSerial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textPatrimonio.requestFocus();
				}
			}
		});
		textSerial.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("serial number");
		
		JLabel lblNewLabel_1 = new JLabel("patrim\u00F4nio");
		
		textPatrimonio = new JTextField();
		textPatrimonio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textIdade.requestFocus();
				}
			}
		});
		textPatrimonio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("idade");
		lblNewLabel_2.setToolTipText("");
		
		textIdade = new JTextField();
		textIdade.setText("01/01/2000");
		textIdade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textModelo.requestFocus();
				}
			}
		});
		textIdade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("modelo");
		
		textModelo = new JTextField();
		textModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textField.requestFocus();
				}
			}
		});
		textModelo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("empresa");
		
		JLabel lblNewLabel_5 = new JLabel("prestador");
		
		textPrestador = new JTextField();
		textPrestador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textData.requestFocus();
				}
			}
		});
		textPrestador.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("data ocorrencia");
		
		textData = new JTextField();
		textData.setText("01/01/2020");
		textData.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textValor.requestFocus();
				}
			}
		});
		textData.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("valor");
		
		textValor = new JTextField();
		textValor.setText("0,00");
		textValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textNF.requestFocus();
				}
			}
		});
		textValor.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("NF");
		
		textNF = new JTextField();
		textNF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textResponsavel.requestFocus();
				}
			}
		});
		textNF.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("respons\u00E1vel");
		
		textResponsavel = new JTextField();
		textResponsavel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textOS.requestFocus();
				}
			}
		});
		textResponsavel.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("OS");
		
		textOS = new JTextField();
		textOS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textProblema.requestFocus();
				}
			}
		});
		textOS.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("problema");
		
		textProblema = new JTextField();
		textProblema.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					btnNewButton.requestFocus();
				}
			}
		});
		textProblema.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("com fonte?");
		
		JLabel lblNewLabel_12 = new JLabel("tipo");
		
		textTipo = new JTextField();
		textTipo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textPrestador.requestFocus();
				}
			}
		});
		textTipo.setColumns(10);
		
		btnNewButton = new JButton("enviar");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					controller.lerDados();
				}
			}			
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lerDados();
			}
		});
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					textTipo.requestFocus();
				}
			}
		});
		textField.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("R$");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_9)
								.addComponent(textResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(textSerial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textPrestador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(59)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6)
										.addComponent(textPatrimonio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)
										.addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_10)
										.addComponent(textOS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_12))))
							.addGap(18)
							.addComponent(lblNewLabel_13)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_11)
									.addContainerGap())
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(chckbxNewCheckBox)
										.addContainerGap())
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblNewLabel_2)
													.addComponent(textIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblNewLabel_7)
													.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(textNF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblNewLabel_3)
													.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblNewLabel_8)))
											.addComponent(btnNewButton)
											.addComponent(textProblema, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
										.addGap(31)))))
						.addComponent(lblNewLabel_4)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSerial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPatrimonio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_12))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNewCheckBox)
						.addComponent(textTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPrestador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13)
						.addComponent(textNF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_10)
						.addComponent(lblNewLabel_11))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textOS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textProblema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnNewButton)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JTextField getTextResponsavel() {
		return textResponsavel;
	}

	public void setTextResponsavel(JTextField textResponsavel) {
		this.textResponsavel = textResponsavel;
	}

	public JTextField getTextSerial() {
		return textSerial;
	}

	public void setTextSerial(JTextField textSerial) {
		this.textSerial = textSerial;
	}

	public JTextField getTextPatrimonio() {
		return textPatrimonio;
	}

	public void setTextPatrimonio(JTextField textPatrimonio) {
		this.textPatrimonio = textPatrimonio;
	}

	public JTextField getTextIdade() {
		return textIdade;
	}

	public void setTextIdade(JTextField textIdade) {
		this.textIdade = textIdade;
	}

	public JTextField getTextModelo() {
		return textModelo;
	}

	public void setTextModelo(JTextField textModelo) {
		this.textModelo = textModelo;
	}

	public JTextField getTextPrestador() {
		return textPrestador;
	}

	public void setTextPrestador(JTextField textPrestador) {
		this.textPrestador = textPrestador;
	}

	public JTextField getTextData() {
		return textData;
	}

	public void setTextData(JTextField textData) {
		this.textData = textData;
	}

	public JTextField getTextValor() {
		return textValor;
	}

	public void setTextValor(JTextField textValor) {
		this.textValor = textValor;
	}

	public JTextField getTextNF() {
		return textNF;
	}

	public void setTextNF(JTextField textNF) {
		this.textNF = textNF;
	}

	public JTextField getTextOS() {
		return textOS;
	}

	public void setTextOS(JTextField textOS) {
		this.textOS = textOS;
	}

	public JTextField getTextProblema() {
		return textProblema;
	}

	public void setTextProblema(JTextField textProblema) {
		this.textProblema = textProblema;
	}

	public JTextField getTextTipo() {
		return textTipo;
	}

	public void setTextTipo(JTextField textTipo) {
		this.textTipo = textTipo;
	}
}

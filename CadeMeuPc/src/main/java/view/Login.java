package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;

	private JTextField loginField;
	private JPasswordField senhaField;
	private LoginController controller;
	
	public JTextField getLoginField() {
		return loginField;
	}
	
	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}
	
	public JPasswordField getSenhaField() {
		return senhaField;
	}
	
	public void setSenhaField(JPasswordField senhaField) {
		this.senhaField = senhaField;
	}
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
					Login frame = new Login();
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
	public Login() {
		controller = new LoginController(this);
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		contentPane.add(panel, BorderLayout.CENTER);
		
		loginField = new JTextField();
		loginField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("senha");
		
		JButton btnNewButton = new JButton("enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.verificarUsuario();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("login");
		
		JLabel lblNewLabel_2 = new JLabel("cad\u00EA meu PC?");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		
		senhaField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(senhaField)
								.addComponent(lblNewLabel)
								.addComponent(loginField))
							.addGap(83)
							.addComponent(btnNewButton)))
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel_2)
					.addGap(29)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(loginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(lblNewLabel)
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(senhaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(203))
		);
		panel.setLayout(gl_panel);
	}
}

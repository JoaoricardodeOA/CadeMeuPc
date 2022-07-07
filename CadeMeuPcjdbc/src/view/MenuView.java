package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuController;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuView extends JFrame {

	private JPanel contentPane;
	private MenuController controller;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
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
	public MenuView() {
		controller = new MenuController(this);
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnNewButton = new JButton("enviar pc");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					controller.abrirEnviar();
				}else if(e.getKeyCode()==e.VK_DOWN) {
				    btnNewButton_2.requestFocus();
				}else if(e.getKeyCode()==e.VK_RIGHT) {
				    btnNewButton_1.requestFocus();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.abrirEnviar();
			}
		});
		
		btnNewButton_1 = new JButton("atualizar");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					controller.abrirAtualizar();
				}else if(e.getKeyCode()==e.VK_LEFT) {
				    btnNewButton.requestFocus();
				}else if(e.getKeyCode()==e.VK_DOWN) {
				    btnNewButton_3.requestFocus();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.abrirAtualizar();
			}
		});
		
		btnNewButton_2 = new JButton("receber");
		btnNewButton_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					controller.abrirReceber();
				}else if(e.getKeyCode()==e.VK_UP) {
				    btnNewButton.requestFocus();
				}else if(e.getKeyCode()==e.VK_RIGHT) {
				    btnNewButton_3.requestFocus();
				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.abrirReceber();
			}
		});
		
		btnNewButton_3 = new JButton("consultar");
		btnNewButton_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					controller.abrirConsulta();
				}else if(e.getKeyCode()==e.VK_LEFT) {
				    btnNewButton_2.requestFocus();
				}else if(e.getKeyCode()==e.VK_UP) {
				    btnNewButton_1.requestFocus();
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.abrirConsulta();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_3))
					.addGap(64))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(52))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
